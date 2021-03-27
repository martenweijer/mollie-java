package com.electronics.mollie.endpoints;

import com.electronics.mollie.QueryMap;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Page;
import com.electronics.mollie.resources.Shipment;

public class ShipmentEndpoint {
    private final MollieHttpClient mollieHttpClient;
    private final ResourceFormatter<Shipment> resourceFormatter;

    public ShipmentEndpoint(MollieHttpClient mollieHttpClient, ResourceFormatter<Shipment> resourceFormatter) {
        this.mollieHttpClient = mollieHttpClient;
        this.resourceFormatter = resourceFormatter;
    }

    public Shipment get(String orderId, String customerId) throws MollieException {
        return get(orderId, customerId, new QueryMap());
    }

    public Shipment get(String orderId, String shipmentId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/orders/"+ orderId +"/shipments/"+ shipmentId + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Shipment.class, json);
    }

    public Shipment create(String orderId, Shipment customer) throws MollieException {
        return create(orderId, customer, new QueryMap());
    }

    public Shipment create(String orderId, Shipment shipment, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.post("/orders/"+ orderId +"/shipments"+ queryMap.toQueryUrl(), resourceFormatter.toJson(shipment));
        return resourceFormatter.fromJson(Shipment.class, json);
    }

    public Shipment update(String orderId, Shipment shipment) throws MollieException {
        return update(orderId, shipment, new QueryMap());
    }

    public Shipment update(String orderId, Shipment shipment, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.patch("/orders/"+ orderId +"/shipments"+ queryMap.toQueryUrl(), resourceFormatter.toJson(shipment));
        return resourceFormatter.fromJson(Shipment.class, json);
    }

    public Page<Shipment> all(String orderId) throws MollieException {
        return all(orderId, new QueryMap());
    }

    public Page<Shipment> all(String orderId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/orders/"+ orderId +"/shipments"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Shipment.class, json);
    }
}
