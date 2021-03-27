package com.electronics.mollie.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Permission {
    private String resource;
    private String id;
    private String description;
    private Boolean granted;
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

    public Boolean getGranted() {
        return granted;
    }

    public Links getLinks() {
        return links;
    }
}
