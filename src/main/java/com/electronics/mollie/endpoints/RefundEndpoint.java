package com.electronics.mollie.endpoints;

import com.electronics.mollie.QueryMap;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Page;
import com.electronics.mollie.resources.Refund;

public class RefundEndpoint {
    private final MollieHttpClient mollieHttpClient;
    private final ResourceFormatter<Refund> resourceFormatter;

    public RefundEndpoint(MollieHttpClient mollieHttpClient, ResourceFormatter<Refund> resourceFormatter) {
        this.mollieHttpClient = mollieHttpClient;
        this.resourceFormatter = resourceFormatter;
    }

    public Refund get(String paymentId, String refundId) throws MollieException {
        return get(paymentId, refundId, new QueryMap());
    }

    public Refund get(String paymentId, String refundId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/payments/"+ paymentId +"/refunds/"+ refundId + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Refund.class, json);
    }

    public Refund create(String paymentId, Refund refund) throws MollieException {
        return create(paymentId, refund, new QueryMap());
    }

    public Refund create(String paymentId, Refund refund, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.post("/payments/"+ paymentId +"/refunds"+ queryMap.toQueryUrl(), resourceFormatter.toJson(refund));
        return resourceFormatter.fromJson(Refund.class, json);
    }

    public Refund createByOrder(String orderId, Refund refund) throws MollieException {
        return createByOrder(orderId, refund, new QueryMap());
    }

    public Refund createByOrder(String orderId, Refund refund, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.post("/orders/"+ orderId +"/refunds"+ queryMap.toQueryUrl(), resourceFormatter.toJson(refund));
        return resourceFormatter.fromJson(Refund.class, json);
    }

    public void cancel(String paymentId, String refundId) throws MollieException {
        cancel(paymentId, refundId, new QueryMap());
    }

    public void cancel(String paymentId, String refundId, QueryMap queryMap) throws MollieException {
        mollieHttpClient.delete("/payments/"+ paymentId +"/refunds/"+ refundId + queryMap.toQueryUrl());
    }

    public Page<Refund> all() throws MollieException {
        return all(new QueryMap());
    }

    public Page<Refund> all(QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/refunds"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Refund.class, json);
    }

    public Page<Refund> bySettlement(String settlementId) throws MollieException {
        return bySettlement(settlementId, new QueryMap());
    }

    public Page<Refund> bySettlement(String settlementId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/settlements/"+ settlementId +"/refunds"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Refund.class, json);
    }

    public Page<Refund> byPayment(String paymentId) throws MollieException {
        return byPayment(paymentId, new QueryMap());
    }

    public Page<Refund> byPayment(String paymentId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/payments/"+ paymentId +"/refunds"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Refund.class, json);
    }

    public Page<Refund> byOrder(String orderId) throws MollieException {
        return byOrder(orderId, new QueryMap());
    }

    public Page<Refund> byOrder(String orderId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/orders/"+ orderId +"/refunds"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Refund.class, json);
    }
}
