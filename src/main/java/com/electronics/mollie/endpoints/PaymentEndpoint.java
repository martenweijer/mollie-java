package com.electronics.mollie.endpoints;

import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Payment;

public class PaymentEndpoint {
    private final MollieHttpClient mollieHttpClient;
    private final ResourceFormatter<Payment> resourceFormatter;

    public PaymentEndpoint(MollieHttpClient mollieHttpClient, ResourceFormatter<Payment> resourceFormatter) {
        this.mollieHttpClient = mollieHttpClient;
        this.resourceFormatter = resourceFormatter;
    }

    public Payment get(String paymentId) throws MollieException {
        String json = mollieHttpClient.get("/payments/"+ paymentId);
        return resourceFormatter.fromJson(Payment.class, json);
    }

    public Payment create(Payment payment) throws MollieException {
        String json = mollieHttpClient.post("/payments", resourceFormatter.toJson(payment));
        return resourceFormatter.fromJson(Payment.class, json);
    }

    public Payment cancel(String paymentId) throws MollieException {
        String json = mollieHttpClient.delete("/payments/"+ paymentId);
        return resourceFormatter.fromJson(Payment.class, json);
    }
}
