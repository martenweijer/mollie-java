package com.electronics.mollie.endpoints;

import com.electronics.mollie.QueryMap;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Method;
import com.electronics.mollie.resources.Page;

public class MethodEndpoint {
    private final MollieHttpClient mollieHttpClient;
    private final ResourceFormatter<Method> resourceFormatter;

    public MethodEndpoint(MollieHttpClient mollieHttpClient, ResourceFormatter<Method> resourceFormatter) {
        this.mollieHttpClient = mollieHttpClient;
        this.resourceFormatter = resourceFormatter;
    }

    public Method get(String methodId) throws MollieException {
        return get(methodId, new QueryMap());
    }

    public Method get(String methodId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/methods/"+ methodId + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Method.class, json);
    }

    public Method enable(String profileId, String methodId) throws MollieException {
        return enable(profileId, methodId, new QueryMap());
    }

    public Method enable(String profileId, String methodId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.post("/profiles/"+ profileId +"/methods/"+ methodId + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Method.class, json);
    }

    public void disable(String profileId, String methodId) throws MollieException {
        disable(profileId, methodId, new QueryMap());
    }

    public void disable(String profileId, String methodId, QueryMap queryMap) throws MollieException {
        mollieHttpClient.delete("/profiles/"+ profileId +"/methods/"+ methodId + queryMap.toQueryUrl());
    }

    public Page<Method> all() throws MollieException {
        return all(new QueryMap());
    }

    public Page<Method> all(QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/methods/all"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Method.class, json);
    }
}
