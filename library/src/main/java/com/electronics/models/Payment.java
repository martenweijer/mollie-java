package com.electronics.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

@JsonIncludeProperties(value = { "id", "description", "amount", "status" })
public class Payment {
    public String id;
    public String description;
    public Amount amount;
    public String status;
}
