package social.media.platform.profile;

import social.media.platform.base.SocialEntity;
import social.media.platform.users.User;

import java.util.Objects;

import static jdk.internal.org.jline.utils.InfoCmp.Capability.user2;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile profile = (Profile) o;
        return Objects.equals(getUser(), profile.getUser()) && Objects.equals(getBio(), profile.getBio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getBio());
    }

    public  void displayProfile(){
        System.out.println("Surname of the user2 :" + user.getUsername() + " Bio :" +getBio());
    }
    public void displayProfileHash(){
    System.out.println("HashCod of profile  :" + hashCode());
    }
}
