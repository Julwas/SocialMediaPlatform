package social.media.platform.post;

import social.media.platform.MediaInfo.AudioInfo;
import social.media.platform.actions.Comment;
import social.media.platform.users.User;

import java.util.List;

public class AudioPost extends Post {
    private AudioInfo audioInfo;

    public AudioInfo getAudioInfo() {
        return audioInfo;
    }

    public void setAudioInfo(AudioInfo audioInfo) {
        this.audioInfo = audioInfo;
    }

    public AudioPost(User author, String content, List<Comment> comments, List<User> likers, AudioInfo audioInfo) {
        super(author, content, comments, likers);
        this.audioInfo = audioInfo;
    }

    @Override
    public void displayPost() {
        System.out.println(author.getUsername() + " " + author.getSurname() + " posted: " + audioInfo.getUrl()
                + "size: " + audioInfo.getDuration() + " seconds. " + " liked the post by users : ");
        for (User user : likers) {
            user.displayName();
        }

    }
}
