import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Subject {
    private String name;
    private List<Grade> grades;

    public Subject(String name) {
        this.name = name;
        grades = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Grade> getGrades() { return this.grades; }


    public void addGrade(Grade grade) {
        try {
            this.grades.add(grade);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Grade> getStudentGrades(int studentId) {
        return this.grades.stream().filter(grade -> grade.getStudentId() == studentId).collect(Collectors.toList());
    }
}
