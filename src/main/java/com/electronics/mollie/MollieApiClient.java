package com.electronics.mollie;

import com.electronics.mollie.endpoints.InvoiceEndpoint;
import com.electronics.mollie.endpoints.MethodEndpoint;
import com.electronics.mollie.endpoints.OnboardingEndpoint;
import com.electronics.mollie.endpoints.PaymentEndpoint;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.formatting.SimpleResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.http.SimpleMollieHttpClient;
import com.electronics.mollie.resources.Invoice;
import com.electronics.mollie.resources.Method;
import com.electronics.mollie.resources.Onboarding;
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

    public MethodEndpoint methods() {
        return methods(new SimpleResourceFormatter<>());
    }

    public MethodEndpoint methods(ResourceFormatter<Method> resourceFormatter) {
        return new MethodEndpoint(mollieHttpClient, resourceFormatter);
    }

    public InvoiceEndpoint invoices() {
        return invoices(new SimpleResourceFormatter<>());
    }

    public InvoiceEndpoint invoices(ResourceFormatter<Invoice> resourceFormatter) {
        return new InvoiceEndpoint(mollieHttpClient, resourceFormatter);
    }

    public OnboardingEndpoint onboarding() {
        return onboarding(new SimpleResourceFormatter<>());
    }

    public OnboardingEndpoint onboarding(ResourceFormatter<Onboarding> resourceFormatter) {
        return new OnboardingEndpoint(mollieHttpClient, resourceFormatter);
    }
}
