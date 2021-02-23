package com.electronics.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIncludeProperties(value = { "id", "description", "amount", "status", "redirectUrl", "checkoutUrl", "_links" })
public class Payment {
    public String id;
    public String description;
    public Amount amount;
    public String status;
    public String redirectUrl;
    @JsonProperty("_links")
    public Links links;
}
