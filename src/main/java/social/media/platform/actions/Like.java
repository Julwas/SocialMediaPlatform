package social.media.platform.actions;

import social.media.platform.base.SocialEntity;
import social.media.platform.users.User;

public class Like extends SocialEntity {
    private User liker;
    private String liked;

    public Like(User liker, String liked) {
        this.liker = liker;
        this.liked = liked;
    }

    public String getLiked() {
        return liked;
    }

    public void setLiked(String liked) {
        this.liked = liked;
    }

    public void displayLike() {
        liker.displayInfo();
        System.out.println(liked);
    }
}
