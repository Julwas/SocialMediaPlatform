package social.media.platform.message;

import social.media.platform.base.SocialEntity;
import social.media.platform.users.User;

public abstract class Message extends SocialEntity {
    private User sender;
    private User receiver;



    public Message(User sender, User receiver) {
        this.sender = sender;
        this.receiver = receiver;
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
        System.out.println(sender.getUsername() + " sent a new message to " + receiver.getUsername());
    }
}
