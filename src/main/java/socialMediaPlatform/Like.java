package socialMediaPlatform;

public class Like {
    private Post post;

    public Like(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
    public void displayLike() {
        System.out.println("Post liked");
    }
}
