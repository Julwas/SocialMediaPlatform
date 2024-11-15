package social.media.platform.actions;

import social.media.platform.base.SocialEntity;
import social.media.platform.users.User;
import social.media.platform.post.Post;

import java.util.List;

public class Comment extends SocialEntity {
    private User commenter;
    private String text;
    private Post content;
    protected List<User> likers;

    public Comment(User commenter, String text, Post content, List<User> likers) {
        this.commenter = commenter;
        this.text = text;
        this.content = content;
        this.likers = likers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getCommenter() {
        return commenter;
    }

    public void setCommenter(User commenter) {
        this.commenter = commenter;
    }

    public Post getContent() {
        return content;
    }

    public void setContent(Post content) {
        this.content = content;
    }

    public void displayComment() {
        commenter.displayName();
        System.out.print("Comment is : ");
        System.out.println(text + "to");
        getContent().displayPost();
        System.out.println("liked the comment by users : ");
        for (User user : likers) {
            user.displayName();
        }
    }
}
