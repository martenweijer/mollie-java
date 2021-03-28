package com.electronics.mollie.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Order {
    private String resource;
    private String id;
    private String profileId;
    private String method;
    private String mode;
    private Amount amount;
    private Amount amountCaptured;
    private Amount amountRefunded;
    private String status;
    private Boolean isCancelable;
    private Address billingAddress;
    private Boolean shopperCountryMustMatchBillingCountry;
    private Date consumerDateOfBirth;
    private String orderNumber;
    private Address shippingAddress;
    private String locale;
    private Object metadata;
    private String redirectUrl;
    private String webhookUrl;
    private Date createdAt;
    private Date expiresAt;
    private Date expiredAt;
    private Date paidAt;
    private Date authorizedAt;
    private Date canceledAt;
    private Date completedAt;
    @JsonProperty("_links")
    private Links links;
    private List<OrderLine> lines;
    private Embedded _embedded;

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setLines(List<OrderLine> lines) {
        this.lines = lines;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getId() {
        return id;
    }

    @JsonIgnore
    public List<Payment> getPayments() {
        return _embedded.getPayments();
    }

    @JsonIgnore
    public List<Refund> getRefunds() {
        return _embedded.getRefunds();
    }
}
