package DesignPatterns.creational.notification;

import java.util.UUID;

public class SMSNotification implements Notification {
    @Override
    public String sendNotification(NotificationData data) {
        System.out.println("fetching information of user from db "+data.notifier);
        System.out.println("sending sms notification");
        return UUID.randomUUID().toString();
    }
}
