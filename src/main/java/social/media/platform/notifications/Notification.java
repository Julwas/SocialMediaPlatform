package social.media.platform.notifications;

import social.media.platform.base.SocialEntity;
import social.media.platform.users.User;

public class Notification extends SocialEntity {
    private User user;
    private String message;

    public Notification(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void displayNotification() {
        System.out.println("Notification for " + user.getUsername() + " " + user.getSurname() + ":" + message);
    }
}
