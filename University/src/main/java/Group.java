import java.util.ArrayList;

public class Group {
    private String facultyName;
    private String groupName;
    private ArrayList<Student> students;

    public Group(String facultyName, String groupName) {
        this.facultyName = facultyName;
        this.groupName = groupName;
        this.students = new ArrayList<>();
    }

    public String getFacultyName() {
        return this.facultyName;
    }

    public String getGroupName() {
        return this.groupName;
    }


    public ArrayList<Student> getStudents() {
        if (this.students.size() == 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("The group '%s' has no any students", this.groupName));
        }
        return this.students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }


    public Student getStudentById(int studentId) {
        return this.students.stream().filter(f -> f.getId() == studentId).findFirst().orElse(null);
    }
}
