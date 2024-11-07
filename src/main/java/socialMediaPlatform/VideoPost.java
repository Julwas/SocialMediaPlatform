package socialMediaPlatform;

import java.util.List;

public class VideoPost extends Post{
    private String videoUrl;

    public VideoPost(User author, String content, String videoUrl) {
        super(author, content);
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
        super.displayPost();
        System.out.println(videoUrl);
    }
}
