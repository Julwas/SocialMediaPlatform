package social.media.platform.profile;

import social.media.platform.base.SocialEntity;
import social.media.platform.enams.ContentType;
import social.media.platform.enams.PostPopularity;
import social.media.platform.exceptions.NameContainsOfDigitException;
import social.media.platform.interfaces.ContentManager;
import social.media.platform.interfaces.Summarizable;
import social.media.platform.post.Post;
import social.media.platform.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Profile extends SocialEntity implements Summarizable, ContentManager {
    private User user;
    private String bio;
    private List<Post> posts;

    public List<Post> getPosts() {
        return posts;
    }

    public Profile(User user, String bio) {
        this.user = user;
        this.bio = bio;
        this.posts = new ArrayList<>();
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

    public void userCreateProfile() {
        System.out.print("User create profile: ");
        System.out.println(" add name :" + user.getUsername());
        try {
            user.addName();
            System.out.println("add surname :" + user.getSurname());
            System.out.println("add email :" + user.getEmail());
            System.out.println("add age :" + user.getAge());
            System.out.println("add Bio :" + bio);
            displaySummary();
        } catch (NameContainsOfDigitException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void displaySummary() {
        System.out.println("Profile data: ");
        user.displaySummary();
        System.out.println(" Bio :" + bio);
    }


    @Override
    public void createPost(User author, Post post, ContentType contentType, PostPopularity postPopularity) {
        posts.add(post);
    }

    @Override
    public void deletePost(User user, Post post) {
        posts.remove(post);
        System.out.println("Post deleted ");
    }
}
