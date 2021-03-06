// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.administration.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/** The UpdateNumberCapabilitiesRequest model. */
@Fluent
public final class UpdateNumberCapabilitiesRequest {
    /*
     * The map of phone numbers to the capabilities update applied to the phone
     * number.
     */
    @JsonProperty(value = "phoneNumberCapabilitiesUpdate", required = true)
    private Map<String, NumberUpdateCapabilities> phoneNumberCapabilitiesUpdate;

    /**
     * Get the phoneNumberCapabilitiesUpdate property: The map of phone numbers to the capabilities update applied to
     * the phone number.
     *
     * @return the phoneNumberCapabilitiesUpdate value.
     */
    public Map<String, NumberUpdateCapabilities> getPhoneNumberCapabilitiesUpdate() {
        return this.phoneNumberCapabilitiesUpdate;
    }

    /**
     * Set the phoneNumberCapabilitiesUpdate property: The map of phone numbers to the capabilities update applied to
     * the phone number.
     *
     * @param phoneNumberCapabilitiesUpdate the phoneNumberCapabilitiesUpdate value to set.
     * @return the UpdateNumberCapabilitiesRequest object itself.
     */
    public UpdateNumberCapabilitiesRequest setPhoneNumberCapabilitiesUpdate(
            Map<String, NumberUpdateCapabilities> phoneNumberCapabilitiesUpdate) {
        this.phoneNumberCapabilitiesUpdate = phoneNumberCapabilitiesUpdate;
        return this;
    }
}
