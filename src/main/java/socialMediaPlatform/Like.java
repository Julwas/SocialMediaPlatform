package socialMediaPlatform;

public class Like {
    private String liked;

    public Like( String liked) {
        this.liked = liked;
    }

    public String getLiked() {
        return liked;
    }

    public void setLiked(String liked) {
        this.liked = liked;
    }

    public void displayLike() {
        System.out.println(liked);
    }
}
