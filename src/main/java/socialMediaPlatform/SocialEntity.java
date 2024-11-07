package socialMediaPlatform;

import java.util.List;

public class SocialEntity {
    private Long id;

    public SocialEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void displayId() {
        //System.out.println("Username: " + username + id );
    }
}
