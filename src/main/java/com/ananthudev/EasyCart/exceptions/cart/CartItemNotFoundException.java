package com.ananthudev.EasyCart.exceptions.cart;

public class CartItemNotFoundException extends RuntimeException {
    public CartItemNotFoundException(String message) {
        super(message);
    }
}
