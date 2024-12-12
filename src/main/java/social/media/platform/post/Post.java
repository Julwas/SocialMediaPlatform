package social.media.platform.post;

import social.media.platform.actions.Comment;
import social.media.platform.base.SocialEntity;

import social.media.platform.interfaces.Summarizable;
import social.media.platform.users.User;

import java.util.List;

public abstract class Post extends SocialEntity  {

    //protected User author;//delete
    protected List<Comment> comments;
    protected List<User> likers;



    public Post( List<Comment> comments, List<User> likers ) {
       // this.author = author;
        this.comments = comments;
        this.likers = likers;


    }

    //public User getAuthor() {return author;}

    public List<Comment> getComments() {
        return comments;
    }

    public List<User> getLikers() {
        return likers;
    }

    public abstract void displayPost();

}
