package com.electronics.mollie.resources;

import java.util.Date;
import java.util.List;

public class Details {
    private String cardHolder;
    private String cardNumber;
    private String cardFingerprint;
    private String cardAudience;
    private String cardLabel;
    private String cardCountryCode;
    private String cardSecurity;
    private String feeRegion;
    private String bankName;
    private String bankAccount;
    private String bankBic;
    private String transferReference;
    private String creditorIdentifier;
    private String consumerName;
    private String consumerAccount;
    private String consumerBic;
    private String customerReference;
    private String billingEmail;
    private String failureReason;
    private String failureMessage;
    private String wallet;
    private String voucherNumber;
    private List<GiftCard> giftcards;
    private Amount remainderAmount;
    private String remainderMethod;
    private String paypalReference;
    private String paypalPayerId;
    private String sellerProtection;
    private Address shippingAddress;
    private Amount paypalFee;
    private Date dueDate;
    private Date signatureDate;
    private String bankReasonCode;
    private String bankReason;
    private String endToEndIdentifier;
    private String mandateReference;
    private String batchReference;
    private String fileReference;
    private String issuer;
    private List<Voucher> vouchers;

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardFingerprint() {
        return cardFingerprint;
    }

    public void setCardFingerprint(String cardFingerprint) {
        this.cardFingerprint = cardFingerprint;
    }

    public String getCardAudience() {
        return cardAudience;
    }

    public void setCardAudience(String cardAudience) {
        this.cardAudience = cardAudience;
    }

    public String getCardLabel() {
        return cardLabel;
    }

    public void setCardLabel(String cardLabel) {
        this.cardLabel = cardLabel;
    }

    public String getCardCountryCode() {
        return cardCountryCode;
    }

    public void setCardCountryCode(String cardCountryCode) {
        this.cardCountryCode = cardCountryCode;
    }

    public String getCardSecurity() {
        return cardSecurity;
    }

    public void setCardSecurity(String cardSecurity) {
        this.cardSecurity = cardSecurity;
    }

    public String getFeeRegion() {
        return feeRegion;
    }

    public void setFeeRegion(String feeRegion) {
        this.feeRegion = feeRegion;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankBic() {
        return bankBic;
    }

    public void setBankBic(String bankBic) {
        this.bankBic = bankBic;
    }

    public String getTransferReference() {
        return transferReference;
    }

    public void setTransferReference(String transferReference) {
        this.transferReference = transferReference;
    }

    public String getCreditorIdentifier() {
        return creditorIdentifier;
    }

    public void setCreditorIdentifier(String creditorIdentifier) {
        this.creditorIdentifier = creditorIdentifier;
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

    public String getCustomerReference() {
        return customerReference;
    }

    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public List<GiftCard> getGiftcards() {
        return giftcards;
    }

    public void setGiftcards(List<GiftCard> giftcards) {
        this.giftcards = giftcards;
    }

    public Amount getRemainderAmount() {
        return remainderAmount;
    }

    public void setRemainderAmount(Amount remainderAmount) {
        this.remainderAmount = remainderAmount;
    }

    public String getRemainderMethod() {
        return remainderMethod;
    }

    public void setRemainderMethod(String remainderMethod) {
        this.remainderMethod = remainderMethod;
    }

    public String getPaypalReference() {
        return paypalReference;
    }

    public void setPaypalReference(String paypalReference) {
        this.paypalReference = paypalReference;
    }

    public String getPaypalPayerId() {
        return paypalPayerId;
    }

    public void setPaypalPayerId(String paypalPayerId) {
        this.paypalPayerId = paypalPayerId;
    }

    public String getSellerProtection() {
        return sellerProtection;
    }

    public void setSellerProtection(String sellerProtection) {
        this.sellerProtection = sellerProtection;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Amount getPaypalFee() {
        return paypalFee;
    }

    public void setPaypalFee(Amount paypalFee) {
        this.paypalFee = paypalFee;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getSignatureDate() {
        return signatureDate;
    }

    public void setSignatureDate(Date signatureDate) {
        this.signatureDate = signatureDate;
    }

    public String getBankReasonCode() {
        return bankReasonCode;
    }

    public void setBankReasonCode(String bankReasonCode) {
        this.bankReasonCode = bankReasonCode;
    }

    public String getBankReason() {
        return bankReason;
    }

    public void setBankReason(String bankReason) {
        this.bankReason = bankReason;
    }

    public String getEndToEndIdentifier() {
        return endToEndIdentifier;
    }

    public void setEndToEndIdentifier(String endToEndIdentifier) {
        this.endToEndIdentifier = endToEndIdentifier;
    }

    public String getMandateReference() {
        return mandateReference;
    }

    public void setMandateReference(String mandateReference) {
        this.mandateReference = mandateReference;
    }

    public String getBatchReference() {
        return batchReference;
    }

    public void setBatchReference(String batchReference) {
        this.batchReference = batchReference;
    }

    public String getFileReference() {
        return fileReference;
    }

    public void setFileReference(String fileReference) {
        this.fileReference = fileReference;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public List<Voucher> getVouchers() {
        return vouchers;
    }

    public void setVouchers(List<Voucher> vouchers) {
        this.vouchers = vouchers;
    }
}
