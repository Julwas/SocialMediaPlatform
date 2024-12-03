package social.media.platform.groups;

import social.media.platform.base.SocialEntity;
import social.media.platform.users.User;
import social.media.platform.post.Post;

import java.util.*;

public class Group extends SocialEntity {
    private static String groupName;
    private User admin;
    private List<User> members;
    private List<Post> posts;

    static{
        groupName = "WarsawNews";
    }
    public Group(User admin, List<User> members, List<Post> posts) {
        this.admin = admin;
        this.members = members;
        this.posts = posts;
    }
    public static String getGroupName() {
        return groupName;
    }
    public static void setGroupName(String groupName) {
        Group.groupName = groupName;
    }
    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }


    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void displayGroup() {
        System.out.println(" name of group: " + groupName + "Members of group:");
        for (User user : members) {
           user.displayName();
        }
        System.out.println(" Posts: ");

        for (Post post : posts) {
            System.out.println(post);
        }
        System.out.print("information about the group administrator: ");
        getAdmin().displayName();
    }
}
