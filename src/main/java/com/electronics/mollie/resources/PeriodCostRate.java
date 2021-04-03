package com.electronics.mollie.resources;

public class PeriodCostRate {
    private Amount fixed;
    private String percentage;

    public Amount getFixed() {
        return fixed;
    }

    public void setFixed(Amount fixed) {
        this.fixed = fixed;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
