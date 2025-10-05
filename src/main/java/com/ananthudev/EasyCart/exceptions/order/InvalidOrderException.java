package com.ananthudev.EasyCart.exceptions.order;

public class InvalidOrderException extends RuntimeException {
    public InvalidOrderException(String message) {
        super(message);
    }
}
