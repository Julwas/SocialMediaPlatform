package social.media.platform.message;

import social.media.platform.interfaces.Playable;
import social.media.platform.media.VideoInfo;
import social.media.platform.notifications.Notification;
import social.media.platform.users.User;

public class VideoMessage extends Message implements Playable {
    private VideoInfo videoInfo;

    public VideoMessage(User sender, User receiver, String date, VideoInfo videoInfo, Notification notification) {
        super(sender, receiver, date, notification);
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

    @Override
    public void play() {
        System.out.println("is watching the video " + videoInfo.getUrl());
    }

    @Override
    public void pause() {
        System.out.println("paused the video: " + videoInfo.getUrl());
    }
}
