package social.media.platform.post;

import social.media.platform.enams.PostPopularity;
import social.media.platform.interfaces.Playable;
import social.media.platform.media.VideoInfo;
import social.media.platform.actions.Comment;
import social.media.platform.notifications.Notification;
import social.media.platform.profile.AccessLevel;
import social.media.platform.users.User;

import java.util.List;

public class VideoPost extends Post implements Playable {
    private VideoInfo videoInfo;

    public VideoPost(User author, List<Comment> comments, List<User> likers, AccessLevel accessLevel,
                     Notification notification, VideoInfo videoInfo, PostPopularity postPopularity) {
        super(author, comments, likers, accessLevel, notification, postPopularity);
        this.videoInfo = videoInfo;
    }

    public VideoInfo getVideoInfo() {
        return videoInfo;
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        this.videoInfo = videoInfo;
    }

    @Override
    public String toString() {
        return author.getUsername() + " posted: " + videoInfo.getUrl();
    }

    @Override
    public void displayPost() {
        System.out.println(videoInfo.getUrl());
        super.displayPost();
        for (User user : likers) {
            user.displayName();
        }
        for (Comment comment : comments) {
            comment.addComment();
        }
    }

    @Override
    public void displayPostInfo() {
        System.out.println(videoInfo.getUrl()
                + " size: " + videoInfo.getHeight() + " x " + videoInfo.getWidth() + " pixels " + videoInfo.getDuration()
                + " seconds. ");
    }


    @Override
    public void play() {
        System.out.println("is watching the video " + videoInfo.getUrl());
    }

    @Override
    public void pause() {
        System.out.println("paused the video: " + videoInfo.getUrl());
    }
}
