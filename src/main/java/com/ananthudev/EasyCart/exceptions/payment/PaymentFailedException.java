package com.ananthudev.EasyCart.exceptions.payment;

public class PaymentFailedException extends RuntimeException {
    public PaymentFailedException(String message) {
        super(message);
    }
}
