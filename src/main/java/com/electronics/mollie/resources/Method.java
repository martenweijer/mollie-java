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

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Amount getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(Amount minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public Amount getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(Amount maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Pricing> getPricing() {
        return pricing;
    }

    public void setPricing(List<Pricing> pricing) {
        this.pricing = pricing;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
