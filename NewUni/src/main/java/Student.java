import java.util.EnumMap;
import java.util.List;

public class Student {

    private String name;
    private EnumMap<Subject, List<Integer>> subjects;

    public String getName() {
        return this.name;
    }


    public Student(String name) {
        this.name = name;
        this.subjects = new EnumMap<>(Subject.class);
    }

    public void addSubject(Subject subject, List<Integer> grades) {
        if (grades.stream().anyMatch(g -> g < 0 || g > 10))
            throw new IllegalArgumentException("The grade shouldn't be less than 0 or more than 10");

        this.subjects.put(subject, grades);
    }

    public List<Integer> getSubjectGrades(Subject key) { return this.subjects.get(key); }

    public EnumMap<Subject, List<Integer>> getSubjects() {
        if (this.subjects.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException(String.format("No subjects found for student %s", this.name));
        }

        return this.subjects;
    }
}
