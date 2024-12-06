package social.media.platform.groups;

import social.media.platform.base.SocialEntity;
import social.media.platform.exeptions.LimitPostsExeption;
import social.media.platform.interfaces.Configuration;
import social.media.platform.users.User;
import social.media.platform.post.Post;


import java.util.*;

public class Group extends SocialEntity  {
    private static String groupName;
    private User admin;
    private List<User> members;
    private List<Post> posts;
    //private int maxPosts;
    private final Configuration configuration;


    public Group(String groupName, User admin, /*int maxPosts,*/ Configuration configuration) {
        Group.groupName = groupName;
        this.admin = admin;
       // this.maxPosts = maxPosts;
        this.members = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.members.add(admin);
        this.configuration = configuration;
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
        allPosts();
        System.out.print("information about the group administrator: ");
        getAdmin().displayName();
    }
    public  void allPosts(){
        System.out.println( "All group posts: ");
        for(Post post : posts){
            post.displayPost();
        }
    }

    public void addMember(User user) {
        members.add(user);
    }

    public boolean addPost(Post post) throws LimitPostsExeption {
        if (posts.size() < configuration.getMaxPosts()) {
        posts.add(post);
        System.out.println("Post added to group: " + groupName);
        post.displayPost();
        }
        else{
            throw new LimitPostsExeption("Failed to add a post. " +
                    "The post limit in the group has been exceeded.");
        }
        return false;
    }
}
