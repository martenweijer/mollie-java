package com.electronics.mollie.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Refund {
    private String resource;
    private String id;
    private String mode;
    private String name;
    private String email;
    private String locale;
    private Amount amount;
    private String settlementId;
    private Amount settlementAmount;
    private String description;
    private Object metadata;
    private String status;
    private List<OrderLine> lines;
    private String paymentId;
    private String orderId;
    private Date createdAt;
    @JsonProperty("_links")
    private Links links;

    public String getId() {
        return id;
    }
}
