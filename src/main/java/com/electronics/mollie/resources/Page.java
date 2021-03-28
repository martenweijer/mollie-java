package com.electronics.mollie.resources;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
    @JsonProperty("_links")
    private Links links;
    private int count;
    private Embedded<T> _embedded;

    public Links getLinks() {
        return links;
    }

    public int getCount() {
        return count;
    }

    public List<T> getItems() {
        if (_embedded == null) {
            return new ArrayList<>();
        }

        return _embedded.getItems();
    }

    private static class Embedded<T> {
        @JsonAlias({"payments", "methods", "invoices", "chargebacks", "permissions", "mandates", "customers", "shipments", "orders"})
        private List<T> items;

        public List<T> getItems() {
            return items;
        }
    }
}
