package social.media.platform.events;

import social.media.platform.base.SocialEntity;
import social.media.platform.exeptions.LimitPostsExeption;
import social.media.platform.exeptions.LimitationOfAuthorityExeption;
import social.media.platform.interfaces.ContentManager;
import social.media.platform.post.Post;
import social.media.platform.users.User;

import java.util.ArrayList;

import java.util.List;


public class Event extends SocialEntity implements ContentManager {
    private User organizer;
    private String eventName;
    private String data;
    private List<User> participants;
    private User participant;
    private List<Post> posts;


    public Event(User organizer, String eventName, String data) {
        this.organizer = organizer;
        this.eventName = eventName;
        this.data = data;
        this.participants = new ArrayList<>();
        this.participants.add(organizer);
        this.posts = new ArrayList<>();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public void setParticipant(User participant) {
        this.participant = participant;
    }

    public User getParticipant() {
        return participant;
    }

    public void allPosts() {
        System.out.println("All event posts: ");
        for (Post post : posts) {
            post.displayPost();
        }
    }

    public void displayEvent() {
        System.out.println(" Event: " + eventName + " Data: " + getData() + ", participants :");
        for (User user : participants) {
            user.displayName();
        }
        System.out.print("information about the event administrator: ");
        getOrganizer().displayName();
    }

    public void addParticipant(User user) {
        participants.add(user);
    }

    @Override
    public void createPost(User author, Post post) throws LimitationOfAuthorityExeption {
        if (author.equals(organizer)) {
            posts.add(post);
        } else {
            throw new LimitationOfAuthorityExeption("Failed to add a post. Only the organizer can add posts.");
        }

    }

    @Override
    public void deletePost(User user, Post post) throws LimitationOfAuthorityExeption {
        if (user.equals(organizer)) {
            posts.remove(post);
            System.out.println("Post removed ");
        } else {
            throw new LimitationOfAuthorityExeption("Failed to delete a post. Only the organizer can delete posts.");
        }
    }
}
