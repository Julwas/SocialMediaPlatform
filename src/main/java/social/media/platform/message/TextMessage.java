package social.media.platform.message;

import social.media.platform.interfaces.ContentReaction;
import social.media.platform.interfaces.Viewable;
import social.media.platform.users.User;

public class TextMessage extends Message implements Viewable {

    private String textMessage;
    private String urlEmoticon;

    public TextMessage(User sender, User receiver, String date, String textMessage) {
        super(sender, receiver, date);
        this.textMessage = textMessage;
    }

    public String getUrlEmoticon() {
        return urlEmoticon;
    }

    public void setUrlEmoticon(String urlEmoticon) {
        this.urlEmoticon = urlEmoticon;
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
        System.out.println(" Open the message " + getTextMessage());
    }

}
