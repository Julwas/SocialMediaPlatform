package social.media.platform;


import social.media.platform.config.TextFileConfiguration;
import social.media.platform.enams.ContentType;
import social.media.platform.enams.PostPopularity;
import social.media.platform.enams.Sex;
import social.media.platform.exceptions.EmoticonNotFoundException;
import social.media.platform.exceptions.LimitPostsException;
import social.media.platform.exceptions.LimitationOfAuthorityException;
import social.media.platform.interfaces.Configuration;
import social.media.platform.media.AudioInfo;
import social.media.platform.media.ImageInfo;
import social.media.platform.media.VideoInfo;
import social.media.platform.actions.Comment;

import social.media.platform.message.AudioMessage;
import social.media.platform.message.ImageMessage;
import social.media.platform.message.VideoMessage;
import social.media.platform.post.*;
import social.media.platform.users.User;
import social.media.platform.events.Event;
import social.media.platform.groups.Group;

import social.media.platform.notifications.Notification;
import social.media.platform.profile.Profile;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

import static social.media.platform.enams.ContentType.*;

import static social.media.platform.enams.GroupPrivacyLevel.CLOSED;
import static social.media.platform.enams.GroupPrivacyLevel.OPEN;
import static social.media.platform.enams.NotificationType.*;
import static social.media.platform.enams.PostPopularity.*;
import static social.media.platform.enams.Sex.*;
import static social.media.platform.profile.AccessLevel.*;


public class Main {

