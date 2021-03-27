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

    public String getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public String getConsumerAccount() {
        return consumerAccount;
    }

    public String getConsumerBic() {
        return consumerBic;
    }

    public String getConsumerEmail() {
        return consumerEmail;
    }

    public String getPaypalBillingAgreementId() {
        return paypalBillingAgreementId;
    }

    public String getMode() {
        return mode;
    }

    public String getStatus() {
        return status;
    }

    public Details getDetails() {
        return details;
    }

    public String getMandateReference() {
        return mandateReference;
    }

    public String getSignatureDate() {
        return signatureDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Links getLinks() {
        return links;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public void setConsumerAccount(String consumerAccount) {
        this.consumerAccount = consumerAccount;
    }

    public void setConsumerBic(String consumerBic) {
        this.consumerBic = consumerBic;
    }

    public void setConsumerEmail(String consumerEmail) {
        this.consumerEmail = consumerEmail;
    }

    public void setPaypalBillingAgreementId(String paypalBillingAgreementId) {
        this.paypalBillingAgreementId = paypalBillingAgreementId;
    }
}
