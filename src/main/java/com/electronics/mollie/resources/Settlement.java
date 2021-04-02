package com.electronics.mollie.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Map;

public class Settlement {
    private String resource;
    private String id;
    private String reference;
    private Date createdAt;
    private Date settledAt;
    private String status;
    private Amount amount;
    private Map<Integer, Map<Integer, Period>> periods;
    private String invoiceId;
    @JsonProperty("_links")
    private Links links;

    public String getId() {
        return id;
    }
}
