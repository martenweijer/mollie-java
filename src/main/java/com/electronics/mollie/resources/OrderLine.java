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
    private Integer quantityShipped;
    private Amount amountShipped;
    private Integer quantityRefunded;
    private Amount amountRefunded;
    private Integer quantityCanceled;
    private Amount amountCanceled;
    private Integer shippableQuantity;
    private Integer refundableQuantity;
    private Integer cancelableQuantity;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getCancelable() {
        return isCancelable;
    }

    public void setCancelable(Boolean cancelable) {
        isCancelable = cancelable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Amount getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Amount unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Amount getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Amount discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Amount getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Amount totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getVatRate() {
        return vatRate;
    }

    public void setVatRate(String vatRate) {
        this.vatRate = vatRate;
    }

    public Amount getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(Amount vatAmount) {
        this.vatAmount = vatAmount;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
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

    public Integer getQuantityShipped() {
        return quantityShipped;
    }

    public void setQuantityShipped(Integer quantityShipped) {
        this.quantityShipped = quantityShipped;
    }

    public Amount getAmountShipped() {
        return amountShipped;
    }

    public void setAmountShipped(Amount amountShipped) {
        this.amountShipped = amountShipped;
    }

    public Integer getQuantityRefunded() {
        return quantityRefunded;
    }

    public void setQuantityRefunded(Integer quantityRefunded) {
        this.quantityRefunded = quantityRefunded;
    }

    public Amount getAmountRefunded() {
        return amountRefunded;
    }

    public void setAmountRefunded(Amount amountRefunded) {
        this.amountRefunded = amountRefunded;
    }

    public Integer getQuantityCanceled() {
        return quantityCanceled;
    }

    public void setQuantityCanceled(Integer quantityCanceled) {
        this.quantityCanceled = quantityCanceled;
    }

    public Amount getAmountCanceled() {
        return amountCanceled;
    }

    public void setAmountCanceled(Amount amountCanceled) {
        this.amountCanceled = amountCanceled;
    }

    public Integer getShippableQuantity() {
        return shippableQuantity;
    }

    public void setShippableQuantity(Integer shippableQuantity) {
        this.shippableQuantity = shippableQuantity;
    }

    public Integer getRefundableQuantity() {
        return refundableQuantity;
    }

    public void setRefundableQuantity(Integer refundableQuantity) {
        this.refundableQuantity = refundableQuantity;
    }

    public Integer getCancelableQuantity() {
        return cancelableQuantity;
    }

    public void setCancelableQuantity(Integer cancelableQuantity) {
        this.cancelableQuantity = cancelableQuantity;
    }
}
