package socialMediaPlatform;

public class TextMessage extends Message {

    private String textMessage;

    public TextMessage(User sender, User receiver, String newMessage, String textMessage) {
        super(sender, receiver, newMessage);
        this.textMessage = textMessage;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    @Override
    public void displayMessage() {
        super.displayMessage();
        System.out.println(textMessage);
    }
}
