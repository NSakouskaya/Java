import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String groupName;
    private String firstName;
    private String lastName;
    private ArrayList<Subject> subjects;

    public Student(int id, String groupName, String firstName, String lastName) {
        this.id = id;
        this.groupName = groupName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public String getGroupName() { return groupName; }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public List<Subject> getSubjects() {
        if (this.subjects.size() == 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("No subjects found for student %s %s", this.firstName, this.lastName));
        }
        return this.subjects;
    }

    public void addSubject(Subject subject) {
        if (this.subjects.stream().anyMatch(h -> h.getId() == subject.getId())) {
            throw new IllegalArgumentException("Student with the same ID is presented");
        }
        this.subjects.add(subject);
    }

    public Subject getSubjectById(int subjectId) {
        return this.subjects.stream().filter(f -> f.getId() == subjectId).findFirst().orElse(null);
    }
}
