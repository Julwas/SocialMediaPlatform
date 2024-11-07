package socialMediaPlatform;

public class PrivateEvent extends Event {
    private String eventAccess;

    public PrivateEvent(String eventName, String eventAccess) {
        super(eventName);
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
