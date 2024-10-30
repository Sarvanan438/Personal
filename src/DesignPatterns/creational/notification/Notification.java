package DesignPatterns.creational.notification;

/**
 * This will be a common class which is a limitation in factory method ,
 * A factory only returns objects implementing a specific polymorphism be it object or interface hence
 * The notification system here is the common point and the classes implementing it will be the actual instance
 *
 * So this only specifies the abstract behaviour of the notification system i.e to send notification
 * It doesn't specify which channel or implementation detail
 */
public interface Notification {
    /**
     * we will be using a object here because any subclass can be sent and
     * can be moved to more specific class in the implementation .
     * But creating specific classes for specific notification means abstraction leak , so not good
     * @param data
     */
    public String sendNotification(NotificationData data);
}
