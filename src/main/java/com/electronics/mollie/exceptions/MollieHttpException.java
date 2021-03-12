package com.electronics.mollie.exceptions;

public class MollieHttpException extends MollieException {
    public MollieHttpException(Throwable e) {
        super(e);
    }

    public MollieHttpException(String message) {
        super(message);
    }
}
