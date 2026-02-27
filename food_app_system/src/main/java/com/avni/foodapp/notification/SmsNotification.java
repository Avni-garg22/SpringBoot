package com.avni.foodapp.notification;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("smsNotification")
public class SmsNotification implements NotificationService {

    public SmsNotification() {
        System.out.println("SmsNotification constructor called");
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("SMS sent: " + message);
    }
}
