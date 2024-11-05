package socialMediaPlatform;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(0001L , "Julia", "JulWas@gmail.com", "Wasilewska", 20);
        User user2 = new User(0002L ,"John", "JBin@gmail.com", "Bin", 24);
        User user3 = new User(0003L ,"Mark", "Mark@yahoo.com", "Sokolowski", 34 );
        User user4 = new User(0004L ,"Bob", "bobi@yahoo.com", "Kapusta", 18 );
        Notification not1 = new Notification(user1, " You have a new message!");
        Profile profile2 = new Profile( user2, " I prefer a healthy lifestyle");
        Post post3 = new Post( user3, " Hi, everybody!");
        ImagePost imagePost2 = new ImagePost( user2 , " ", " ");
        VideoPost videoPost4 = new VideoPost( user4, "", " ");

        user1.displayInfo();
        not1.displayNotification();
        post3.displayPost();
        imagePost2.getImageUrl();
        videoPost4.displayPost();
        System.out.println( "Surname of the user2 :" +  user2.getSurname() + " Bio :" + profile2.getBio());
        System.out.println( "Age of the user 3 :" + user3.getAge() + "years.");
        System.out.println();

    }
}