package social.media.platform.profile;

import social.media.platform.base.SocialEntity;
import social.media.platform.users.User;

public class Profile extends SocialEntity {
    private User user;
    private String bio;

    public Profile(User user, String bio) {
        this.user = user;
        this.bio = bio;
    }

    public User getUser() {
        return user;
    }

    public String getBio() {
        return bio;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

}
