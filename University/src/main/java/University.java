import java.util.ArrayList;
import java.util.List;

public class University {
    private final List<Faculty> faculties;
    private final List<Subject> subjects;

    public University() {
        this.faculties = new ArrayList<>();
        this.subjects = new ArrayList<>();
    }

    public List<Subject> getSubjects() {
        if (this.subjects.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("No available subjects have found.");
        }

        return this.subjects;
    }

    public List<Faculty> getFaculties() {
        if (this.faculties.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("The university has no any faculties yet.");
        }
        return this.faculties;
    }

    public void addFaculty(Faculty faculty) {
        this.faculties.add(faculty);
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public Faculty getFacultyByName(String facultyName) {
        return this.faculties.stream().filter(f -> f.getFacultyName().equals(facultyName)).findFirst().orElse(null);
    }

    public Subject getSubjectByName(String subjectName) {
        Subject sb = this.subjects.stream().filter(f -> f.getName().equals(subjectName)).findFirst().orElse(null);
        if (sb == null)
            throw new IllegalArgumentException(String.format("Subject '%s' not found!", subjectName));

        return sb;
    }
}

