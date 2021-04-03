package com.electronics.mollie.resources;

import java.util.List;

public class Period {
    private List<PeriodRevenue> revenue;
    private List<PeriodCost> costs;
    private String invoiceId;

    public List<PeriodRevenue> getRevenue() {
        return revenue;
    }

    public void setRevenue(List<PeriodRevenue> revenue) {
        this.revenue = revenue;
    }

    public List<PeriodCost> getCosts() {
        return costs;
    }

    public void setCosts(List<PeriodCost> costs) {
        this.costs = costs;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
