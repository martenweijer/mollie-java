package com.electronics.mollie.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Mandate {
    private String resource;
    private String id;
    private String method;
    private String consumerName;
    private String consumerAccount;
    private String consumerBic;
    private String consumerEmail;
    private String paypalBillingAgreementId;
    private String mode;
    private String status;
    private Details details;
    private String mandateReference;
    private String signatureDate;
    private Date createdAt;
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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerAccount() {
        return consumerAccount;
    }

    public void setConsumerAccount(String consumerAccount) {
        this.consumerAccount = consumerAccount;
    }

    public String getConsumerBic() {
        return consumerBic;
    }

    public void setConsumerBic(String consumerBic) {
        this.consumerBic = consumerBic;
    }

    public String getConsumerEmail() {
        return consumerEmail;
    }

    public void setConsumerEmail(String consumerEmail) {
        this.consumerEmail = consumerEmail;
    }

    public String getPaypalBillingAgreementId() {
        return paypalBillingAgreementId;
    }

    public void setPaypalBillingAgreementId(String paypalBillingAgreementId) {
        this.paypalBillingAgreementId = paypalBillingAgreementId;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public String getMandateReference() {
        return mandateReference;
    }

    public void setMandateReference(String mandateReference) {
        this.mandateReference = mandateReference;
    }

    public String getSignatureDate() {
        return signatureDate;
    }

    public void setSignatureDate(String signatureDate) {
        this.signatureDate = signatureDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
