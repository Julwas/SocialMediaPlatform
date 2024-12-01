package social.media.platform;

import social.media.platform.base.EntityWithId;
import social.media.platform.media.AudioInfo;
import social.media.platform.media.ImageInfo;
import social.media.platform.media.VideoInfo;
import social.media.platform.actions.Comment;
import social.media.platform.actions.FriendRequest;
import social.media.platform.message.AudioMessage;
import social.media.platform.message.ImageMessage;
import social.media.platform.message.TextMessage;
import social.media.platform.message.VideoMessage;
import social.media.platform.post.*;
import social.media.platform.users.User;
import social.media.platform.events.Event;
import social.media.platform.groups.Group;

import social.media.platform.notifications.Notification;
import social.media.platform.profile.Profile;

import java.time.LocalDate;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        final User user1 = new User("Diana", "JulWas@gmail.com", "Wasilewska", 20);
        User user2 = new User("John", "JBin@gmail.com", "Bin", 24);
        User user3 = new User("Mark", "Mark@yahoo.com", "Sokolowski", 34);
        User user4 = new User("Milena", "Mila@wp.com", "Kownacka", 23);
        User user5 = new User("Roman", "romeo@gmail.com", "Kipier", 30);

        Comment comment = new Comment(user5, " Awesome!!! ", List.of(user1, user2));
        Comment comment1 = new Comment(user1, "  OMG! ", List.of(user3));
        Comment comment2 = new Comment(user2, "  Hi! ", List.of(user5));
        Comment comment3 = new Comment(user4, "  I will miss you! ", List.of(user1));
        comment3.sendEmoticon("smile");

        Notification not1 = new Notification(user1, " You have a new message!");
        Profile profile2 = new Profile(user2, " I prefer a healthy lifestyle");
        Profile profile1 = new Profile(user1, " I prefer a healthy lifestyle");
        TextPost textPost1 = new TextPost(user1, "My post ", List.of(comment2), List.of(user1, user3, user2),
                "Hi, everybody!");
        TextPost textPost2 = new TextPost(user2, "My post ", List.of(comment3), List.of(user2, user5),
                " See you after the vacations");
        ImageInfo imageInfo = new ImageInfo("https://pic.pl/4.jpg", 120, 80);
        ImagePost imagePost2 = new ImagePost(user2, " My image :", List.of(comment, comment1), List.of(user1, user3), imageInfo);

        VideoInfo videoInfo = new VideoInfo(" https://xyz.pl/4.mp4", 180, 70, 15);
        VideoPost videoPost4 = new VideoPost(user4, " My video : ", List.of(comment), List.of(user4, user3, user5), videoInfo);
        TextMessage textMessage = new TextMessage(user5, user1, "Hi, how is going",
                "https://emoticon/fire.jpg");
        AudioInfo audioInfo = new AudioInfo("https://audio.pl/4.mp3", 120);
        VideoMessage videoMessage = new VideoMessage(user2, user4,"12.07.2024", videoInfo);
        AudioPost audioPost = new AudioPost(user1, " my Post ", List.of(comment1), List.of(user1, user2),
                "https://emoticon/fire.jpg", audioInfo);
        AudioMessage audioMessage = new AudioMessage(user3, user5, " 01.08.2024",audioInfo);
        ImageMessage imageMessage = new ImageMessage(user1, user4, "12.07.2024", imageInfo);
        Event event = new Event(user3, " Big Christmas concert", " 23.12.2024  location: Prga Centrum," +
                " Szwedzka 2/4 Warsaw ", List.of(user1, user4, user2, user3), user5);
        Group group = new Group(user3, "News in Warsaw.  ", List.of(user1, user4, user2),
                List.of(textPost1, textPost2));


        FriendRequest friendRequest = new FriendRequest(user1, user3, " 01.12.2024", "accept");

        if (profile1.equals(profile2)) {
            System.out.println("Profils are Equal ");
        } else {
            System.out.println("Profils are not Equal ");
        }
        user1.displayInfo();
        System.out.println();
        System.out.println("The user4 have the surname  :" + user4.getSurname() + " and have ID :" + user4.getId());
        System.out.println();
        System.out.println("Age of the user 3 :" + user3.getAge() + "years.");
        System.out.println("notification");
        not1.displayNotification();
        System.out.println();
        textPost1.displayPost();
        System.out.println();
        imagePost2.displayPost();
        System.out.println();
        videoPost4.displayPost();
        System.out.println();
        profile2.displayProfile();
        System.out.println();
        profile2.displayProfileHash();
        System.out.println();
        audioPost.displayPost();
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
        event.addPartcipant();
        System.out.println();
        group.displayGroup();
        System.out.println();
        comment3.displayComment();
        System.out.println();
        friendRequest.displayRequest();
        System.out.println();
        friendRequest.displayAnswerRequest();

        printStringWithId("I have an id: ", imageMessage);
        printStringWithId("I have an id too: ", group);
        LocalDate myObj = LocalDate.now();
        System.out.println(myObj);
    }

    private static void printStringWithId(String str, EntityWithId entity) {
        System.out.println(str + entity.getId());
    }
}