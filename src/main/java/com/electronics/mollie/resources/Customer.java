package com.electronics.mollie.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Customer {
    private String resource;
    private String id;
    private String mode;
    private String name;
    private String email;
    private String locale;
    private Object metadata;
    private Date createdAt;
    @JsonProperty("_links")
    private Links links;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public String getId() {
        return id;
    }
}
