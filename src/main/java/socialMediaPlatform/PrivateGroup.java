package socialMediaPlatform;

public class PrivateGroup extends Group {
    private String groupAccess;

    public PrivateGroup(String groupName, String groupAccess) {
        super(groupName);
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
        System.out.println(groupAccess);
        super.displayGroup();
    }
}
