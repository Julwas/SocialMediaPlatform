package socialMediaPlatform;

public class TextPost extends Post {

    private String textContent;

    public TextPost(User author, String content, String textContent) {
        super(author, content);
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
        super.displayPost();
        System.out.println(textContent);
    }
}
