import java.util.ArrayList;
import java.util.List;

public class University {
    private final List<Faculty> faculties;

    public University() {
        this.faculties = new ArrayList<>();
    }

    public List<Faculty> getFaculties() {
        if (this.faculties.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("The university has no any faculties yet.");
        }
        return this.faculties;
    }

    public void addFaculty(Faculty faculty) {
        this.faculties.add(faculty);
    }


    public Faculty getFacultyByName(String facultyName) {
        return this.faculties.stream().filter(f -> f.getFacultyName() == facultyName).findFirst().orElse(null);
   }
}

