package social.media.platform.message;

import social.media.platform.interfaces.Viewable;
import social.media.platform.notifications.Notification;
import social.media.platform.users.User;

public class TextMessage extends Message implements Viewable {

    private String textMessage;

    public TextMessage(User sender, User receiver, String date, String textMessage, Notification notification) {
        super(sender, receiver, date, notification);
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

    @Override
    public void open() {
        System.out.println(" Open the text message " + getTextMessage());
    }

}
