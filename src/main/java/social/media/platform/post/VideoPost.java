package social.media.platform.post;

import social.media.platform.interfaces.Playable;
import social.media.platform.media.VideoInfo;
import social.media.platform.actions.Comment;
import social.media.platform.users.User;

import java.util.List;

public class VideoPost extends Post implements Playable {
    private VideoInfo videoInfo;

    public VideoPost(User author, List<Comment> comments, List<User> likers, VideoInfo videoInfo) {
        super(author, comments, likers);
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
        System.out.println(author.getUsername() +" posted the video: " + videoInfo.getUrl()
                + " size: " + videoInfo.getHeight() + " x " + videoInfo.getWidth() + " pixels " + videoInfo.getDuration()
                + " seconds. " + " The post, liked  by users ");
        for (User user : likers) {
            user.displayName();
        }
        for(Comment comment : comments){
            comment.addComment();
        }
    }

    @Override
    public void play() {
        System.out.println( "is watching the video " + videoInfo.getUrl());
    }

    @Override
    public void pause() {
        System.out.println( "paused the video: " + videoInfo.getUrl());
    }
}
