package social.media.platform.groups;

import social.media.platform.base.SocialEntity;
import social.media.platform.users.User;
import social.media.platform.post.Post;

import java.util.*;

public class Group extends SocialEntity {
    private User admin;
    private String groupName;
    private List<User> members;
    private List<Post>posts;

    public Group(User admin, String groupName, List<User> members, List<Post> posts) {
        this.admin = admin;
        this.groupName = groupName;
        this.members = members;
        this.posts = posts;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
        System.out.println(" name of group: " + groupName + "Members of group:" );
        for (User user : members) {
            user.displayInfo();
        }
        System.out.println(" Posts: ");

        for (Post post : posts) {
            post.displayPost();
        }
        System.out.print("information about the group administrator: ");
        getAdmin().displayInfo();
    }
}
