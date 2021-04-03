package com.electronics.mollie.resources;

public class Pricing {
    private String description;
    private Amount fixed;
    private String variable;
    private String feeRegion;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Amount getFixed() {
        return fixed;
    }

    public void setFixed(Amount fixed) {
        this.fixed = fixed;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getFeeRegion() {
        return feeRegion;
    }

    public void setFeeRegion(String feeRegion) {
        this.feeRegion = feeRegion;
    }
}
