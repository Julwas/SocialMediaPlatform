package social.media.platform.post;

import social.media.platform.actions.Comment;
import social.media.platform.base.SocialEntity;

import social.media.platform.enams.PostPopularity;
import social.media.platform.groups.Group;
import social.media.platform.notifications.Notification;
import social.media.platform.profile.AccessLevel;
import social.media.platform.users.User;

import java.util.List;


public abstract class Post extends SocialEntity {
    protected List<Comment> comments;
    protected List<User> likers;
    private AccessLevel accessLevel;
    protected User author;
    protected User user;
    private Group group;
    private Notification notification;
    private PostPopularity postPopularity;


    public Post(User author, List<Comment> comments, List<User> likers, AccessLevel accessLevel,
                Notification notification, PostPopularity postPopularity) {
        this.comments = comments;
        this.likers = likers;
        this.author = author;
        this.accessLevel = accessLevel;
        this.notification = notification;
        this.postPopularity = postPopularity;
    }

    public void setPostPopularity(PostPopularity postPopularity) {
        this.postPopularity = postPopularity;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<User> getLikers() {
        return likers;
    }

    public  void displayPost(){
        notification.displayNotification();
        postPopularity.displayPopularityInfo();
    }
    public abstract void displayPostInfo();

    public void setGroup(Group group) {
        this.group = group;
    }


        public boolean canView(User viewer) {
        switch (accessLevel) {
            case PUBLIC:
                System.out.println("  Access granted");
                return true;
            case FRIENDS:
                if (author.isFriend(viewer)) {
                    System.out.println("  Access granted: You are a friend of the author.");
                    return true;
                } else {
                    System.out.println("  Access denied: This post is only for friends.");
                    return false;
                }
            case MEMBERS:
                if (group.getMembers().contains(viewer)) {
                    System.out.println("  Access granted: You are the members.");
                    return true;
                } else {
                    System.out.println("  Access denied: This post is only available to members of the group.");
                    return false;
                }
            default:
                System.out.println("  Access denied: Unknown access level.");
                return false;
        }
    }
}
