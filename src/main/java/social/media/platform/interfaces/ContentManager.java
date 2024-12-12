package social.media.platform.interfaces;

import social.media.platform.post.Post;
import social.media.platform.users.User;

public interface ContentManager {
    void createPost(User user, Post post);
    void deletePost(User user, Post post);
}
