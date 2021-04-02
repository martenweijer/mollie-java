package com.electronics.mollie.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Capture {
    private String resource;
    private String id;
    private String mode;
    private Amount amount;
    private Amount settlementAmount;
    private String paymentId;
    private String shipmentId;
    private String settlementId;
    private Date createdAt;
    @JsonProperty("_links")
    private Links links;

    public String getId() {
        return id;
    }
}
