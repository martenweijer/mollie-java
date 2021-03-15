package com.electronics.mollie.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Invoice {
    private String resource;
    private String id;
    private String reference;
    private String vatNumber;
    private String status;
    private String issuedAt;
    private String paidAt;
    private String dueAt;
    private Amount netAmount;
    private Amount vatAmount;
    private Amount grossAmount;
    private List<InvoiceLine> lines;
    @JsonProperty("_links")
    private Links links;

    public String getResource() {
        return resource;
    }

    public String getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getIssuedAt() {
        return issuedAt;
    }

    public String getPaidAt() {
        return paidAt;
    }

    public String getDueAt() {
        return dueAt;
    }

    public Amount getNetAmount() {
        return netAmount;
    }

    public Amount getVatAmount() {
        return vatAmount;
    }

    public Amount getGrossAmount() {
        return grossAmount;
    }

    public List<InvoiceLine> getLines() {
        return lines;
    }

    public Links getLinks() {
        return links;
    }
}
