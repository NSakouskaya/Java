import java.util.ArrayList;

public class Faculty {

    private String facultyName;
    private String description;
    private ArrayList<Group> groups;

    public Faculty(String facultyName, String description) {
        this.facultyName = facultyName;
        this.description = description;
        groups = new ArrayList<>();
    }

     public String getFacultyName() { return facultyName; }

    public String getDescription() {
        return description;
    }

    public ArrayList<Group> getGroups() {
        if (this.groups.size() == 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("No groups found on the faculty '%s'", this.facultyName));
        }
        return this.groups;
    }

    public void addGroup(Group value) {
        this.groups.add(value);
    }


    public Group getGroupByName(String groupName) {
        return this.groups.stream().filter(f -> f.getGroupName() == groupName).findFirst().orElse(null);
    }
}
