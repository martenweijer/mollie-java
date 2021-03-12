package com.electronics.mollie.exceptions;

import java.net.http.HttpResponse;

public class MollieResponseStatusCodeException extends MollieHttpException {
    public MollieResponseStatusCodeException(HttpResponse<String> response) {
        this(response.statusCode(), response.body());
    }

    public MollieResponseStatusCodeException(int statusCode, String body) {
        super("Mollie returned http status code "+ statusCode +" ("+ body +")");
    }
}
