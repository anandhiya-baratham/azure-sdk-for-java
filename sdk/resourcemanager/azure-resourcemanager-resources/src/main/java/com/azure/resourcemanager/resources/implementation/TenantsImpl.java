// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.resourcemanager.resources.implementation;

import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.resourcemanager.resources.models.Tenant;
import com.azure.resourcemanager.resources.models.Tenants;
import com.azure.resourcemanager.resources.fluent.models.TenantIdDescriptionInner;
import com.azure.resourcemanager.resources.fluent.TenantsClient;

/**
 * Implementation for {@link Tenants}.
 */
public final class TenantsImpl
        implements Tenants {
    private final TenantsClient client;

    public TenantsImpl(final TenantsClient client) {
        this.client = client;
    }

    @Override
    public PagedIterable<Tenant> list() {
        return client.list().mapPage(this::wrapModel);
    }

    @Override
    public PagedFlux<Tenant> listAsync() {
        return client.listAsync().mapPage(this::wrapModel);
    }

    private TenantImpl wrapModel(TenantIdDescriptionInner tenantIdDescriptionInner) {
        if (tenantIdDescriptionInner == null) {
            return null;
        }
        return new TenantImpl(tenantIdDescriptionInner);
    }
}
