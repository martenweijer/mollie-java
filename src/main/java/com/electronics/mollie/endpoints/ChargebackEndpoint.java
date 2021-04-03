package com.electronics.mollie.endpoints;

import com.electronics.mollie.QueryMap;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Chargeback;
import com.electronics.mollie.resources.Page;

public class ChargebackEndpoint {
    private final MollieHttpClient mollieHttpClient;
    private final ResourceFormatter<Chargeback> resourceFormatter;

    public ChargebackEndpoint(MollieHttpClient mollieHttpClient, ResourceFormatter<Chargeback> resourceFormatter) {
        this.mollieHttpClient = mollieHttpClient;
        this.resourceFormatter = resourceFormatter;
    }

    public Chargeback get(String paymentId, String chargebackId) throws MollieException {
        return get(paymentId, chargebackId, new QueryMap());
    }

    public Chargeback get(String paymentId, String chargebackId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/payments/"+ paymentId +"/chargebacks/"+ chargebackId + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Chargeback.class, json);
    }

    public Page<Chargeback> all(String paymentId) throws MollieException {
        return all(paymentId, new QueryMap());
    }

    public Page<Chargeback> all(String paymentId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/payments/"+ paymentId +"/chargebacks"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Chargeback.class, json);
    }

    public Page<Chargeback> bySettlement(String settlementId) throws MollieException {
        return bySettlement(settlementId, new QueryMap());
    }

    public Page<Chargeback> bySettlement(String settlementId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/settlements/"+ settlementId +"/chargebacks"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Chargeback.class, json);
    }
}
