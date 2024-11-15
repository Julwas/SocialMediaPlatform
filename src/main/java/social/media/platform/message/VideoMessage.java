package social.media.platform.message;

import social.media.platform.MediaInfo.VideoInfo;
import social.media.platform.users.User;

public class VideoMessage extends Message {
    private VideoInfo videoInfo;

    public VideoMessage(User sender, User receiver, VideoInfo videoInfo) {
        super(sender, receiver);
        this.videoInfo = videoInfo;
    }

    public VideoInfo getVideoInfo() {
        return videoInfo;
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        this.videoInfo = videoInfo;
    }

    @Override
    public void displayMessage() {
        super.displayMessage();
        System.out.println(" : " + videoInfo.getUrl() + " size: " + videoInfo.getWidth() + " x " + videoInfo.getHeight() +
                " pixels, " + videoInfo.getDuration() +
                "   seconds.");
    }
}
