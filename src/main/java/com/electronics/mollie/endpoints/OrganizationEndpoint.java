package com.electronics.mollie.endpoints;

import com.electronics.mollie.QueryMap;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Organization;

public class OrganizationEndpoint {
    private final MollieHttpClient mollieHttpClient;
    private final ResourceFormatter<Organization> resourceFormatter;

    public OrganizationEndpoint(MollieHttpClient mollieHttpClient, ResourceFormatter<Organization> resourceFormatter) {
        this.mollieHttpClient = mollieHttpClient;
        this.resourceFormatter = resourceFormatter;
    }

    public Organization get(String organizationId) throws MollieException {
        return get(organizationId, new QueryMap());
    }

    public Organization get(String organizationId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/organizations/"+ organizationId + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Organization.class, json);
    }
}
