package social.media.platform.post;

import social.media.platform.actions.Comment;
import social.media.platform.base.SocialEntity;
import social.media.platform.users.User;

import java.util.List;

public abstract class Post extends SocialEntity {

    protected User author;
    protected String content;
    private List<Comment> comments;
    protected List<User> likers;


    public Post(User author, String content, List<Comment> comments, List<User> likers) {
        this.author = author;
        this.content = content;
        this.comments = comments;
        this.likers = likers;
    }

    public abstract void displayPost();

}
