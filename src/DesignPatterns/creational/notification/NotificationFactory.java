package DesignPatterns.creational.notification;

public class NotificationFactory {
    public static Notification createNotification(String type){
        switch (type){
            case "EMAIL": return new EmailNotification();
            case "SMS": return new SMSNotification();

        }

        return new EmailNotification();
    }
}
