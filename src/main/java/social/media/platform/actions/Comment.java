package social.media.platform.actions;

import social.media.platform.base.SocialEntity;
import social.media.platform.users.User;
import social.media.platform.post.Post;

public class Comment extends SocialEntity {
    private User commenter;
    private String text;
    private Post content;

    public Comment(User commenter, String text, Post content) {
        this.commenter = commenter;
        this.text = text;
        this.content = content;
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
        commenter.displayInfo();
        System.out.print("Comment is : ");
        System.out.println(text + "to");
        getContent().displayPost();

    }
}
