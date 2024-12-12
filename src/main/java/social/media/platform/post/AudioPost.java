package social.media.platform.post;

import social.media.platform.interfaces.ContentReaction;
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

    public AudioPost(/*User author, */ List<Comment> comments, List<User> likers, AudioInfo audioInfo) {
        super(/*author,*/ comments, likers);
        this.audioInfo = audioInfo;
    }

    @Override
    public void displayPost() {
        System.out.print(/*author.getUsername() +  " posted: " +*/ audioInfo.getUrl()
                + "size: " + audioInfo.getDuration() + " seconds. " + " The post, liked  by users : ");
        for (User user : likers) {
            user.displayName();
        }
        for(Comment comment : comments){
            comment.addComment();
        }
    }


    @Override
    public void play() {
        System.out.println("is hearing the audio: " + audioInfo.getUrl());
    }

    @Override
    public void pause() {
        System.out.println("paused the audio: " + audioInfo.getUrl());
    }


}
