package social.media.platform.base;

import java.util.Random;

public abstract class SocialEntity implements EntityWithId
{
    private Long id;

    public SocialEntity() {
        this(new Random().nextLong());
    }

    public SocialEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
