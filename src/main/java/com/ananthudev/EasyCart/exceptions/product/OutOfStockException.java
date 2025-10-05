package com.ananthudev.EasyCart.exceptions.product;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String message) {
        super(message);
    }
}
