import java.util.ArrayList;
import java.util.List;

public class University {
    private final List<Faculty> faculties;

    public List<Faculty> getFaculties() {
        if (this.faculties.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("The university has no any faculties yet.");
        }

        return this.faculties;
    }

    public University() {
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        this.faculties.add(faculty);
    }

    public Faculty getFacultyByName(String name) {
        return this.faculties.stream().filter(f -> f.getName()==name).findFirst().orElse(null);
    }

}

