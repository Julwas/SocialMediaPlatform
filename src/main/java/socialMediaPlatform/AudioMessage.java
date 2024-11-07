package socialMediaPlatform;

public class AudioMessage extends Message {

    private String audioMessage;

    public AudioMessage(User sender, User receiver, String newMessage, String audioMessage) {
        super(sender, receiver, newMessage);
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
