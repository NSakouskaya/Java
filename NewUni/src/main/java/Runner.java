import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class Runner {
    public static void main(String[] args) throws IOException {

        try {
        University university = UniInitializer.initialize();

        // to calculate average grade by all subjects for a specific student (filters: Davis)
        Faculty faculty1 = university.getFacultyByName("Information Technologies");
        Group group1 = faculty1.getGroup("Beavers");
        Student davis = group1.getStudentByName("Davis");
        double averageGradeForStudent = davis.getSubjects().values().stream()
                .flatMap(x -> x.stream())
                .collect(toList())
                .stream()
                .mapToInt(value -> value)
                .average()
                .getAsDouble();
        System.out.println(String.format("The average grade of student 'Davis' by all subjects is %.2f%n", averageGradeForStudent));

//      // to calculate average grade on faculty for specific group & subject (filters: faculty 'Psychology', group 'Hummers', subject 'MATH')
        Faculty faculty2 = university.getFacultyByName("Psychology");
        Group group2 = faculty2.getGroup("Hummers");
        Student bill = group2.getStudentByName("Bill");
        List<Integer> mathGrades = group2.getStudents().stream()
                .filter(student -> student.getSubjects().containsKey(Subject.MATH))
                .map(student -> student.getSubjectGrades(Subject.MATH)).flatMap(Collection::stream).collect(toList());
        double averageSubjectGrade = mathGrades.stream().mapToInt(value -> value).average().getAsDouble();
        System.out.println(String.format("The average grade on faculty '%s' by subject '%s' in the group '%s' is %.2f%n",
                faculty2.getName(), Subject.MATH, group2.getGroupName(), averageSubjectGrade));

        // to calculate average grade for a specific subject in University (filters: Subject.SCIENCE)
        List<Integer> grades = university.getFaculties().stream()
                .map(faculty -> faculty.getGroups())
                .flatMap(Collection::stream)
                .map(g -> g.getStudents())
                .flatMap(Collection::stream)
                .filter(st->st.getSubjects().containsKey(Subject.SCIENCE))
                .map(st -> st.getSubjectGrades(Subject.SCIENCE))
                .flatMap(Collection::stream)
                .collect(toList());
        double averageGradeForUniversity = grades.stream().mapToInt(value -> value).average().getAsDouble();
        System.out.println(String.format("The average grade by subject '%s' in University is %.2f%n",
                Subject.SCIENCE, averageGradeForUniversity));


//Check grades
        Student studentEmpty = new Student("Gary");
        studentEmpty.addSubject(Subject.SCIENCE, Arrays.asList(new Integer[] {11, 8, -5}));
        }
        catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }

}