    public static void main(String[] args) {
        User user1 = new User("Diana", "JulWas@gmail.com", "Wasilewska", 20, FEMALE);
        User user2 = new User("John", "JBin@gmail.com", "Bin", 25, MALE);
        User user3 = new User("Mark", "Mark@yahoo.com", "Sokolowski", 34, MALE);
        User user4 = new User("Milena", "Mila@wp.com", "Kownacka", 23, FEMALE);
        User user5 = new User("Roman", "romeo@gmail.com", "Kipier", 30, MALE);
        Configuration config = new TextFileConfiguration();
        Comment comment = new Comment(user5, " Awesome!!! ", List.of(user1, user2), user1);
        Comment comment1 = new Comment(user1, "  OMG! ", List.of(user3), user4);
        Comment comment2 = new Comment(user2, "  Hi! ", List.of(user4), user3);
        Comment comment3 = new Comment(user4, "  I will miss you! ", List.of(user1), user1);

        Notification not1 = new Notification(user1, MESSAGE);
        Notification not2 = new Notification(user2, SHARE);
        Notification not3 = new Notification(user3, LIKE);

        Profile profile1 = new Profile(user1, "I prefer a healthy lifestyle");
        Profile profile2 = new Profile(user2, "There is no description");
        Profile profile3 = new Profile(user3, "family photographer");
        Profile profile4 = new Profile(user4, "There is no description");
        Profile profile5 = new Profile(user5, "I like to read and listen to the sea");

        TextPost textPost1 = new TextPost(user1, List.of(comment2), List.of(user1, user3, user2),
                PUBLIC, not3, "Hi, everybody!", LOW);
        TextPost textPost2 = new TextPost(user2, List.of(comment3), List.of(user2, user4),
                MEMBERS, not3, " See you after the vacations", HIGH);
        TextPost textPost3 = new TextPost(user2, List.of(comment2), List.of(user1, user3, user2),
                PUBLIC, not3, "Traveling to Europe!", LOW);
        ImageInfo imageInfo = new ImageInfo("https://pic.pl/4.jpg", 120, 80);
        ImagePost imagePost2 = new ImagePost(user2, List.of(comment, comment1), List.of(user1, user3), PUBLIC,
                not3, imageInfo, MEDIUM);

        VideoInfo videoInfo4 = new VideoInfo(" https://xyz.pl/4.mp4", 180, 70, 15);
        VideoPost videoPost4 = new VideoPost(user4, List.of(comment), List.of(user4, user3), PUBLIC, not3, videoInfo4, LOW);
        VideoInfo videoInfo1 = new VideoInfo(" https://xyz.pl/4.mp4", 180, 70, 10);
        VideoPost videoPost1 = new VideoPost(user1, List.of(comment), List.of(user2), FRIENDS, not3, videoInfo1, MEDIUM);
        AudioInfo audioInfo = new AudioInfo("https://audio.pl/4.mp3", 120);
        VideoMessage videoMessage = new VideoMessage(user2, user4, "12.07.2024", videoInfo4, not1);
        AudioPost audioPost = new AudioPost(user3, List.of(comment1), List.of(user1, user2), audioInfo, PUBLIC, not3, LOW);
        AudioMessage audioMessage = new AudioMessage(user3, user5, " 01.08.2024", audioInfo, not1);
        ImageMessage imageMessage = new ImageMessage(user1, user4, "12.07.2024", imageInfo, not2);
        Event event = new Event(user3, " Big Christmas concert", " 23.12.2024  location: Prga Centrum," +
                " Szwedzka 2/4 Warsaw ");

        User admin = new User("Helen", "monro@gmail.com", "Monro", 30, FEMALE);
        User organizer = new User("Hanna", "organizer.big.concert@yahoo.com", "Bishop", 30, FEMALE);

        Group group = new Group("News of Warsaw ", admin, config, OPEN);
        Group closedGroup = new Group("Closed group", admin, config, CLOSED);
        not1.displayNotification();
        group.addMember(admin);
        closedGroup.setAdmin(admin);
        group.addMember(user1);
        group.addMember(user2);
        group.addMember(user3);
        System.out.println(" ADD POSTS");
        try {
            group.createPost(user1, textPost1, TEXT, LOW);
            group.createPost(user2, textPost2, TEXT, HIGH);
            group.createPost(user1, videoPost4, TEXT, LOW);
            group.createPost(user5, imagePost2, IMAGE, MEDIUM);
        } catch (LimitPostsException e) {
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

        } catch (EmoticonNotFoundException e) {
            System.err.println(e.getMessage());
        }

        try {
            comment2.sendEmoticon(":)");
        } catch (EmoticonNotFoundException e) {
            System.err.println(e.getMessage());
        }
        try {
            comment3.sendEmoticon(":( ");
        } catch (EmoticonNotFoundException e) {
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
        user1.addFriend(user4);
        profile1.userCreateProfile();
        profile5.userCreateProfile();
        profile3.userCreateProfile();
        profile3.createPost(user3, videoPost4, VIDEO, LOW);
        profile1.createPost(user1, videoPost1, VIDEO, MEDIUM);
        profile1.createPost(user1, textPost1, TEXT, LOW);
        profile2.createPost(user2, textPost2, TEXT, HIGH);
        profile2.createPost(user2, textPost3, TEXT, LOW);

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
        try {
            event.createPost(organizer, videoPost4, VIDEO, LOW);
            //event.createPost(user2,textPost2, TEXT);
            event.createPost(organizer, imagePost2, IMAGE, MEDIUM);
        } catch (LimitationOfAuthorityException e) {
            System.err.println(e.getMessage());
        }
        System.out.println();
        event.allPosts();
        try {
            event.deletePost(organizer, videoPost4);
            //event.deletePost(user3, imagePost2);
        } catch (LimitationOfAuthorityException e) {
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
        user2.displayName();
        System.out.print(" viewing post: ");
        videoPost1.displayPost();
        videoPost1.canView(user2);
        user1.displayName();
        System.out.print(" viewing post: ");
        videoPost4.displayPost();
        videoPost4.canView(user5);
        System.out.println();

        //lambda usage
        System.out.println();
        List<User> users = Arrays.asList(user1, user2, user3);

        // 1. Predicate: Filter users over 24 years old

        Predicate<User> isOlderThan24 = user -> user.getAge() > 24;
        List<User> olderUsers = users.stream().filter(isOlderThan24).collect(Collectors.toList());
        System.out.println("Users older than 24: " + olderUsers);

        // 2. Consumer: Display the name of each user

        Consumer<User> printUsername = user -> System.out.println("Username: " + user.getUsername());
        users.forEach(printUsername);

        // 3. Function: Преобразуем пользователя в список его постов
        List<Profile> profiles = Arrays.asList(profile1, profile2);

        Function<Profile, List<Post>> extractPosts = Profile::getPosts;

        List<Post> allPosts = profiles.stream()
                .flatMap(profile -> extractPosts.apply(profile).stream())
                .collect(Collectors.toList());
        System.out.println("All posts: " + allPosts);

        // 4. Supplier:

        Supplier<User> newUserSupplier = () -> new User("Agnieszka", "a.m@gmail.com",
                "Majewska", 20, FEMALE);
        User newUser = newUserSupplier.get();
        System.out.println("New User: " + newUser);

        // 5. BiFunction:  takes two parameters (name and email) and returns a User object

        BiFunction<String, String, User> createUser = (name, email) -> new User(name, email,
                "DefaultSurname", 18, OTHER);
        User user10 = createUser.apply("Moly", "1@gmail.com");
        User user11 = createUser.apply("Morti", "2@gmail.com");
        System.out.println(user10);
        System.out.println(user11);
        System.out.println();


        // 1: Counter to count friends of a user

        Function<User, Long> countFriends = user -> {
            long count = 0;
            for (User friend : user.getFriends()) {
                count++;
            }
            return count;
        };
        System.out.println("Number of friends for user1: " + countFriends.apply(user1));


        // 2 : Sorter to sort users by age

        Comparator<User> sortByAge = Comparator.comparingInt(User::getAge);
        users.sort(sortByAge);
        for (User user : users) {
            System.out.println("Sorted User: " + user);
        }

        // 3 : Transformer to uppercase usernames

        Function<User, String> transformUsername = user -> user.getUsername().toUpperCase();
        System.out.println("Uppercased Usernames:");
        for (User user : users) {
            System.out.println(transformUsername.apply(user));
        }
    }
}
