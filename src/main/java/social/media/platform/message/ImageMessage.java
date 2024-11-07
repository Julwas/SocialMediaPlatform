package social.media.platform.message;

import social.media.platform.users.User;

public class ImageMessage extends Message {

    private String imageMessage;

    public ImageMessage(User sender, User receiver, String imageMessage) {
        super(sender, receiver);
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
