package com.ananthudev.EasyCart.exceptions.notification;

public class NotificationSendFailedException extends RuntimeException {
    public NotificationSendFailedException(String message) {
        super(message);
    }
}
