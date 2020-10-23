package com.azure.digitaltwins.core;

import com.azure.core.http.HttpClient;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.digitaltwins.core.helpers.UniqueIdHelper;
import com.azure.digitaltwins.core.models.BasicDigitalTwin;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import reactor.test.StepVerifier;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;

import static com.azure.digitaltwins.core.TestHelper.DISPLAY_NAME_WITH_ARGUMENTS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class PublishTelemetryAsyncTests extends PublishTelemetryTestBase {

    private final ClientLogger logger = new ClientLogger(PublishTelemetryAsyncTests.class);

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.digitaltwins.core.TestHelper#getTestParameters")
    @Override
    public void publishTelemetryLifecycleTest(HttpClient httpClient, DigitalTwinsServiceVersion serviceVersion) {
        DigitalTwinsAsyncClient client = getAsyncClient(httpClient, serviceVersion);

        String wifiModelId = UniqueIdHelper.getUniqueModelId(TestAssetDefaults.WIFI_MODEL_ID_PREFIX, client, randomIntegerStringGenerator);
        String roomWithWifiModelId = UniqueIdHelper.getUniqueModelId(TestAssetDefaults.ROOM_WITH_WIFI_MODEL_ID_PREFIX, client, randomIntegerStringGenerator);
        String roomWithWifiTwinId = UniqueIdHelper.getUniqueDigitalTwinId(TestAssetDefaults.ROOM_WITH_WIFI_TWIN_ID_PREFIX, client, randomIntegerStringGenerator);

        try {
            // Create models needed for the digital twin
            createModelsAndTwins(client, wifiModelId, roomWithWifiModelId, roomWithWifiTwinId);

            // Act
            StepVerifier.create(client.publishTelemetryWithResponse(
                roomWithWifiTwinId,
                testResourceNamer.randomUuid(),
                "{\"Telemetry1\": 5}",
                null,
                Context.NONE))
                .assertNext(createResponse -> assertThat(createResponse.getStatusCode())
                    .as("Publish telemetry succeeds")
                    .isEqualTo(HttpURLConnection.HTTP_NO_CONTENT))
                .verifyComplete();

            Dictionary<String, Integer> telemetryPayload = new Hashtable<>();
            telemetryPayload.put("ComponentTelemetry1", 9);

            StepVerifier.create(client.publishComponentTelemetryWithResponse(
                roomWithWifiTwinId,
                TestAssetDefaults.WIFI_COMPONENT_NAME,
                testResourceNamer.randomUuid(),
                telemetryPayload,
                null,
                Context.NONE))
                .assertNext(createResponse -> assertThat(createResponse.getStatusCode())
                    .as("Publish telemetry succeeds")
                    .isEqualTo(HttpURLConnection.HTTP_NO_CONTENT))
                .verifyComplete();
        }
        catch (Exception ex) {
            fail("Failure in executing a step in the test case", ex);
        }
        finally {
            try {
                if (roomWithWifiTwinId != null){
                    client.deleteDigitalTwin(roomWithWifiTwinId).block();
                }
                if (roomWithWifiModelId != null){
                    client.deleteModel(roomWithWifiModelId).block();
                }
                if(wifiModelId != null){
                    client.deleteModel(wifiModelId).block();
                }
            }
            catch (Exception ex) {
                fail("Test cleanup failed", ex);
            }
        }
    }

    private void createModelsAndTwins(DigitalTwinsAsyncClient asyncClient, String wifiModelId, String roomWithWifiModelId, String roomWithWifiTwinId) throws JsonProcessingException {
        String wifiModelPayload = TestAssetsHelper.getWifiModelPayload(wifiModelId);
        String roomWithWifiModelPayload = TestAssetsHelper.getRoomWithWifiModelPayload(roomWithWifiModelId, wifiModelId, TestAssetDefaults.WIFI_COMPONENT_NAME);

        StepVerifier
            .create(asyncClient.createModels(new ArrayList<>(Arrays.asList(wifiModelPayload, roomWithWifiModelPayload))))
            .assertNext(createResponseList -> logger.info("Created models successfully"))
            .verifyComplete();

        String roomWithWifiTwinPayload = TestAssetsHelper.getRoomWithWifiTwinPayload(roomWithWifiModelId, TestAssetDefaults.WIFI_COMPONENT_NAME);

        StepVerifier
            .create(asyncClient.createDigitalTwin(roomWithWifiTwinId, deserializeJsonString(roomWithWifiTwinPayload, BasicDigitalTwin.class), BasicDigitalTwin.class))
            .assertNext(createResponse -> logger.info("Created {} digitalTwin successfully", createResponse))
            .verifyComplete();
    }
}
