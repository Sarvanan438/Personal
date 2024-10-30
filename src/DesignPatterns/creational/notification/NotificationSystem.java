package DesignPatterns.creational.notification;

public class NotificationSystem {
    public static void main (String[] args){
        Notification notification =  NotificationFactory.createNotification("EMAIL");
        notification.sendNotification(new NotificationData("King","hello king"));
    }
}
