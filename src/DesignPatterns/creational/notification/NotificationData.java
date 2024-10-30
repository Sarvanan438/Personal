package DesignPatterns.creational.notification;

/**
 * how to handle data needed for specific notification system
 * then factory might not be the right thing here
 * because mobile notification might need mobile id , etc
 * until we use a way to fetch the details using the notifier i.e user id , i think we cannot achieve
 * true abstraction . So assumnig we can do that let's build this
 */
public class NotificationData {
    public String notifier,data;
    NotificationData(String notifier,String data){
        this.notifier=notifier;
        this.data=data;
    }
}
