package com.electronics.mollie.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class OrderLine {
    private String resource;
    private String id;
    private String orderId;
    private String status;
    private Boolean isCancelable;
    private String type;
    private String category;
    private String name;
    private Integer quantity;
    private Amount unitPrice;
    private Amount discountAmount;
    private Amount totalAmount;
    private String vatRate;
    private Amount vatAmount;
    private String sku;
    private String imageUrl;
    private String productUrl;
    private Object metadata;
    private Amount amount;
    private Date createdAt;
    @JsonProperty("_links")
    private Links links;

    public void setId(String id) {
        this.id = id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }
}
