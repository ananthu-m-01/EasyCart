package com.ananthudev.EasyCart.exceptions.category;

public class DuplicateCategoryFoundException extends RuntimeException {
    public DuplicateCategoryFoundException(String message) {
        super(message);
    }
}
