import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            University university = UniversityInitializer.initialize();

            // to calculate average grade by all subjects for a specific student (filters: student ID 1)
            Faculty faculty1 = university.getFacultyByName("Information Technologies");
            Group group = faculty1.getGroupByName("Beavers");
            Student student = group.getStudentById(1);
            if (student != null) {
                List<Grade> grades = student.getSubjects().stream()
                        .map(h -> h.getStudentGrades(student.getId()))
                        .flatMap(Collection::stream)
                        .collect(toList());
                double averageGrade = grades.stream().mapToInt(Grade::getGrade).average().getAsDouble();
                System.out.println(String.format("The average grade of student '%s %s' by all subjects is %.3f%n",
                        student.getFirstName(), student.getLastName(), averageGrade));
            }

            // to calculate average grade on faculty for specific group & subject (filters: faculty "Information Technologies", subject "Operation systems")
            String subjectName = "Operation systems";
            List<Grade> grades = group.getStudents().stream().filter(f -> f.getSubjects().size() > 0)
                    .flatMap(f -> f.getSubjectByName(subjectName).getStudentGrades(f.getId()).stream())
                    .collect(toList());
            double averageGradeBySubject = grades.stream().mapToInt(Grade::getGrade).average().getAsDouble();
            System.out.println(String.format("The average grade on faculty '%s' by subject '%s' in the group '%s' is %.3f%n",
                    faculty1.getFacultyName(), subjectName, group.getGroupName(), averageGradeBySubject));


            // to calculate average grade for a specific subject in University (filters: subject "Functional programming")
            double averageGradeForUniversity = university.getSubjectByName(subjectName)
                    .getGrades().stream().mapToInt(Grade::getGrade).average().getAsDouble();
            System.out.println(String.format("The average grade by subject '%s' in University is %.3f%n",
                    subjectName, averageGradeForUniversity));

        }
        catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}



