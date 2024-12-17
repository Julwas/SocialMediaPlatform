package social.media.platform.groups;

import social.media.platform.base.SocialEntity;
import social.media.platform.enams.ContentType;
import social.media.platform.enams.GroupPrivacyLevel;
import social.media.platform.enams.PostPopularity;
import social.media.platform.exceptions.LimitPostsException;
import social.media.platform.interfaces.Configuration;
import social.media.platform.interfaces.ContentManageable;
import social.media.platform.interfaces.Summarizable;
import social.media.platform.users.User;
import social.media.platform.post.Post;


import java.util.*;

public class Group extends SocialEntity implements Summarizable, ContentManageable {
    private String groupName;
    private User admin;
    private List<User> members;
    private List<Post> posts;
    private final Configuration configuration;
    private Map<Post, ContentType> postContentTypes = new HashMap<>();
    private GroupPrivacyLevel privacyLevel;

    public Group(String groupName, User admin, Configuration configuration, GroupPrivacyLevel privacyLevel) {
        this.groupName = groupName;
        this.admin = admin;
        this.members = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.members.add(admin);
        this.configuration = configuration;
        this.privacyLevel = privacyLevel;
    }

    public String getGroupName() {
        return groupName;
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

    public void allPosts() {
        System.out.println("All group posts: ");
        for (Post post : posts) {
            post.displayPost();
        }
    }

    public void addMember(User user) {
        if (privacyLevel == GroupPrivacyLevel.OPEN || privacyLevel == GroupPrivacyLevel.CLOSED) {
            if (!members.contains(user)) {
                members.add(user);
                System.out.println(user.getUsername() + " has joined the group: " + groupName);

            } else {
                System.out.println(user.getUsername() + " is already a member of the group: " + groupName);

            }
        } else {
            System.out.println("This is a SECRET group. Invitation is required to join.");

        }
    }

    public boolean isGroupVisible() {
        return privacyLevel.isDiscoverable();
    }

    public GroupPrivacyLevel getPrivacyLevel() {
        return privacyLevel;
    }

    public void setPrivacyLevel(GroupPrivacyLevel privacyLevel) {
        this.privacyLevel = privacyLevel;
        System.out.println("Group privacy level has been updated to: " + privacyLevel.getName());
    }

    @Override
    public void displaySummary() {
        System.out.println(" name of group: " + groupName + "Members of group:");
        for (User user : members) {
            user.displayName();
        }
        privacyLevel.displayPrivacyInfo();
        allPosts();
        System.out.print("information about the group administrator: ");
        getAdmin().displayName();
    }

    @Override
    public void createPost(User author, Post post, ContentType contentType,
                           PostPopularity postPopularity) throws LimitPostsException {
        if (posts.size() < configuration.getMaxPosts()) {
            post.setGroup(this);
            postContentTypes.put(post, contentType);
            post.setPostPopularity(postPopularity);
            contentType.displayContentInfo();
            postPopularity.displayPopularityInfo();
            posts.add(post);
            System.out.println("Post added to group: " + groupName);
            post.displayPost();
        } else {
            throw new LimitPostsException("Failed to add a post. The post limit in the group has been exceeded");
        }
    }

    @Override
    public void deletePost(User user, Post post) {
        posts.remove(post);
        System.out.println("Post deleted ");
    }

}
