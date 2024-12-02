package social.media.platform.actions;

import social.media.platform.base.SocialEntity;
import social.media.platform.interfaces.ContentReaction;
import social.media.platform.users.User;
import java.util.*;
import java.util.List;

public class Comment extends SocialEntity implements ContentReaction{
    private User commenter;
    private User senterEmoticon;
    private String text;
    private List<User> likers;
    private List<String> emoticons = new ArrayList<>();
     final List<String> allowedEmoticons = new ArrayList<>(Arrays.asList(":)", ":(", "Cry", " poo", "wave", "heart ",
            "hmm", "O_o", "kiss", ":‑|"));
    //возвращать спиок возможных  смайлов.

    public Comment(User commenter, String text, List<User> likers, User senterEmoticon) {
        this.commenter = commenter;
        this.text = text;
        this.likers = likers;
        this.senterEmoticon= senterEmoticon;
    }
    public User getCommenter() {
        return commenter;
    }

    public void setCommenter(User commenter) {
        this.commenter = commenter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public List<User> getLikers() {
        return likers;
    }

    public void setLikers(List<User> likers) {
        this.likers = likers;
    }


    public void displayComment() {
        System.out.print(" Comment: " + text + " to the post from ");
        commenter.displayName();
        System.out.print("liked by users : ");
        for (User user : likers) {
            user.displayName();
        }
        for(String emoticon : emoticons){
            System.out.println(emoticon);
        }
        System.out.print( " sent to the comment by:");
        senterEmoticon.displayName();
    }

    public void addComment(){
        System.out.println( commenter.getUsername() + " commented : " + text);
    }

    @Override
    public String sendEmoticon(String emoticon) {
       emoticons.add(emoticon);
       return emoticon;
    }
}
