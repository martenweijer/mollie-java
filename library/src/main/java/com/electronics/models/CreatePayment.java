package com.electronics.models;

public class CreatePayment {
    public String description;
    public Amount amount;
    public String redirectUrl;

    public CreatePayment() {
    }

    public CreatePayment(String description, Amount amount, String redirectUrl) {
        this.description = description;
        this.amount = amount;
        this.redirectUrl = redirectUrl;
    }
}
