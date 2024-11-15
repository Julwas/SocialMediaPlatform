package social.media.platform.actions;

import social.media.platform.base.SocialEntity;
import social.media.platform.users.User;

import java.util.List;

public class LikeInfo extends SocialEntity {
    private List<User> likers;


    public LikeInfo(List<User> likers) {
        this.likers = likers;
    }

    public List<User> getLikers() {
        return likers;
    }

    public void setLikers(List<User> likers) {
        this.likers = likers;
    }

}
