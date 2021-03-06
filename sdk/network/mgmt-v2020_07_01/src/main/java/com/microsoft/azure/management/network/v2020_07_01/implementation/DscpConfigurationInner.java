/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_07_01.implementation;

import java.util.List;
import com.microsoft.azure.management.network.v2020_07_01.QosIpRange;
import com.microsoft.azure.management.network.v2020_07_01.QosPortRange;
import com.microsoft.azure.management.network.v2020_07_01.ProtocolType;
import com.microsoft.azure.management.network.v2020_07_01.ProvisioningState;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.rest.SkipParentValidation;
import com.microsoft.azure.Resource;

/**
 * DSCP Configuration in a resource group.
 */
@JsonFlatten
@SkipParentValidation
public class DscpConfigurationInner extends Resource {
    /**
     * List of markings to be used in the configuration.
     */
    @JsonProperty(value = "properties.markings")
    private List<Integer> markings;

    /**
     * Source IP ranges.
     */
    @JsonProperty(value = "properties.sourceIpRanges")
    private List<QosIpRange> sourceIpRanges;

    /**
     * Destination IP ranges.
     */
    @JsonProperty(value = "properties.destinationIpRanges")
    private List<QosIpRange> destinationIpRanges;

    /**
     * Sources port ranges.
     */
    @JsonProperty(value = "properties.sourcePortRanges")
    private List<QosPortRange> sourcePortRanges;

    /**
     * Destination port ranges.
     */
    @JsonProperty(value = "properties.destinationPortRanges")
    private List<QosPortRange> destinationPortRanges;

    /**
     * RNM supported protocol types. Possible values include: 'DoNotUse',
     * 'Icmp', 'Tcp', 'Udp', 'Gre', 'Esp', 'Ah', 'Vxlan', 'All'.
     */
    @JsonProperty(value = "properties.protocol")
    private ProtocolType protocol;

    /**
     * Qos Collection ID generated by RNM.
     */
    @JsonProperty(value = "properties.qosCollectionId", access = JsonProperty.Access.WRITE_ONLY)
    private String qosCollectionId;

    /**
     * Associated Network Interfaces to the DSCP Configuration.
     */
    @JsonProperty(value = "properties.associatedNetworkInterfaces", access = JsonProperty.Access.WRITE_ONLY)
    private List<NetworkInterfaceInner> associatedNetworkInterfaces;

    /**
     * The resource GUID property of the DSCP Configuration resource.
     */
    @JsonProperty(value = "properties.resourceGuid", access = JsonProperty.Access.WRITE_ONLY)
    private String resourceGuid;

    /**
     * The provisioning state of the DSCP Configuration resource. Possible
     * values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /**
     * A unique read-only string that changes whenever the resource is updated.
     */
    @JsonProperty(value = "etag", access = JsonProperty.Access.WRITE_ONLY)
    private String etag;

    /**
     * Resource ID.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * Get list of markings to be used in the configuration.
     *
     * @return the markings value
     */
    public List<Integer> markings() {
        return this.markings;
    }

    /**
     * Set list of markings to be used in the configuration.
     *
     * @param markings the markings value to set
     * @return the DscpConfigurationInner object itself.
     */
    public DscpConfigurationInner withMarkings(List<Integer> markings) {
        this.markings = markings;
        return this;
    }

    /**
     * Get source IP ranges.
     *
     * @return the sourceIpRanges value
     */
    public List<QosIpRange> sourceIpRanges() {
        return this.sourceIpRanges;
    }

    /**
     * Set source IP ranges.
     *
     * @param sourceIpRanges the sourceIpRanges value to set
     * @return the DscpConfigurationInner object itself.
     */
    public DscpConfigurationInner withSourceIpRanges(List<QosIpRange> sourceIpRanges) {
        this.sourceIpRanges = sourceIpRanges;
        return this;
    }

    /**
     * Get destination IP ranges.
     *
     * @return the destinationIpRanges value
     */
    public List<QosIpRange> destinationIpRanges() {
        return this.destinationIpRanges;
    }

    /**
     * Set destination IP ranges.
     *
     * @param destinationIpRanges the destinationIpRanges value to set
     * @return the DscpConfigurationInner object itself.
     */
    public DscpConfigurationInner withDestinationIpRanges(List<QosIpRange> destinationIpRanges) {
        this.destinationIpRanges = destinationIpRanges;
        return this;
    }

    /**
     * Get sources port ranges.
     *
     * @return the sourcePortRanges value
     */
    public List<QosPortRange> sourcePortRanges() {
        return this.sourcePortRanges;
    }

    /**
     * Set sources port ranges.
     *
     * @param sourcePortRanges the sourcePortRanges value to set
     * @return the DscpConfigurationInner object itself.
     */
    public DscpConfigurationInner withSourcePortRanges(List<QosPortRange> sourcePortRanges) {
        this.sourcePortRanges = sourcePortRanges;
        return this;
    }

    /**
     * Get destination port ranges.
     *
     * @return the destinationPortRanges value
     */
    public List<QosPortRange> destinationPortRanges() {
        return this.destinationPortRanges;
    }

    /**
     * Set destination port ranges.
     *
     * @param destinationPortRanges the destinationPortRanges value to set
     * @return the DscpConfigurationInner object itself.
     */
    public DscpConfigurationInner withDestinationPortRanges(List<QosPortRange> destinationPortRanges) {
        this.destinationPortRanges = destinationPortRanges;
        return this;
    }

    /**
     * Get rNM supported protocol types. Possible values include: 'DoNotUse', 'Icmp', 'Tcp', 'Udp', 'Gre', 'Esp', 'Ah', 'Vxlan', 'All'.
     *
     * @return the protocol value
     */
    public ProtocolType protocol() {
        return this.protocol;
    }

    /**
     * Set rNM supported protocol types. Possible values include: 'DoNotUse', 'Icmp', 'Tcp', 'Udp', 'Gre', 'Esp', 'Ah', 'Vxlan', 'All'.
     *
     * @param protocol the protocol value to set
     * @return the DscpConfigurationInner object itself.
     */
    public DscpConfigurationInner withProtocol(ProtocolType protocol) {
        this.protocol = protocol;
        return this;
    }

    /**
     * Get qos Collection ID generated by RNM.
     *
     * @return the qosCollectionId value
     */
    public String qosCollectionId() {
        return this.qosCollectionId;
    }

    /**
     * Get associated Network Interfaces to the DSCP Configuration.
     *
     * @return the associatedNetworkInterfaces value
     */
    public List<NetworkInterfaceInner> associatedNetworkInterfaces() {
        return this.associatedNetworkInterfaces;
    }

    /**
     * Get the resource GUID property of the DSCP Configuration resource.
     *
     * @return the resourceGuid value
     */
    public String resourceGuid() {
        return this.resourceGuid;
    }

    /**
     * Get the provisioning state of the DSCP Configuration resource. Possible values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     *
     * @return the provisioningState value
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get a unique read-only string that changes whenever the resource is updated.
     *
     * @return the etag value
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Get resource ID.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set resource ID.
     *
     * @param id the id value to set
     * @return the DscpConfigurationInner object itself.
     */
    public DscpConfigurationInner withId(String id) {
        this.id = id;
        return this;
    }

}
