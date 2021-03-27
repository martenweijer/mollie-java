package com.electronics.mollie.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Organization {
    private String resource;
    private String id;
    private String name;
    private String email;
    private String locale;
    private Address address;
    private String registrationNumber;
    private String vatNumber;
    private String vatRegulation;
    @JsonProperty("_links")
    private Links links;

    public String getResource() {
        return resource;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLocale() {
        return locale;
    }

    public Address getAddress() {
        return address;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public String getVatRegulation() {
        return vatRegulation;
    }

    public Links getLinks() {
        return links;
    }
}
