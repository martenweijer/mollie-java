package com.electronics.mollie.resources;

public class InvoiceLine {
    private String period;
    private String description;
    private int count;
    private double vatPercentage;
    private Amount amount;

    public String getPeriod() {
        return period;
    }

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return count;
    }

    public double getVatPercentage() {
        return vatPercentage;
    }

    public Amount getAmount() {
        return amount;
    }
}
