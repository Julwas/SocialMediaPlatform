package social.media.platform.interfaces;

import social.media.platform.enams.ContentType;
import social.media.platform.enams.PostPopularity;
import social.media.platform.post.Post;
import social.media.platform.users.User;

public interface ContentManageable {
    void createPost(User author, Post post, ContentType contentType, PostPopularity postPopularity);
    void deletePost(User user, Post post);
}
