package com.challenge.citylists.exception;

import org.springframework.http.HttpStatus;

public class ExceptionBroker extends Exception {

    private String message;
    private HttpStatus statusCode;

    public ExceptionBroker(String message, HttpStatus statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}
