package com.electronics.mollie.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Onboarding {
    private String resource;
    private String name;
    private Date signedUpAt;
    private String status;
    private Boolean canReceivePayments;
    private Boolean canReceiveSettlements;
    @JsonProperty("_links")
    private Links links;
    private Organization organization;

    public String getResource() {
        return resource;
    }

    public String getName() {
        return name;
    }

    public Date getSignedUpAt() {
        return signedUpAt;
    }

    public String getStatus() {
        return status;
    }

    public Boolean isCanReceivePayments() {
        return canReceivePayments;
    }

    public Boolean isCanReceiveSettlements() {
        return canReceiveSettlements;
    }

    public Links getLinks() {
        return links;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
