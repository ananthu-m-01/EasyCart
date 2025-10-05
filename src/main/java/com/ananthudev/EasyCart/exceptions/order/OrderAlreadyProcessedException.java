package com.ananthudev.EasyCart.exceptions.order;

public class OrderAlreadyProcessedException extends RuntimeException {
    public OrderAlreadyProcessedException(String message) {
        super(message);
    }
}
