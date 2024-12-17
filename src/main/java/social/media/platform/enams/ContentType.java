package social.media.platform.enams;

public enum ContentType {
    TEXT("Text Content", "Text-based posts"),
    IMAGE("Image Content", "Posts containing images"),
    VIDEO("Video Content", "Posts containing video");

    private String title;
    private String description;

    ContentType(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void displayContentInfo() {
        System.out.println("Content Type: " + title + "Description: " + description);
    }
}
