package com.ananthudev.EasyCart.exceptions.customer;

public class CustomerInvalidCredentialException extends RuntimeException {
    public CustomerInvalidCredentialException(String message) {
        super(message);
    }
}
