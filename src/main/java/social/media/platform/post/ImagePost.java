package social.media.platform.post;


import social.media.platform.MediaInfo.ImageInfo;
import social.media.platform.actions.Comment;
import social.media.platform.users.User;

import java.util.List;

public class ImagePost extends Post {
    private ImageInfo imageInfo;

    public ImageInfo getImageInfo() {
        return imageInfo;
    }

    public void setImageInfo(ImageInfo imageInfo) {
        this.imageInfo = imageInfo;
    }

    public ImagePost(User author, String content, List<Comment> comments, List<User> likers, ImageInfo imageInfo) {
        super(author, content, comments, likers);
        this.imageInfo = imageInfo;
    }

    @Override
    public void displayPost() {
        System.out.println(author.getUsername() + " posted: " + imageInfo.getUrl() + "  size: " + imageInfo.getWidth()
                + "x" + imageInfo.getWidth() + " pixels  " + "liked the post by users : ");
        for (User user : likers) {
            user.displayName();
        }
    }
}
