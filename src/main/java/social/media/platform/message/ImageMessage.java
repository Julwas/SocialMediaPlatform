package social.media.platform.message;

import social.media.platform.media.ImageInfo;
import social.media.platform.interfaces.Viewable;
import social.media.platform.users.User;

public class ImageMessage extends Message implements Viewable {

    private ImageInfo imageInfo;

    public ImageMessage(User sender, User receiver, String date, ImageInfo imageInfo) {
        super(sender, receiver, date);
        this.imageInfo = imageInfo;
    }

    public ImageInfo getImageInfo() {
        return imageInfo;
    }

    public void setImageInfo(ImageInfo imageInfo) {
        this.imageInfo = imageInfo;
    }

    @Override
    public void displayMessage() {
        super.displayMessage();
        System.out.println(" : " + imageInfo.getUrl() + " size: " + imageInfo.getWidth() + " x " + imageInfo.getHeight()
                + " pixels. ");
    }

    @Override
    public void open() {
        System.out.println("Use your imagination to see " + imageInfo.getUrl());
    }
}
