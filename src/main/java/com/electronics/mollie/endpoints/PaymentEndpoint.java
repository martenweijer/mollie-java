package com.electronics.mollie.endpoints;

import com.electronics.mollie.QueryMap;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Page;
import com.electronics.mollie.resources.Payment;

public class PaymentEndpoint {
    private final MollieHttpClient mollieHttpClient;
    private final ResourceFormatter<Payment> resourceFormatter;

    public PaymentEndpoint(MollieHttpClient mollieHttpClient, ResourceFormatter<Payment> resourceFormatter) {
        this.mollieHttpClient = mollieHttpClient;
        this.resourceFormatter = resourceFormatter;
    }

    public Payment get(String paymentId) throws MollieException {
        return get(paymentId, new QueryMap());
    }

    public Payment get(String paymentId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/payments/"+ paymentId + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Payment.class, json);
    }

    public Payment create(Payment payment) throws MollieException {
        return create(payment, new QueryMap());
    }

    public Payment create(Payment payment, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.post("/payments"+ queryMap.toQueryUrl(), resourceFormatter.toJson(payment));
        return resourceFormatter.fromJson(Payment.class, json);
    }

    public Payment cancel(String paymentId) throws MollieException {
        return cancel(paymentId, new QueryMap());
    }

    public Payment cancel(String paymentId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.delete("/payments/"+ paymentId + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Payment.class, json);
    }

    public Page<Payment> page() throws MollieException {
        return page(new QueryMap());
    }

    public Page<Payment> page(QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/payments"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Payment.class, json);
    }
}
