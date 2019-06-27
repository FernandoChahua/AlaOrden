package com.alaorden.exception;

public class ApiException extends ApplicationException {

    public ApiException(String message) {
        this(message, null);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
