package social.media.platform.notifications;

import social.media.platform.enams.NotificationType;
import social.media.platform.users.User;

public class Notification  {
    private User user;
   // private String message;
    private NotificationType notificationType;

    public Notification(User user, NotificationType notificationType) {
        this.user = user;
       // this.message = message;
        this.notificationType = notificationType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   /* public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }*/

    public void displayNotification() {
        System.out.println( user.getUsername() + " " + user.getSurname() + "got  ");
        notificationType.showNotification();
    }
}
