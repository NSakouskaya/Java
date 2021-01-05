import java.util.ArrayList;

public class Group {

    private String groupName;
    private ArrayList<Student> students;

    public Group(String groupName) {
        this.groupName = groupName;
        this.students = new ArrayList<>();
    }

    public String getGroupName() {
        return this.groupName;
    }

    public ArrayList<Student> getStudents() {
        if (this.students.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException(String.format("The group '%s' has no any students", this.groupName));
        }

        return this.students;
    }

    public Student getStudentByName(String studentName) {
        if (this.students.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException(String.format("The group '%s' has no any students", this.groupName));
        }
        return this.students.stream().filter(student -> student.getName() == studentName).findFirst().orElse(null);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }



}