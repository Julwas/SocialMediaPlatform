package social.media.platform.post;

import social.media.platform.enams.PostPopularity;
import social.media.platform.media.ImageInfo;
import social.media.platform.actions.Comment;
import social.media.platform.interfaces.Viewable;
import social.media.platform.notifications.Notification;
import social.media.platform.profile.AccessLevel;
import social.media.platform.users.User;

import java.util.List;

public class ImagePost extends Post implements Viewable {
    private ImageInfo imageInfo;


    public ImageInfo getImageInfo() {
        return imageInfo;
    }

    public void setImageInfo(ImageInfo imageInfo) {
        this.imageInfo = imageInfo;
    }

    public ImagePost(User author, List<Comment> comments, List<User> likers, AccessLevel accessLevel,
                     Notification notification, ImageInfo imageInfo, PostPopularity postPopularity) {
        super(author, comments, likers, accessLevel, notification, postPopularity);
        this.imageInfo = imageInfo;
    }

    @Override
    public void displayPostInfo() {
        System.out.println(imageInfo.getUrl() + " size " + imageInfo.getWidth()
                + "x" + imageInfo.getWidth() + " pixels.  ");
    }

    @Override
    public void displayPost() {
        System.out.println(author.getUsername() + " posted the image : " + imageInfo.getUrl());
        super.displayPost();
        for (User user : likers) {
            user.displayName();
        }
        for (Comment comment : comments) {
            comment.addComment();
        }
    }

    @Override
    public void open() {
        System.out.println("opened the picture " + imageInfo.getUrl());
    }
}
