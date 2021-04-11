package com.electronics.mollie;

import com.electronics.mollie.endpoints.*;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.formatting.SimpleResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.http.SimpleMollieHttpClient;
import com.electronics.mollie.resources.*;

public class MollieApiClient {
    private static final String MOLLIE_API_ENDPOINT = "https://api.mollie.com/v2";

    private final MollieHttpClient mollieHttpClient;

    public MollieApiClient(final String apiKey) {
        this.mollieHttpClient = new SimpleMollieHttpClient(MOLLIE_API_ENDPOINT, apiKey);
    }

    public MollieApiClient(MollieHttpClient mollieHttpClient) {
        this.mollieHttpClient = mollieHttpClient;
    }

    /**
     * Payments API.
     * @return The payment API endpoint
     */
    public PaymentEndpoint payments() {
        return payments(new SimpleResourceFormatter<>());
    }

    /**
     * Payments API.
     * @param resourceFormatter Custom resource formatter
     * @return The payments API endpoint
     */
    public PaymentEndpoint payments(ResourceFormatter<Payment> resourceFormatter) {
        return new PaymentEndpoint(mollieHttpClient, resourceFormatter);
    }

    /**
     * Methods API.
     * @return The methods API endpoint
     */
    public MethodEndpoint methods() {
        return methods(new SimpleResourceFormatter<>());
    }

    /**
     * Methods API.
     * @param resourceFormatter Custom resource formatter
     * @return The methods API endpoint
     */
    public MethodEndpoint methods(ResourceFormatter<Method> resourceFormatter) {
        return new MethodEndpoint(mollieHttpClient, resourceFormatter);
    }

    /**
     * Invoices API.
     * @return The invoices API endpoint
     */
    public InvoiceEndpoint invoices() {
        return invoices(new SimpleResourceFormatter<>());
    }

    /**
     * Invoices API.
     * @param resourceFormatter Custom resource formatter
     * @return The invoices API endpoint
     */
    public InvoiceEndpoint invoices(ResourceFormatter<Invoice> resourceFormatter) {
        return new InvoiceEndpoint(mollieHttpClient, resourceFormatter);
    }

    /**
     * Onboarding API.
     * @return The onboarding API endpoint
     */
    public OnboardingEndpoint onboarding() {
        return onboarding(new SimpleResourceFormatter<>());
    }

    /**
     * Onboarding API.
     * @param resourceFormatter Custom resource formatter
     * @return The onboarding API endpoint
     */
    public OnboardingEndpoint onboarding(ResourceFormatter<Onboarding> resourceFormatter) {
        return new OnboardingEndpoint(mollieHttpClient, resourceFormatter);
    }

    /**
     * Chargebacks API.
     * @return The chargebacks API endpoint
     */
    public ChargebackEndpoint chargebacks() {
        return chargebacks(new SimpleResourceFormatter<>());
    }

    /**
     * Chargebacks API.
     * @param resourceFormatter Custom resource formatter
     * @return The chargebacks API endpoint
     */
    public ChargebackEndpoint chargebacks(ResourceFormatter<Chargeback> resourceFormatter) {
        return new ChargebackEndpoint(mollieHttpClient, resourceFormatter);
    }

    /**
     * Permissions API.
     * @return The permissions API endpoint
     */
    public PermissionEndpoint permissions() {
        return permissions(new SimpleResourceFormatter<>());
    }

    /**
     * Permissions API.
     * @param resourceFormatter Custom resource formatter
     * @return The permissions API endpoint
     */
    public PermissionEndpoint permissions(ResourceFormatter<Permission> resourceFormatter) {
        return new PermissionEndpoint(mollieHttpClient, resourceFormatter);
    }

    /**
     * Organizations API.
     * @return The organizations API endpoint
     */
    public OrganizationEndpoint organizations() {
        return organizations(new SimpleResourceFormatter<>());
    }

    /**
     * Organizations API.
     * @param resourceFormatter Custom resource formatter
     * @return The organizations API endpoint
     */
    public OrganizationEndpoint organizations(ResourceFormatter<Organization> resourceFormatter) {
        return new OrganizationEndpoint(mollieHttpClient, resourceFormatter);
    }

    /**
     * Mandates API.
     * @return The mandates API endpoint
     */
    public MandateEndpoint mandates() {
        return mandates(new SimpleResourceFormatter<>());
    }

    /**
     * Mandates API.
     * @param resourceFormatter Custom resource formatter
     * @return The mandates API endpoint
     */
    public MandateEndpoint mandates(ResourceFormatter<Mandate> resourceFormatter) {
        return new MandateEndpoint(mollieHttpClient, resourceFormatter);
    }

