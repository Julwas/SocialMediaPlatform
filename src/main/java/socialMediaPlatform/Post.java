package socialMediaPlatform;

import java.util.List;

public class Post {

    private User author;
    private String content;

    public Post(User author, String content) {
        this.author = author;
        this.content = content;
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

    public void displayPost() {
        System.out.println(author.getUsername() + " posted: " + content);
    }
}
