package social.media.platform.events;

import social.media.platform.base.SocialEntity;
import social.media.platform.users.User;

import java.util.List;

public class Event extends SocialEntity {
    private User organizer;
    private String eventName;
    private List<User> participants;

    public Event(User organizer, String eventName, List<User> participants) {
        this.organizer = organizer;
        this.eventName = eventName;
        this.participants = participants;
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

    public void displayEvent() {
        System.out.println(" Event: " + eventName + ", participants :");
        for (User user : participants) {
            user.displayInfo();
        }
        System.out.print( "information about the event administrator: ");
        getOrganizer().displayInfo();

    }
}
