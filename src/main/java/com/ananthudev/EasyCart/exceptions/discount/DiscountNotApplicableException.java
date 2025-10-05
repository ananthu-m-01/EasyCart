package com.ananthudev.EasyCart.exceptions.discount;

public class DiscountNotApplicableException extends RuntimeException {
    public DiscountNotApplicableException(String message) {
        super(message);
    }
}
