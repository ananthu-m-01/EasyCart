package com.ananthudev.EasyCart.exceptions.payment;

public class InvalidPaymentMethodException extends RuntimeException {
    public InvalidPaymentMethodException(String message) {
        super(message);
    }
}
