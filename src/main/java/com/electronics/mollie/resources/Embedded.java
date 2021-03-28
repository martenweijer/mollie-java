package com.electronics.mollie.resources;

import java.util.List;

public class Embedded {
    private List<Payment> payments;
    private List<Refund> refunds;

    public List<Payment> getPayments() {
        return payments;
    }

    public List<Refund> getRefunds() {
        return refunds;
    }
}
