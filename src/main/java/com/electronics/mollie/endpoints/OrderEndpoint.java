package com.electronics.mollie.endpoints;

import com.electronics.mollie.QueryMap;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Order;
import com.electronics.mollie.resources.OrderLine;
import com.electronics.mollie.resources.Page;

public class OrderEndpoint {
    private final MollieHttpClient mollieHttpClient;
    private final ResourceFormatter<Order> resourceFormatter;

    public OrderEndpoint(MollieHttpClient mollieHttpClient, ResourceFormatter<Order> resourceFormatter) {
        this.mollieHttpClient = mollieHttpClient;
        this.resourceFormatter = resourceFormatter;
    }

    public Order get(String orderId) throws MollieException {
        return get(orderId, new QueryMap());
    }

    public Order get(String orderId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/orders/"+ orderId + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Order.class, json);
    }

    public Order create(Order order) throws MollieException {
        return create(order, new QueryMap());
    }

    public Order create(Order order, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.post("/orders"+ queryMap.toQueryUrl(), resourceFormatter.toJson(order));
        return resourceFormatter.fromJson(Order.class, json);
    }

    public Order update(String orderId, Order order) throws MollieException {
        return update(orderId, order, new QueryMap());
    }

    public Order update(String orderId, Order order, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.patch("/orders/"+ orderId + queryMap.toQueryUrl(), resourceFormatter.toJson(order));
        return resourceFormatter.fromJson(Order.class, json);
    }

    public Order cancel(String orderId) throws MollieException {
        return cancel(orderId, new QueryMap());
    }

    public Order cancel(String orderId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.delete("/orders/"+ orderId + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Order.class, json);
    }

    public Page<Order> all() throws MollieException {
        return all(new QueryMap());
    }

    public Page<Order> all(QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/orders"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Order.class, json);
    }

    public void cancelLines(String orderId, Order order) throws MollieException {
        cancelLines(orderId, order, new QueryMap());
    }

    public void cancelLines(String orderId, Order order, QueryMap queryMap) throws MollieException {
        mollieHttpClient.delete("/orders/"+ orderId +"/lines", resourceFormatter.toJson(order));
    }
}
