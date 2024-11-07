package social.media.platform.groups;

import social.media.platform.users.User;
import social.media.platform.post.Post;

import java.util.List;

public class PrivateGroup extends Group {
    private String groupAccess;

    public PrivateGroup(User admin, String groupName, List<User> members, List<Post> postContent, String groupAccess) {
        super(admin, groupName, members, postContent);
        this.groupAccess = groupAccess;
    }

    public String getGroupAccess() {
        return groupAccess;
    }

    public void setGroupAccess(String groupAccess) {
        this.groupAccess = groupAccess;
    }

    @Override
    public void displayGroup() {
        super.displayGroup();
        System.out.print(groupAccess);
    }
}
