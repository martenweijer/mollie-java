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

    public Payment createByOrder(String orderId, Payment payment) throws MollieException {
        return createByOrder(orderId, payment, new QueryMap());
    }

    public Payment createByOrder(String orderId, Payment payment, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.post("/orders/"+ orderId +"/payments"+ queryMap.toQueryUrl(), resourceFormatter.toJson(payment));
        return resourceFormatter.fromJson(Payment.class, json);
    }

    public Payment createByCustomer(String customerId, Payment payment) throws MollieException {
        return createByCustomer(customerId, payment, new QueryMap());
    }

    public Payment createByCustomer(String customerId, Payment payment, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.post("/customers/"+ customerId +"/payments"+ queryMap.toQueryUrl(), resourceFormatter.toJson(payment));
        return resourceFormatter.fromJson(Payment.class, json);
    }

    public Payment update(String paymentId, Payment payment) throws MollieException {
        return update(paymentId, payment, new QueryMap());
    }

    public Payment update(String paymentId, Payment payment, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.patch("/payments/"+ paymentId + queryMap.toQueryUrl(), resourceFormatter.toJson(payment));
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

    public Page<Payment> bySettlement(String settlementId) throws MollieException {
        return bySettlement(settlementId, new QueryMap());
    }

    public Page<Payment> bySettlement(String settlementId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/settlements/"+ settlementId +"/payments"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Payment.class, json);
    }

    public Page<Payment> byCustomer(String customerId) throws MollieException {
        return bySettlement(customerId, new QueryMap());
    }

    public Page<Payment> byCustomer(String customerId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/customers/"+ customerId +"/payments"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Payment.class, json);
    }

    public Page<Payment> bySubscription(String customerId, String subscriptionId) throws MollieException {
        return bySubscription(customerId, subscriptionId,new QueryMap());
    }

    public Page<Payment> bySubscription(String customerId, String subscriptionId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/customers/"+ customerId +"/subscriptions/"+ subscriptionId +"/payments"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Payment.class, json);
    }
}
