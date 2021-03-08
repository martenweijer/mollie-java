package com.electronics.mollie.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

@JsonIncludeProperties(value = { "checkout" })
public class Links {
    public Link checkout;
}
