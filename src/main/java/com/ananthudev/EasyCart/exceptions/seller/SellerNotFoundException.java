package com.ananthudev.EasyCart.exceptions.seller;

public class SellerNotFoundException extends RuntimeException {
    public SellerNotFoundException(String message){
        super(message);
    }
}
