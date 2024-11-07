package socialMediaPlatform;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(0001L, "Diana", "JulWas@gmail.com", "Wasilewska", 20);
        User user2 = new User(0002L, "John", "JBin@gmail.com", "Bin", 24);
        User user3 = new User(0003L, "Mark", "Mark@yahoo.com", "Sokolowski", 34);
        User user4 = new User(0004L, "Milena", "Mila@wp.com", "Kownacka", 23);
        User user5 = new User(0005L, "Roman", "romeo@gmail.com", "Kipier", 30);
        Notification not1 = new Notification(user1, " You have a new message!");
        Profile profile2 = new Profile(user2, " I prefer a healthy lifestyle");
        Post post = new Post(user3, " My post!");
        TextPost textPost1 = new TextPost(user1, "My post ", "Hi, everybody!");
        ImagePost imagePost2 = new ImagePost(user2, " My image :", " https://xyz.pl/1.jpg");
        VideoPost videoPost4 = new VideoPost(user4, " My video : ", " https://xyz.pl/4.mp4");
        Message message1 = new Message(user1, user2, " sent a new message to ");
        TextMessage textMessage = new TextMessage(user5, user1, "sent a new message to ",
                "Hi, how is going");
        VideoMessage videoMessage = new VideoMessage(user2, user4, "sent a new message to ",
                "https://video.pl/4.mp4");
        AudioMessage audioMessage = new AudioMessage(user3, user5, "sent a new message to ",
                "https://audio.pl/4.mp4");
        ImageMessage imageMessage = new ImageMessage(user1, user4, "sent a new message to ",
                "https://pic.pl/4.mp4");
        Event event = new Event(" Big Christmas concert");
        PrivateEvent privateEvent = new PrivateEvent("My birthday ", " private ");
        Group group = new Group("News in Warsaw");
        PrivateGroup privateGroup = new PrivateGroup(" The little bees", "private");
        Comment comment = new Comment("  Amazing! ");
        Like like = new Like("  liked the post");
        FriendRequest friendRequest = new FriendRequest(user1, user3);

        user1.displayInfo();
        System.out.println("The user4 have the surname  :" + user4.getSurname() + " and have ID :" + user4.getId());
        System.out.println("Age of the user 3 :" + user3.getAge() + "years.");
        not1.displayNotification();
        post.displayPost();
        textPost1.displayPost();
        imagePost2.displayPost();
        videoPost4.displayPost();
        System.out.println("Surname of the user2 :" + user2.getSurname() + " Bio :" + profile2.getBio());
        message1.displayMessage();
        textMessage.displayMessage();
        videoMessage.displayMessage();
        audioMessage.displayMessage();
        imageMessage.displayMessage();
        event.displayEvent();
        privateEvent.displayEvent();
        group.displayGroup();
        privateGroup.displayGroup();
        System.out.println(" image post " + imagePost2.getImageUrl() + like.getLiked());
        System.out.println(" image post " + imagePost2.getImageUrl() + comment.getText());
        friendRequest.displayRequest();
        friendRequest.displayAnswerRequest();
    }
}