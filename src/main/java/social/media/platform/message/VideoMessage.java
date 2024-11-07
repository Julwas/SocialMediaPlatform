package social.media.platform.message;

import social.media.platform.users.User;

public class VideoMessage extends Message {

    private String videoMessage;

    public VideoMessage(User sender, User receiver, String videoMessage) {
        super(sender, receiver);
        this.videoMessage = videoMessage;
    }


    public String getTextMessage() {
        return videoMessage;
    }

    public void setTextMessage(String textMessage) {
        this.videoMessage = textMessage;
    }

    @Override
    public void displayMessage() {
        super.displayMessage();
        System.out.println( " : " + videoMessage);
    }
}
