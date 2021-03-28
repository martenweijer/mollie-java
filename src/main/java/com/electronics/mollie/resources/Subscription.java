package com.electronics.mollie.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Subscription {
    private String resource;
    private String id;
    private String mode;
    private Date createdAt;
    private String status;
    private Amount amount;
    private Integer times;
    private Integer timesRemaining;
    private String interval;
    private Date startDate;
    private Date nextPaymentDate;
    private String description;
    private String method;
    private String mandateId;
    private Date canceledAt;
    private String webhookUrl;
    private Object metadata;
    private ApplicationFee applicationFee;
    @JsonProperty("_links")
    private Links links;

    public String getId() {
        return id;
    }
}
