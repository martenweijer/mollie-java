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
}
