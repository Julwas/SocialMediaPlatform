package social.media.platform.post;

import social.media.platform.media.VideoInfo;
import social.media.platform.actions.Comment;
import social.media.platform.media.VideoPlayable;
import social.media.platform.users.User;

import java.util.List;

public class VideoPost extends Post implements VideoPlayable {
    private VideoInfo videoInfo;

    public VideoPost(User author, String content, List<Comment> comments, List<User> likers, VideoInfo videoInfo) {
        super(author, content, comments, likers);
        this.videoInfo = videoInfo;
    }

    public VideoInfo getVideoInfo() {
        return videoInfo;
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        this.videoInfo = videoInfo;
    }

    @Override
    public void displayPost() {
        System.out.println(author.getUsername() + " " + author.getSurname() + " posted: " + videoInfo.getUrl()
                + " size: " + videoInfo.getHeight() + " x " + videoInfo.getWidth() + " pixels " + videoInfo.getDuration()
                + " seconds. " + " liked the post by users : ");
        for (User user : likers) {
            user.displayName();

        }

    }

    @Override
    public void play() {
        System.out.println("Use your imagination to see " + videoInfo.getUrl());
    }
}
