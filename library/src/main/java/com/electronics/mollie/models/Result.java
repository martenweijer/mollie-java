package com.electronics.mollie.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIncludeProperties(value = { "_embedded" })
public class Result {
    @JsonProperty(value = "_embedded")
    public Embedded embedded;
}
