package social.media.platform.message;

import social.media.platform.users.User;

public class AudioMessage extends Message {

    private String audioMessage;

    public AudioMessage(User sender, User receiver, String audioMessage) {
        super(sender, receiver);
        this.audioMessage = audioMessage;
    }

    public String getAudioMessage() {
        return audioMessage;
    }

    public void setAudioMessage(String audioMessage) {
        this.audioMessage = audioMessage;
    }

    @Override
    public void displayMessage() {
        super.displayMessage();
        System.out.println(" : " + audioMessage);
    }
}
