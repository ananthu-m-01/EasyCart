package com.ananthudev.EasyCart.exceptions.discount;

public class DiscountExpiredException extends RuntimeException {
    public DiscountExpiredException(String message) {
        super(message);
    }
}
