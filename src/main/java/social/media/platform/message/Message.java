package social.media.platform.message;

import social.media.platform.base.SocialEntity;
import social.media.platform.notifications.Notification;
import social.media.platform.users.User;

public abstract class Message extends SocialEntity {
    private User sender;
    private User receiver;
    private String date;
    private Notification notification;


    public Message(User sender, User receiver, String date, Notification notification) {
        this.sender = sender;
        this.receiver = receiver;
        this.date = date;
        this.notification = notification;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public void displayMessage() {
        System.out.println(sender.getUsername() + " sent a new message to "  + getDate());
        notification.displayNotification();

    }
}
