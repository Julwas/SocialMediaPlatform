package social.media.platform.events;

import social.media.platform.base.SocialEntity;
import social.media.platform.users.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Event extends SocialEntity {
    private User organizer;
    private String eventName;
    private String data;
    private List<User> participants;
    private User participant;

    public Event(User organizer, String eventName, String data) {
        this.organizer = organizer;
        this.eventName = eventName;
        this.data = data;
        this.participants = new ArrayList<>();
        this.participants.add(organizer);
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

}
