package com.electronics.mollie.exceptions;

public class MollieException extends Exception {
    public MollieException(Throwable e) {
        super(e);
    }

    public MollieException(String message) {
        super(message);
    }
}
