package social.media.platform.post;

import social.media.platform.actions.Comment;
import social.media.platform.base.SocialEntity;
import social.media.platform.users.User;

import java.util.List;

public abstract class Post extends SocialEntity {

    protected User author;
    protected String content;
    private List<Comment> comments;


    public Post(User author, String content, List<Comment> comments) {
        this.author = author;
        this.content = content;
        this.comments = comments;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public abstract void displayPost();
}
