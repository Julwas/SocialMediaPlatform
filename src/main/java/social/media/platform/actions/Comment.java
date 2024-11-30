package social.media.platform.actions;

import social.media.platform.base.SocialEntity;
import social.media.platform.interfaces.ContentReaction;
import social.media.platform.users.User;
import social.media.platform.post.Post;

import java.util.List;

public class Comment extends SocialEntity implements ContentReaction {
    private User commenter;
    private String text;
    private Post content;
    private List<User> likers;
    private String urlEmoticon;

             public Comment(User commenter, String text, Post content,  List<User> likers, String urlEmoticon) {
                 this.commenter = commenter;
                 this.text = text;
                 this.content = content;
                 this.likers = likers;
                 this.urlEmoticon = urlEmoticon;
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

             public Post getContent() {
                 return content;
             }

             public void setContent(Post content) {
                 this.content = content;
             }


             public List<User> getLikers() {
                 return likers;
             }

             public void setLikers(List<User> likers) {
                 this.likers = likers;
             }

             public String getUrlEmoticon() {
                 return urlEmoticon;
             }

             public void setUrlEmoticon(String urlEmoticon) {
                 this.urlEmoticon = urlEmoticon;
             }

             public void displayComment() {
    commenter.displayName();
    System.out.print("Comment is : ");
    System.out.println(text + "to");
    getContent().displayPost();
    System.out.println("liked the comment by users : ");
    for (User user : likers){
    user.displayName();
    sendEmoticon();
}
    }

   @Override
    public void sendEmoticon() {
       System.out.println( " sent emoticon: " + getUrlEmoticon());
    }
}
