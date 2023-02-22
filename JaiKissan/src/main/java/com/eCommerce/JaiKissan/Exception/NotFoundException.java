package com.eCommerce.JaiKissan.Exception;

public class NotFoundException extends Exception {
    private String message;

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}