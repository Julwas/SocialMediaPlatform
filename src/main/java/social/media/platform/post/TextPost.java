package social.media.platform.post;

import social.media.platform.actions.Comment;
import social.media.platform.users.User;

import java.util.List;

public class TextPost extends Post {

    private String textContent;

    public TextPost(User author, String content, List<Comment> comments, String textContent) {
        super(author, content, comments);
        this.textContent = textContent;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    @Override
    public void displayPost() {
        System.out.println(author.getUsername() + " posted: " + textContent);
    }
}
