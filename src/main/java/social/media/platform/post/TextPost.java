package social.media.platform.post;

import social.media.platform.actions.Comment;
import social.media.platform.interfaces.Viewable;
import social.media.platform.profile.AccessLevel;
import social.media.platform.users.User;

import java.util.List;


public class TextPost extends Post implements Viewable {

    private String textContent;

    public TextPost(User author, List<Comment> comments, List<User> likers, AccessLevel accessLevel, String textContent) {
        super(author, comments, likers, accessLevel);
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
        System.out.println(author.getUsername() + " posted: " + textContent + "The post, liked  by users:");
        for (User user : likers) {
            user.displayName();
        }
        for (Comment comment : comments) {
            comment.addComment();
        }
    }

    @Override
    public void open() {
        System.out.println(" Open the text post " + getTextContent());
    }
}
