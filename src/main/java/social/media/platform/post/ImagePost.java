package social.media.platform.post;


import social.media.platform.media.ImageInfo;
import social.media.platform.actions.Comment;
import social.media.platform.interfaces.Viewable;
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

    public ImagePost(User author, String content, List<Comment> comments, List<User> likers,
                     ImageInfo imageInfo) {
        super(author, content, comments, likers);
        this.imageInfo = imageInfo;
    }

    @Override
    public void displayPost() {
        System.out.println(author.getUsername() + " posted the image : " + imageInfo.getUrl() + " size " + imageInfo.getWidth()
                + "x" + imageInfo.getWidth() + " pixels.  " + " The post, liked  by users : ");
        for (User user : likers) {
            user.displayName();
        }
        for(Comment comment : comments){
            comment.displayComment();
        }
    }

    @Override
    public void open() {
        System.out.println( "Use your imagination to see " + imageInfo.getUrl());
    }
}
