package com.ananthudev.EasyCart.exceptions.customer;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message){
        super(message);
    }
}
