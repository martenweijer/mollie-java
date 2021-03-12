package com.electronics.mollie.resources;

public class Amount {
    private String value;
    private String currency;

    public Amount() {
    }

    public Amount(String value, String currency) {
        this.value = value;
        this.currency = currency;
    }
}
