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

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSignedUpAt() {
        return signedUpAt;
    }

    public void setSignedUpAt(Date signedUpAt) {
        this.signedUpAt = signedUpAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getCanReceivePayments() {
        return canReceivePayments;
    }

    public void setCanReceivePayments(Boolean canReceivePayments) {
        this.canReceivePayments = canReceivePayments;
    }

    public Boolean getCanReceiveSettlements() {
        return canReceiveSettlements;
    }

    public void setCanReceiveSettlements(Boolean canReceiveSettlements) {
        this.canReceiveSettlements = canReceiveSettlements;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
