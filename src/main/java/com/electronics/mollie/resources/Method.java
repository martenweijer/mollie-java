package com.electronics.mollie.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Method {
    private String resource;
    private String id;
    private String description;
    private Amount minimumAmount;
    private Amount maximumAmount;
    private Image image;
    private String status;
    private List<Pricing> pricing;
    @JsonProperty("_links")
    private Links links;

    public String getResource() {
        return resource;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Amount getMinimumAmount() {
        return minimumAmount;
    }

    public Amount getMaximumAmount() {
        return maximumAmount;
    }

    public Image getImage() {
        return image;
    }

    public String getStatus() {
        return status;
    }

    public List<Pricing> getPricing() {
        return pricing;
    }

    public Links getLinks() {
        return links;
    }
}
