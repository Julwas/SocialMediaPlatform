package social.media.platform.post;

import social.media.platform.actions.Comment;
import social.media.platform.enams.PostPopularity;
import social.media.platform.interfaces.Viewable;
import social.media.platform.notifications.Notification;
import social.media.platform.profile.AccessLevel;
import social.media.platform.users.User;

import java.util.List;


public class TextPost extends Post implements Viewable {

    private String textContent;

    public TextPost(User author, List<Comment> comments, List<User> likers, AccessLevel accessLevel,
                    Notification notification, String textContent, PostPopularity postPopularity) {
        super(author, comments, likers, accessLevel, notification, postPopularity);
        this.textContent = textContent;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    @Override
    public String toString() {
        return author.getUsername() + " posted: " + textContent;
    }


    @Override
    public void displayPost() {
        System.out.println(author.getUsername() + " posted: " + textContent);
        super.displayPost();
        for (User user : likers) {
            user.displayName();
        }
        for (Comment comment : comments) {
            comment.addComment();
        }
    }

    @Override
    public void displayPostInfo() {

    }

    @Override
    public void open() {
        System.out.println(" Open the text post " + getTextContent());
    }
}
