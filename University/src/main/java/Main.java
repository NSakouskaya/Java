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
                List<Grade> grades = student.getSubjects().stream().map(h -> h.getStudentGrades(student.getId()))
                        .flatMap(Collection::stream)
                        .collect(toList());
                double averageGrade = grades.stream().mapToInt(Grade::getGrade).average().getAsDouble();
                System.out.println(String.format("The average grade of student '%s %s' by all subjects is %.3f%n",
                        student.getFirstName(), student.getLastName(), averageGrade));
            }

          // to calculate average grade on faculty for specific group & subject (filters: faculty "Information Technologies", subject "Functional programming")
            Faculty faculty11 = university.getFacultyByName("Information Technologies");
            Group group11 = faculty1.getGroupByName("Beavers");
            Subject subject2 = group.getStudents().stream()
                    .flatMap(s -> s.getSubjects().stream().filter(subj -> subj.getName() == "Functional programming"))
                    .findFirst()
                    .orElse(null);
            List<Grade> grades = group.getStudents().stream().filter(f -> f.getSubjects().size() > 0).flatMap(f -> f.getSubjectByName("Functional programming").getStudentGrades(f.getId()).stream()).collect(toList());
            double averageGradeBySubject = grades.stream().mapToInt(Grade::getGrade).average().getAsDouble();
            System.out.println(String.format("The average grade on faculty '%s' by subject '%s' in the group '%s' is %.3f%n",
                    faculty1.getFacultyName(), subject2.getName(), group.getGroupName(), averageGradeBySubject));



            // to calculate average grade for a specific subject in University (filters: subject "Functional programming")
            List<Student> sts = university.getFaculties().stream().flatMap(faculty -> faculty.getGroups().stream().flatMap(g -> g.getStudents().stream())).collect(toList());
            List<Subject> subjects = sts.stream().flatMap(ss -> ss.getSubjects().stream()).distinct().collect(toList());

            Subject sb = subjects.stream().filter(f -> f.getName() == "Functional programming").findFirst().orElse(null);
            double averageGradeForUniversity = sb.getGrades().stream().mapToInt(Grade::getGrade).average().getAsDouble();
            System.out.println(String.format("The average grade by subject '%s' in University is %.3f%n",
                    sb.getName(), averageGradeForUniversity));

        }
        catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }
      }
    }



