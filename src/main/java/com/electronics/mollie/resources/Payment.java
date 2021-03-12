package com.electronics.mollie.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Payment {
    private String resource;
    private String id;
    private String mode;
    private Date createdAt;
    private String status;
    @JsonIgnore
    private boolean isCancelable;
    private Date authorizedAt;
    private Date paidAt;
    private Date canceledAt;
    private Date expiresAt;
    private Date expiredAt;
    private Date failedAt;
    private Amount amount;
    private Amount amountRefunded;
    private Amount amountRemaining;
    private Amount amountCaptured;
    private Amount amountChargedBack;
    private String description;
    private String redirectUrl;
    private String webhookUrl;
    private String method;
    private Object metadata;
    private String locale;
    private String restrictPaymentMethodsToCountry;
    private String countryCode;
    private String profileId;
    private Amount settlementAmount;
    private String settlementId;
    private String customerId;
    private String sequenceType;
    private String mandateId;
    private String subscriptionId;
    private String orderId;
    private ApplicationFee applicationFee;
    @JsonProperty("_links")
    private Links links;
    private Details details;

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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getIsCancelable() {
        return isCancelable;
    }

    public void setIsCancelable(boolean isCancelable) {
        this.isCancelable = isCancelable;
    }

    public Date getAuthorizedAt() {
        return authorizedAt;
    }

    public void setAuthorizedAt(Date authorizedAt) {
        this.authorizedAt = authorizedAt;
    }

    public Date getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(Date paidAt) {
        this.paidAt = paidAt;
    }

    public Date getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(Date canceledAt) {
        this.canceledAt = canceledAt;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Date getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
    }

    public Date getFailedAt() {
        return failedAt;
    }

    public void setFailedAt(Date failedAt) {
        this.failedAt = failedAt;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Amount getAmountRefunded() {
        return amountRefunded;
    }

    public void setAmountRefunded(Amount amountRefunded) {
        this.amountRefunded = amountRefunded;
    }

    public Amount getAmountRemaining() {
        return amountRemaining;
    }

    public void setAmountRemaining(Amount amountRemaining) {
        this.amountRemaining = amountRemaining;
    }

    public Amount getAmountCaptured() {
        return amountCaptured;
    }

    public void setAmountCaptured(Amount amountCaptured) {
        this.amountCaptured = amountCaptured;
    }

    public Amount getAmountChargedBack() {
        return amountChargedBack;
    }

    public void setAmountChargedBack(Amount amountChargedBack) {
        this.amountChargedBack = amountChargedBack;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getWebhookUrl() {
        return webhookUrl;
    }

    public void setWebhookUrl(String webhookUrl) {
        this.webhookUrl = webhookUrl;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getRestrictPaymentMethodsToCountry() {
        return restrictPaymentMethodsToCountry;
    }

    public void setRestrictPaymentMethodsToCountry(String restrictPaymentMethodsToCountry) {
        this.restrictPaymentMethodsToCountry = restrictPaymentMethodsToCountry;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public Amount getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(Amount settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    public String getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(String settlementId) {
        this.settlementId = settlementId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSequenceType() {
        return sequenceType;
    }

    public void setSequenceType(String sequenceType) {
        this.sequenceType = sequenceType;
    }

    public String getMandateId() {
        return mandateId;
    }

    public void setMandateId(String mandateId) {
        this.mandateId = mandateId;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ApplicationFee getApplicationFee() {
        return applicationFee;
    }

    public void setApplicationFee(ApplicationFee applicationFee) {
        this.applicationFee = applicationFee;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }
}
