package com.ananthudev.EasyCart.exceptions.customer;

public class DuplicateCustomerException extends RuntimeException{
    public DuplicateCustomerException(String message){
        super(message);
    }
}
