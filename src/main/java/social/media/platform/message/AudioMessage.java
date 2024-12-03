package social.media.platform.message;

import social.media.platform.interfaces.ContentReaction;
import social.media.platform.media.AudioInfo;
import social.media.platform.interfaces.Playable;
import social.media.platform.users.User;

public class AudioMessage extends Message implements Playable {
    private AudioInfo audioInfo;

    public AudioMessage(User sender, User receiver, String date, AudioInfo audioInfo) {
        super(sender, receiver, date);
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


    @Override
    public void play() {
        System.out.println("is hearing the audio: " + audioInfo.getUrl());
    }

    @Override
    public void pause() {
        System.out.println( audioInfo.getUrl() + "Press pause");
    }

}
