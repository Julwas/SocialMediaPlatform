package socialMediaPlatform;

public class Message {
    private User sender;
    private User receiver;
    private String newMessage;

    public Message(User sender, User receiver, String newMessage) {
        this.sender = sender;
        this.receiver = receiver;
        this.newMessage = newMessage;
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

    public String getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }

    public void displayMessage() {
        System.out.println(sender.getUsername() + newMessage + receiver.getUsername());
    }
}
