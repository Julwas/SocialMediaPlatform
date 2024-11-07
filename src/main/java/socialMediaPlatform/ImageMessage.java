package socialMediaPlatform;

public class ImageMessage extends Message {

    private String imageMessage;

    public ImageMessage(User sender, User receiver, String newMessage, String imageMessage) {
        super(sender, receiver, newMessage);
        this.imageMessage = imageMessage;
    }

    public String getImageMessage() {
        return imageMessage;
    }

    public void setImageMessage(String imageMessage) {
        this.imageMessage = imageMessage;
    }

    @Override
    public void displayMessage() {
        super.displayMessage();
        System.out.println(" : " +imageMessage);
    }

}
