package social.media.platform.post;

import social.media.platform.media.AudioInfo;
import social.media.platform.actions.Comment;
import social.media.platform.interfaces.Playable;
import social.media.platform.users.User;

import java.util.List;

public class AudioPost extends Post implements Playable {
    private AudioInfo audioInfo;

    public AudioInfo getAudioInfo() {
        return audioInfo;
    }

    public void setAudioInfo(AudioInfo audioInfo) {
        this.audioInfo = audioInfo;
    }

    public AudioPost(User author, String content, List<Comment> comments, List<User> likers, String urlEmoticon, AudioInfo audioInfo) {
        super(author, content, comments, likers);
        this.audioInfo = audioInfo;
    }

    @Override
    public void displayPost() {
        System.out.print(author.getUsername() +  " posted: " + audioInfo.getUrl()
                + "size: " + audioInfo.getDuration() + " seconds. " + " The post, liked  by users : ");
        for (User user : likers) {
            user.displayName();
        }
        for(Comment comment : comments){
            comment.displayComment();
        }
    }

    @Override
    public void play() {
        System.out.println("Use your imagination to hear " + audioInfo.getUrl());
    }

    @Override
    public void pause() {
        System.out.println( audioInfo.getUrl() + "Press pause");
    }
}
