package com.electronics.mollie;

import com.electronics.mollie.endpoints.PaymentEndpoint;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.formatting.SimpleResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.http.SimpleMollieHttpClient;
import com.electronics.mollie.resources.Payment;

public class MollieApiClient {
    private static final String MOLLIE_API_ENDPOINT = "https://api.mollie.com/v2";

    private final MollieHttpClient mollieHttpClient;

    public MollieApiClient(final String apiKey) {
        this.mollieHttpClient = new SimpleMollieHttpClient(MOLLIE_API_ENDPOINT, apiKey);
    }

    public MollieApiClient(MollieHttpClient mollieHttpClient) {
        this.mollieHttpClient = mollieHttpClient;
    }

    public PaymentEndpoint payments() {
        return payments(new SimpleResourceFormatter<>());
    }

    public PaymentEndpoint payments(ResourceFormatter<Payment> resourceFormatter) {
        return new PaymentEndpoint(mollieHttpClient, resourceFormatter);
    }
}