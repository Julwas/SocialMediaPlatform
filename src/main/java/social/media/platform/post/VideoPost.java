package social.media.platform.post;

import social.media.platform.interfaces.Playable;
import social.media.platform.media.VideoInfo;
import social.media.platform.actions.Comment;
import social.media.platform.users.User;

import java.util.List;

public class VideoPost extends Post implements Playable {
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
        System.out.println(author.getUsername() +" posted the video: " + videoInfo.getUrl()
                + " size: " + videoInfo.getHeight() + " x " + videoInfo.getWidth() + " pixels " + videoInfo.getDuration()
                + " seconds. " + " The post, liked  by users ");
        for (User user : likers) {
            user.displayName();
        }
        for(Comment comment : comments){
            comment.displayComment();
        }
    }

    @Override
    public void play() {
        System.out.println("Use your imagination to see " + videoInfo.getUrl());
    }

    @Override
    public void pause() {
        System.out.println( videoInfo.getUrl() + "Press pause");
    }
}
