import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Subject {
    private int id;
    private String name;
    private String description;
    private List<Grade> grades;

    public Subject(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        grades = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return description;
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
