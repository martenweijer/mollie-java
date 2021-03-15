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

    public Page<Method> all() throws MollieException {
        return all(new QueryMap());
    }

    public Page<Method> all(QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/methods/all"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Method.class, json);
    }
}
