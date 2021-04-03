package com.electronics.mollie.resources;

public class PeriodCost {
    private String description;
    private String method;
    private Integer count;
    private PeriodCostRate rate;
    private Amount amountNet;
    private Amount amountVat;
    private Amount amountGross;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public PeriodCostRate getRate() {
        return rate;
    }

    public void setRate(PeriodCostRate rate) {
        this.rate = rate;
    }

    public Amount getAmountNet() {
        return amountNet;
    }

    public void setAmountNet(Amount amountNet) {
        this.amountNet = amountNet;
    }

    public Amount getAmountVat() {
        return amountVat;
    }

    public void setAmountVat(Amount amountVat) {
        this.amountVat = amountVat;
    }

    public Amount getAmountGross() {
        return amountGross;
    }

    public void setAmountGross(Amount amountGross) {
        this.amountGross = amountGross;
    }
}
