package com.electronics.mollie.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Shipment {
    private String resource;
    private String id;
    private String orderId;
    private Date createdAt;
    private List<OrderLine> lines;
    private ShipmentTracking tracking;
    @JsonProperty("_links")
    private Links links;

    public void setLines(List<OrderLine> lines) {
        this.lines = lines;
    }

    public void setTracking(ShipmentTracking tracking) {
        this.tracking = tracking;
    }

    public String getResource() {
        return resource;
    }

    public String getId() {
        return id;
    }

    public String getOrderId() {
        return orderId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    public ShipmentTracking getTracking() {
        return tracking;
    }

    public Links getLinks() {
        return links;
    }
}