    /**
     * Customers API.
     * @return The customers API endpoint
     */
    public CustomerEndpoint customers() {
        return customers(new SimpleResourceFormatter<>());
    }

    /**
     * Customers API.
     * @param resourceFormatter Custom resource formatter
     * @return The customers API endpoint
     */
    public CustomerEndpoint customers(ResourceFormatter<Customer> resourceFormatter) {
        return new CustomerEndpoint(mollieHttpClient, resourceFormatter);
    }

    /**
     * Shipments API.
     * @return The shipments API endpoint
     */
    public ShipmentEndpoint shipments() {
        return shipments(new SimpleResourceFormatter<>());
    }

    /**
     * Shipments API.
     * @param resourceFormatter Custom resource formatter
     * @return The shipments API endpoint
     */
    public ShipmentEndpoint shipments(ResourceFormatter<Shipment> resourceFormatter) {
        return new ShipmentEndpoint(mollieHttpClient, resourceFormatter);
    }

    /**
     * Orders API.
     * @return The orders API endpoint
     */
    public OrderEndpoint orders() {
        return orders(new SimpleResourceFormatter<>());
    }

    /**
     * Orders API.
     * @param resourceFormatter Custom resource formatter
     * @return The orders API endpoint
     */
    public OrderEndpoint orders(ResourceFormatter<Order> resourceFormatter) {
        return new OrderEndpoint(mollieHttpClient, resourceFormatter);
    }

    /**
     * Refunds API.
     * @return The refunds API endpoint
     */
    public RefundEndpoint refunds() {
        return refunds(new SimpleResourceFormatter<>());
    }

    /**
     * Refunds API.
     * @param resourceFormatter Custom resource formatter
     * @return The refunds API endpoint
     */
    public RefundEndpoint refunds(ResourceFormatter<Refund> resourceFormatter) {
        return new RefundEndpoint(mollieHttpClient, resourceFormatter);
    }

    /**
     * Subscriptions API.
     * @return The subscriptions API endpoint
     */
    public SubscriptionEndpoint subscriptions() {
        return subscriptions(new SimpleResourceFormatter<>());
    }

    /**
     * Subscriptions API.
     * @param resourceFormatter Custom resource formatter
     * @return The subscriptions API endpoint
     */
    public SubscriptionEndpoint subscriptions(ResourceFormatter<Subscription> resourceFormatter) {
        return new SubscriptionEndpoint(mollieHttpClient, resourceFormatter);
    }

    /**
     * Settlements API.
     * @return The settlements API endpoint
     */
    public SettlementEndpoint settlements() {
        return settlements(new SimpleResourceFormatter<>());
    }

    /**
     * Settlements API.
     * @param resourceFormatter Custom resource formatter
     * @return The settlements API endpoint
     */
    public SettlementEndpoint settlements(ResourceFormatter<Settlement> resourceFormatter) {
        return new SettlementEndpoint(mollieHttpClient, resourceFormatter);
    }

    /**
     * Captures API.
     * @return The captures API endpoint
     */
    public CaptureEndpoint captures() {
        return captures(new SimpleResourceFormatter<>());
    }

    /**
     * Captures API.
     * @param resourceFormatter Custom resource formatter
     * @return The captures API endpoint
     */
    public CaptureEndpoint captures(ResourceFormatter<Capture> resourceFormatter) {
        return new CaptureEndpoint(mollieHttpClient, resourceFormatter);
    }

    /**
     * Profiles API.
     * @return The profiles API endpoint
     */
    public ProfileEndpoint profiles() {
        return profiles(new SimpleResourceFormatter<>());
    }

    /**
     * Profiles API.
     * @param resourceFormatter Custom resource formatter
     * @return The profiles API endpoint
     */
    public ProfileEndpoint profiles(ResourceFormatter<Profile> resourceFormatter) {
        return new ProfileEndpoint(mollieHttpClient, resourceFormatter);
    }

    /**
     * Issuer API.
     * @return The issuer API endpoint
     */
    public IssuerEndpoint issuer() {
        return issuer(new SimpleResourceFormatter<>());
    }

    /**
     * Issuer API.
     * @param resourceFormatter Custom resource formatter
     * @return The issuer API endpoint
     */
    public IssuerEndpoint issuer(ResourceFormatter<Issuer> resourceFormatter) {
        return new IssuerEndpoint(mollieHttpClient, resourceFormatter);
    }
}
