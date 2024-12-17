package social.media.platform.enams;

public enum GroupPrivacyLevel {
    OPEN("Open Group", "Anyone can join and see the content", true, true),
    CLOSED("Closed Group", "Anyone can find the group, but only members can see content", false, true);
    private final String name;
    private final String description;
    private final boolean isJoinableByAnyone;
    private final boolean isDiscoverable;

    // Конструктор
    GroupPrivacyLevel(String name, String description, boolean isJoinableByAnyone, boolean isDiscoverable) {
        this.name = name;
        this.description = description;
        this.isJoinableByAnyone = isJoinableByAnyone;
        this.isDiscoverable = isDiscoverable;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isJoinableByAnyone() {
        return isJoinableByAnyone;
    }

    public boolean isDiscoverable() {
        return isDiscoverable;
    }

    public void displayPrivacyInfo() {
        System.out.println("Group Privacy Level: " + name);
        System.out.println("Description: " + description);
        System.out.println("Joinable by anyone: " + (isJoinableByAnyone ? "Yes" : "No"));
        System.out.println("Discoverable: " + (isDiscoverable ? "Yes" : "No"));
    }
}
