package com.electronics.mollie.endpoints;

import com.electronics.mollie.QueryMap;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Subscription;
import com.electronics.mollie.resources.Page;

public class SubscriptionEndpoint {
    private final MollieHttpClient mollieHttpClient;
    private final ResourceFormatter<Subscription> resourceFormatter;

    public SubscriptionEndpoint(MollieHttpClient mollieHttpClient, ResourceFormatter<Subscription> resourceFormatter) {
        this.mollieHttpClient = mollieHttpClient;
        this.resourceFormatter = resourceFormatter;
    }

    public Subscription get(String customerId, String subscriptionId) throws MollieException {
        return get(customerId, subscriptionId, new QueryMap());
    }

    public Subscription get(String customerId, String subscriptionId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/customers/"+ customerId +"/subscriptions/"+ subscriptionId + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Subscription.class, json);
    }

    public Subscription create(String customerId, Subscription subscription) throws MollieException {
        return create(customerId, subscription, new QueryMap());
    }

    public Subscription create(String customerId, Subscription subscription, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.post("/customers/"+ customerId +"/subscriptions"+ queryMap.toQueryUrl(), resourceFormatter.toJson(subscription));
        return resourceFormatter.fromJson(Subscription.class, json);
    }

    public Subscription cancel(String customerId, String subscriptionId) throws MollieException {
        return cancel(customerId, subscriptionId, new QueryMap());
    }

    public Subscription cancel(String customerId, String subscriptionId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.delete("/customers/"+ customerId +"/subscriptions"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Subscription.class, json);
    }

    public Page<Subscription> all(String customerId) throws MollieException {
        return all(customerId, new QueryMap());
    }

    public Page<Subscription> all(String customerId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/customers/"+ customerId +"/subscriptions"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Subscription.class, json);
    }
}
