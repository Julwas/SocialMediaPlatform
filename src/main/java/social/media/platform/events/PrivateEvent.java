package social.media.platform.events;

import social.media.platform.users.User;

import java.util.List;

public class PrivateEvent extends Event {
    private String eventAccess;

    public PrivateEvent(User organizer, String eventName, List<User> participants, String eventAccess) {
        super(organizer, eventName, participants);
        this.eventAccess = eventAccess;
    }

    public String getEventAccess() {
        return eventAccess;
    }

    public void setEventAccess(String eventAccess) {
        this.eventAccess = eventAccess;
    }

    @Override
    public void displayEvent() {
        System.out.print(eventAccess);
        super.displayEvent();
    }
}
