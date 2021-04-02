package com.electronics.mollie.endpoints;

import com.electronics.mollie.QueryMap;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Page;
import com.electronics.mollie.resources.Settlement;

public class SettlementEndpoint {
    private final MollieHttpClient mollieHttpClient;
    private final ResourceFormatter<Settlement> resourceFormatter;

    public SettlementEndpoint(MollieHttpClient mollieHttpClient, ResourceFormatter<Settlement> resourceFormatter) {
        this.mollieHttpClient = mollieHttpClient;
        this.resourceFormatter = resourceFormatter;
    }

    public Settlement get(String settlementId) throws MollieException {
        return get(settlementId, new QueryMap());
    }

    public Settlement get(String settlementId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/settlements/"+ settlementId + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Settlement.class, json);
    }

    public Page<Settlement> all() throws MollieException {
        return all(new QueryMap());
    }

    public Page<Settlement> all(QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/settlements"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Settlement.class, json);
    }
}
