package com.electronics.mollie.endpoints;

import com.electronics.mollie.QueryMap;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Page;
import com.electronics.mollie.resources.Permission;

public class PermissionEndpoint {
    private final MollieHttpClient mollieHttpClient;
    private final ResourceFormatter<Permission> resourceFormatter;

    public PermissionEndpoint(MollieHttpClient mollieHttpClient, ResourceFormatter<Permission> resourceFormatter) {
        this.mollieHttpClient = mollieHttpClient;
        this.resourceFormatter = resourceFormatter;
    }

    public Permission get(String permissionId) throws MollieException {
        return get(permissionId, new QueryMap());
    }

    public Permission get(String permissionId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/permissions/"+ permissionId + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Permission.class, json);
    }

    public Page<Permission> all() throws MollieException {
        return all(new QueryMap());
    }

    public Page<Permission> all(QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/permissions"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Permission.class, json);
    }
}
