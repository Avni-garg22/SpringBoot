package com.avni.foodapp.notification;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EmailNotification implements NotificationService {

    public EmailNotification() {
        System.out.println("EmailNotification constructor called");
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("EMAIL sent: " + message);
    }
}