package com.electronics.mollie.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Chargeback {
    private String resource;
    private String id;
    private Amount amount;
    private Amount settlementAmount;
    private Date createdAt;
    private Reason reason;
    private Date reversedAt;
    private String paymentId;
    @JsonProperty("_links")
    private Links links;

    public String getResource() {
        return resource;
    }

    public String getId() {
        return id;
    }

    public Amount getAmount() {
        return amount;
    }

    public Amount getSettlementAmount() {
        return settlementAmount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Reason getReason() {
        return reason;
    }

    public Date getReversedAt() {
        return reversedAt;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public Links getLinks() {
        return links;
    }
}
