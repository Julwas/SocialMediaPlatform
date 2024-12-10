package social.media.platform.profile;

import social.media.platform.base.SocialEntity;
import social.media.platform.exeptions.NameContaihsfDigitExeption;
import social.media.platform.interfaces.Summarizable;
import social.media.platform.users.User;

import java.util.Objects;
import java.util.logging.Logger;

public class Profile extends SocialEntity implements Summarizable {
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


    public void displayProfileHash() {
        System.out.println("HashCod of profile  :" + hashCode());
    }

    //public void displayProfile() {}

    public void userCreateProfile() {
        System.out.print("User create profil: ");
        System.out.println(" add name :" + user.getUsername());
        try {
            user.addName();
            System.out.println("add surname :" + user.getSurname());
            System.out.println("add email :" + user.getEmail());
            System.out.println("add age :" + user.getAge());
            System.out.println("add Bio :" + bio);
            displaySummaryInfo();
        } catch (NameContaihsfDigitExeption e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void displaySummaryInfo() {
        System.out.println("Profile data: ");
        user.displaySummaryInfo();
        System.out.println(" Bio :" + bio);
    }
}
