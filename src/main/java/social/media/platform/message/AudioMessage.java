package social.media.platform.message;

import social.media.platform.MediaInfo.AudioInfo;
import social.media.platform.users.User;

public class AudioMessage extends Message {
    private AudioInfo audioInfo;

    public AudioMessage(User sender, User receiver, AudioInfo audioInfo) {
        super(sender, receiver);
        this.audioInfo = audioInfo;
    }

    public AudioInfo getAudioInfo() {
        return audioInfo;
    }

    public void setAudioInfo(AudioInfo audioInfo) {
        this.audioInfo = audioInfo;
    }

    @Override
    public void displayMessage() {
        super.displayMessage();
        System.out.println(" : " + audioInfo.getUrl() + " size: " + audioInfo.getDuration() + "  seconds.");
    }
}
