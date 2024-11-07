package socialMediaPlatform;

public class VideoMessage extends Message{

    private String videoMessage;

    public VideoMessage(User sender, User receiver, String newMessage, String textMessage) {
        super(sender, receiver, newMessage);
        this.videoMessage = textMessage;
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
