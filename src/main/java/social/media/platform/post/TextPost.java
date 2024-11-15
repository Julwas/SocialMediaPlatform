package social.media.platform.post;

import social.media.platform.actions.Comment;
import social.media.platform.users.User;

import java.util.List;

public class TextPost extends Post {

    private String textContent;

    public TextPost(User author, String content, List<Comment> comments, List<User> likers, String textContent) {
        super(author, content, comments, likers);
        this.textContent = textContent;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
    @Override
    public String toString(){
        return author.getUsername() + " posted: " + textContent;
    }

    @Override
    public void displayPost() {
        System.out.println(author.getUsername() + " posted: " + textContent + "liked the post by users :  ");
        for (User user : likers) {
            user.displayName();
        }
    }
}
