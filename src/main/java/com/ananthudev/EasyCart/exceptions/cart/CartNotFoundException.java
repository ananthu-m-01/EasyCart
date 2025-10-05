package com.ananthudev.EasyCart.exceptions.cart;

public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException(String message) {
        super(message);
    }
}
