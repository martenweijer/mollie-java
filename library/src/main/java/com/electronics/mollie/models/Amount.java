package com.electronics.mollie.models;

public class Amount {
    public String currency;
    public String value;

    public Amount() {
    }

    public Amount(String currency, String value) {
        this.currency = currency;
        this.value = value;
    }
}
