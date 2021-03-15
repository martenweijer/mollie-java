package com.electronics.mollie.resources;

public class Pricing {
    private String description;
    private Amount fixed;
    private String variable;
    private String feeRegion;

    public String getDescription() {
        return description;
    }

    public Amount getFixed() {
        return fixed;
    }

    public String getVariable() {
        return variable;
    }

    public String getFeeRegion() {
        return feeRegion;
    }
}
