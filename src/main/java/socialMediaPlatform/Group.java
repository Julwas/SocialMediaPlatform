package socialMediaPlatform;

public class Group {
    private String groupName;

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public void displayGroup(){
        System.out.println("Group: " + groupName);
    }
}
