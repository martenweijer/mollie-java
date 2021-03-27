package com.electronics.mollie.endpoints;

import com.electronics.mollie.QueryMap;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Mandate;
import com.electronics.mollie.resources.Page;

public class MandateEndpoint {
    private final MollieHttpClient mollieHttpClient;
    private final ResourceFormatter<Mandate> resourceFormatter;

    public MandateEndpoint(MollieHttpClient mollieHttpClient, ResourceFormatter<Mandate> resourceFormatter) {
        this.mollieHttpClient = mollieHttpClient;
        this.resourceFormatter = resourceFormatter;
    }

    public Mandate get(String customerId, String mandateId) throws MollieException {
        return get(customerId, mandateId, new QueryMap());
    }

    public Mandate get(String customerId, String mandateId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/customers/"+ customerId +"/mandates/"+ mandateId + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Mandate.class, json);
    }

    public Mandate create(Mandate mandate, String customerId) throws MollieException {
        return create(mandate, customerId, new QueryMap());
    }

    public Mandate create(Mandate mandate, String customerId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.post("/customers/"+ customerId +"/mandates"+ queryMap.toQueryUrl(), resourceFormatter.toJson(mandate));
        return resourceFormatter.fromJson(Mandate.class, json);
    }

    public void revoke(String customerId, String mandateId) throws MollieException {
        revoke(customerId, mandateId, new QueryMap());
    }

    public void revoke(String customerId, String mandateId, QueryMap queryMap) throws MollieException {
        mollieHttpClient.delete("/customers/"+ customerId +"/mandates/"+ mandateId + queryMap.toQueryUrl());
    }

    public Page<Mandate> all(String customerId) throws MollieException {
        return all(customerId, new QueryMap());
    }

    public Page<Mandate> all(String customerId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/customers/"+ customerId +"/mandates"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Mandate.class, json);
    }
}
