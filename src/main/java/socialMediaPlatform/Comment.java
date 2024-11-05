package socialMediaPlatform;

public class Comment {
    private String text;

    public Comment(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public void displayComment() {
        System.out.println("Comment on post: " + text);
    }
}
