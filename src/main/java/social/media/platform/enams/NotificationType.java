package social.media.platform.enams;

public enum NotificationType {
    LIKE("Like Notification", "User liked your post"),
    MESSAGE("Message Notification", "You have a new message!"),
    SHARE("Share Notification", "User shared your post");

    private String notification;
    private String description;

    NotificationType(String notification, String description) {
        this.notification = notification;
        this.description = description;
    }

    public String getNotification() {
        return notification;
    }

    public String getDescription() {
        return description;
    }

    public void showNotification() {
        System.out.println("Notification: " + notification);
        System.out.println("Description: " + description);
    }
}
