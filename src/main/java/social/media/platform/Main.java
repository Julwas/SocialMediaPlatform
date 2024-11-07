package social.media.platform;

import social.media.platform.actions.Comment;
import social.media.platform.actions.FriendRequest;
import social.media.platform.actions.Like;
import social.media.platform.message.AudioMessage;
import social.media.platform.message.ImageMessage;
import social.media.platform.message.TextMessage;
import social.media.platform.message.VideoMessage;
import social.media.platform.users.User;
import social.media.platform.events.Event;
import social.media.platform.events.PrivateEvent;
import social.media.platform.groups.Group;
import social.media.platform.groups.PrivateGroup;

import social.media.platform.notifications.Notification;
import social.media.platform.post.ImagePost;
import social.media.platform.post.TextPost;
import social.media.platform.post.VideoPost;
import social.media.platform.profile.Profile;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        User user1 = new User("Diana", "JulWas@gmail.com", "Wasilewska", 20);
        User user2 = new User("John", "JBin@gmail.com", "Bin", 24);
        User user3 = new User("Mark", "Mark@yahoo.com", "Sokolowski", 34);
        User user4 = new User("Milena", "Mila@wp.com", "Kownacka", 23);
        User user5 = new User("Roman", "romeo@gmail.com", "Kipier", 30);
        Notification not1 = new Notification(user1, " You have a new message!");
        Profile profile2 = new Profile(user2, " I prefer a healthy lifestyle");
        TextPost textPost1 = new TextPost(user1, "My post ", List.of(), "Hi, everybody!");
        ImagePost imagePost2 = new ImagePost(user2, " My image :", List.of(), " https://xyz.pl/1.jpg");
        VideoPost videoPost4 = new VideoPost(user4, " My video : ", List.of(), " https://xyz.pl/4.mp4");
        TextMessage textMessage = new TextMessage(user5, user1, "Hi, how is going");
        VideoMessage videoMessage = new VideoMessage(user2, user4, "https://video.pl/4.mp4");
        AudioMessage audioMessage = new AudioMessage(user3, user5, "https://audio.pl/4.mp3");
        ImageMessage imageMessage = new ImageMessage(user1, user4, "https://pic.pl/4.jpg");
        Event event = new Event(user1, " Big Christmas concert", List.of(user5, user3, user1, user2));
        PrivateEvent privateEvent = new PrivateEvent(user5, "My birthday ", List.of(user4, user1), " private ");
        Group group = new Group(user3, "News in Warsaw.  ", List.of(user1, user4, user2), List.of(textPost1, videoPost4));
        PrivateGroup privateGroup = new PrivateGroup(user4, " The little bees.  ", List.of(),
                List.of(), "Private");
        Comment comment = new Comment(user5, "  Amazing! ", imagePost2);
        Like like = new Like(user4, "  liked the post");
        FriendRequest friendRequest = new FriendRequest(user1, user3);

        user1.displayInfo();
        System.out.println();
        System.out.println("The user4 have the surname  :" + user4.getSurname() + " and have ID :" + user4.getId());
        System.out.println();
        System.out.println("Age of the user 3 :" + user3.getAge() + "years.");
        System.out.println();
        not1.displayNotification();
        System.out.println();
        textPost1.displayPost();
        System.out.println();
        imagePost2.displayPost();
        System.out.println();
        videoPost4.displayPost();
        System.out.println();
        System.out.println("Surname of the user2 :" + user2.getSurname() + " Bio :" + profile2.getBio());
        System.out.println();
        textMessage.displayMessage();
        System.out.println();
        videoMessage.displayMessage();
        System.out.println();
        audioMessage.displayMessage();
        System.out.println();
        imageMessage.displayMessage();
        System.out.println();
        event.displayEvent();
        System.out.println();
        privateEvent.displayEvent();
        System.out.println();
        group.displayGroup();
        System.out.println();
        privateGroup.displayGroup();
        System.out.println();
        like.displayLike();
        System.out.println(" image post " + imagePost2.getImageUrl() + like.getLiked());
        System.out.println();
        comment.displayComment();
        System.out.println();
        System.out.println(" image post " + imagePost2.getImageUrl() + comment.getText());
        System.out.println();
        friendRequest.displayRequest();
        System.out.println();
        friendRequest.displayAnswerRequest();
    }
}