package social.media.platform.post;


import social.media.platform.actions.Comment;
import social.media.platform.users.User;

import java.util.List;

public class ImagePost extends Post {
    private String imageUrl;

    public ImagePost(User author, String content, List<Comment> comments, String imageUrl) {
        super(author, content, comments);
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public void displayPost() {
        System.out.println(author.getUsername() + " posted: " + imageUrl);
    }
}
