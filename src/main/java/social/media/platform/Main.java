package social.media.platform;


import social.media.platform.config.TextFileConfiguration;
import social.media.platform.exeptions.EmoticonNotFoundExeption;
import social.media.platform.exeptions.LimitPostsExeption;
import social.media.platform.exeptions.LimitationOfAuthorityExeption;
import social.media.platform.interfaces.Configuration;
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
import java.util.Date;
import java.util.List;

import static social.media.platform.profile.AccessLevel.*;


public class Main {

    public static void main(String[] args) {
        User user1 = new User("Diana", "JulWas@gmail.com", "Wasilewska", 20);
        User user2 = new User("John", "JBin@gmail.com", "Bin", 24);
        User user3 = new User("Mark", "Mark@yahoo.com", "Sokolowski", 34);
        User user4 = new User("Milena", "Mila@wp.com", "Kownacka", 23);
        User user5 = new User("Roman", "romeo@gmail.com", "Kipier", 30);
        Configuration config = new TextFileConfiguration();
        Comment comment = new Comment(user5, " Awesome!!! ", List.of(user1, user2), user1);
        Comment comment1 = new Comment(user1, "  OMG! ", List.of(user3), user4);
        Comment comment2 = new Comment(user2, "  Hi! ", List.of(user4), user3);
        Comment comment3 = new Comment(user4, "  I will miss you! ", List.of(user1), user1);

        Notification not1 = new Notification(user1, " You have a new message!");
        Profile profile1 = new Profile(user1, "I prefer a healthy lifestyle");
        Profile profile2 = new Profile(user2, "There is no description");
        Profile profile3 = new Profile(user3, "family photographer");
        Profile profile4 = new Profile(user4, "There is no description");
        Profile profile5 = new Profile(user5, "I like to read and listen to the sea");

        TextPost textPost1 = new TextPost(user1, List.of(comment2), List.of(user1, user3, user2),
                PUBLIC, "Hi, everybody!");
        TextPost textPost2 = new TextPost(user2, List.of(comment3), List.of(user2, user4),
                MEMBERS, " See you after the vacations");
        ImageInfo imageInfo = new ImageInfo("https://pic.pl/4.jpg", 120, 80);
        ImagePost imagePost2 = new ImagePost(user2, List.of(comment, comment1), List.of(user1, user3), imageInfo, PUBLIC);

        VideoInfo videoInfo = new VideoInfo(" https://xyz.pl/4.mp4", 180, 70, 15);
        VideoPost videoPost4 = new VideoPost(user4, List.of(comment),
                List.of(user4, user3, user1), videoInfo, FRIENDS);
        TextMessage textMessage = new TextMessage(user5, user1, "Hi, how is going",
                "https://emoticon/fire.jpg");
        AudioInfo audioInfo = new AudioInfo("https://audio.pl/4.mp3", 120);
        VideoMessage videoMessage = new VideoMessage(user2, user4, "12.07.2024", videoInfo);
        AudioPost audioPost = new AudioPost(user3, List.of(comment1), List.of(user1, user2),
                audioInfo, PUBLIC);
        AudioMessage audioMessage = new AudioMessage(user3, user5, " 01.08.2024", audioInfo);
        ImageMessage imageMessage = new ImageMessage(user1, user4, "12.07.2024", imageInfo);
        Event event = new Event(user3, " Big Christmas concert", " 23.12.2024  location: Prga Centrum," +
                " Szwedzka 2/4 Warsaw ");

        User admin = new User("Helen", "monro@gmail.com", "Monro", 30);
        User organizer = new User("Hanna", "organizer.big.concert@yahoo.com", "Bishop", 30);

        Group group = new Group("News of Warsaw ", admin, config);

        group.addMember(admin);
        group.addMember(user1);
        group.addMember(user2);
        group.addMember(user3);
        System.out.println(" ADD POSTS");
        try {
            group.createPost(user1, textPost1);
            group.createPost(user2, textPost2);
            group.createPost(user1, videoPost4);
            //group.createPost(imagePost2);
        } catch (LimitPostsExeption e) {
            System.err.println(e.getMessage());
        }
        System.out.println(" All posts in grope: ");
        group.allPosts();
        group.deletePost(user1, textPost1);
        System.out.println(" All posts since deletede: ");
        group.allPosts();

        TextFileConfiguration.readConfiguration();

        System.out.println();

        try {
            comment1.sendEmoticon("heart ");

        } catch (EmoticonNotFoundExeption e) {
            System.err.println(e.getMessage());
        }

        try {
            comment2.sendEmoticon(":)");
        } catch (EmoticonNotFoundExeption e) {
            System.err.println(e.getMessage());
        }
        try {
            comment3.sendEmoticon(":( ");
        } catch (EmoticonNotFoundExeption e) {
            System.err.println(e.getMessage());
        }

        if (profile1.equals(profile2)) {
            System.out.println("Profiles are Equal ");
        } else {
            System.out.println("Profiles are not Equal ");
        }
        user5.setUsername("Olga2");

        user1.addFriend(user2);
        user2.addFriend(user3);
        user1.addFriend(user3);
        profile5.userCreateProfile();
        profile3.userCreateProfile();
        profile3.createPost(user3, videoPost4);

        user1.getUsername();
        user1.displayName();
        imagePost2.open();
        videoPost4.play();
        user1.displayName();
        videoPost4.pause();
        user1.displaySummary();
        user2.displayName();
        textPost1.open();

        System.out.println();
        System.out.println("The user4 have the surname  :" + user4.getSurname() + " and have ID :" + user4.getId());
        System.out.println();
        System.out.println("Age of the user 3 :" + user3.getAge() + "years.");

        System.out.println();
        not1.displayNotification();

        System.out.println();
        textPost1.displayPost();
        comment2.displayComment();
        System.out.println();
        imagePost2.displayPost();
        System.out.println();
        videoPost4.displayPost();

        System.out.println();
        profile2.displaySummary();
        System.out.println();
        profile4.displayProfileHash();

        System.out.println();
        audioPost.displayPost();

        comment3.displayComment();
        System.out.println();

        textMessage.displayMessage();
        System.out.println();
        videoMessage.displayMessage();
        System.out.println();
        audioMessage.displayMessage();
        System.out.println();
        imageMessage.displayMessage();
        System.out.println();

        System.out.println();
        event.addParticipant(organizer);
        event.addParticipant(user2);
        event.addParticipant(user3);
        event.addParticipant(user1);
        try{
        event.createPost(organizer, videoPost4);
       // event.createPost(user2,textPost2);
        event.createPost(organizer, imagePost2);
        } catch (LimitationOfAuthorityExeption e) {
            System.err.println(e.getMessage());
        }
        System.out.println();
        event.allPosts();
        try{
        event.deletePost(organizer, videoPost4);
        //event.deletePost(user3, imagePost2);
        }catch (LimitationOfAuthorityExeption e) {
            System.err.println(e.getMessage());
        }
        System.out.println();
        event.allPosts();
        event.displayEvent();
        System.out.println();
        group.displaySummary();
        System.out.println();
        comment1.displayComment();
        System.out.println();

       // friendRequest.addFriend(user1, user2);

        System.out.println();
        System.out.println(" User create profile:");
        user5.setUsername("Olga2");
        profile1.userCreateProfile();
        System.out.println();
        user2.setUsername("Bob");
        System.out.println();
        profile2.userCreateProfile();
        profile3.userCreateProfile();

        System.out.println();
        user3.displayName();
        System.out.print(" viewing  post: " + textPost2);
        textPost2.canView(user3);
        user1.displayName();
        System.out.println(" viewing post: " + videoPost4);
        videoPost4.canView(user1);
        user5.getUsername();
        System.out.println( " viewing post: " + videoPost4);
        videoPost4.canView(user5);
    }
    }
