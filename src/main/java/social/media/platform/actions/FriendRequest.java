package social.media.platform.actions;

import social.media.platform.users.User;

public class FriendRequest {

    static {
        System.out.println("Sorry, FriendRequest doesn't really work now");
    }

    private User sender;
    private User receiver;

    public FriendRequest(User sender, User receiver) {
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

    public void displayRequest() {
        System.out.println(sender.getUsername() + " sent a friend request to " + receiver.getUsername());
    }

    public void displayAnswerRequest() {
        System.out.println(receiver.getUsername() + "   accept a friend request to " + sender.getUsername());
    }
}
