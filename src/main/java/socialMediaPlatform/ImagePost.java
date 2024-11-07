package socialMediaPlatform;



public class ImagePost extends Post{
    private String imageUrl;

    public ImagePost(User author, String content, String imageUrl) {
        super(author, content);
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public void displayPost() {
        super.displayPost();
        System.out.println(imageUrl);
    }
}
