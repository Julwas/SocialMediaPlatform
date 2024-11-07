package social.media.platform.post;

import social.media.platform.actions.Comment;
import social.media.platform.users.User;

import java.util.List;

public class VideoPost extends Post {
    private String videoUrl;

    public VideoPost(User author, String content, List<Comment> comments, String videoUrl) {
        super(author, content, comments);
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public void displayPost() {
        System.out.println(author.getUsername() + " posted: " + videoUrl);
    }
}
