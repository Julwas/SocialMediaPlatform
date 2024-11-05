package socialMediaPlatform;

public class Event {
    private String eventName;

    public Event(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void displayEvent() {
        System.out.println("Event: " + eventName);
    }
}
