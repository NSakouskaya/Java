import java.util.Arrays;

public class UniInitializer {
    public static University initialize() {
        Faculty faculty1 = new Faculty("Information Technologies");
        Faculty faculty2 = new Faculty( "Psychology");

        Group group1 = new Group("Beavers");
        Group group2 = new Group("Hummers");


        Student student1 = new Student("Davis");
        student1.addSubject(Subject.MATH, Arrays.asList(new Integer[] {7, 7, 8, 6}));
        student1.addSubject(Subject.SCIENCE, Arrays.asList(new Integer[] {10, 8, 6}));
        student1.addSubject(Subject.SOFTWARE_DEV, Arrays.asList(new Integer[] {5, 5, 5}));
        group1.addStudent(student1);

        Student student2 = new Student("Mary");
        student2.addSubject(Subject.SCIENCE, Arrays.asList(new Integer[] {10, 8, 6}));
        student2.addSubject(Subject.SOFTWARE_DEV, Arrays.asList(new Integer[] {5, 5, 5}));
        group1.addStudent(student2);


        Student student3 = new Student("Bill");
        student3.addSubject(Subject.MATH, Arrays.asList(new Integer[] {8, 8, 8, 8}));
        student3.addSubject(Subject.SCIENCE, Arrays.asList(new Integer[] {5, 6, 7, 8}));
        group2.addStudent(student3);


        faculty1.addGroup(group1);
        faculty2.addGroup(group2);

        University university = new University();
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        return university;
    }
}
