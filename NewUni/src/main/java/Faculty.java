import java.util.ArrayList;

public class Faculty {

    private String name;
    private ArrayList<Group> groups;


    public String getName() {
        return this.name;
    }

    public ArrayList<Group> getGroups() {
        if (this.groups.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException(String.format("No groups found on the faculty '%s'", this.name));
        }

        return this.groups;
    }

    public void addGroup(Group value) {
        this.groups.add(value);
    }

    public Faculty(String name) {
        this.name = name;
        groups = new ArrayList<>();
    }

    public Group getGroup(String groupName) {
        return this.groups.stream().filter(f -> f.getGroupName()==groupName).findFirst().orElse(null);
    }

}