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

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(String issuedAt) {
        this.issuedAt = issuedAt;
    }

    public String getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(String paidAt) {
        this.paidAt = paidAt;
    }

    public String getDueAt() {
        return dueAt;
    }

    public void setDueAt(String dueAt) {
        this.dueAt = dueAt;
    }

    public Amount getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Amount netAmount) {
        this.netAmount = netAmount;
    }

    public Amount getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(Amount vatAmount) {
        this.vatAmount = vatAmount;
    }

    public Amount getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(Amount grossAmount) {
        this.grossAmount = grossAmount;
    }

    public List<InvoiceLine> getLines() {
        return lines;
    }

    public void setLines(List<InvoiceLine> lines) {
        this.lines = lines;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
