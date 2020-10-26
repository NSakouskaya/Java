public class UniversityInitializer {

    public static University initialize() {

        Faculty faculty1 = new Faculty( "Information Technologies");
        Faculty faculty2 = new Faculty( "Psychology");

        Group group1 = new Group("Beavers");
        Group group3 = new Group("Hummers");
        Group group2 = new Group( "Ducks");


        Student student1 = new Student(1, "Tom", "Bailey");
        Student student3 = new Student(3, "Oliver", "Baker");
        group1.addStudent(student1);
        group1.addStudent(student3);

        Student student2 = new Student(2, "Harry", "Atkinson");
        group2.addStudent(student2);

        Student student4 = new Student(4, "Jack", "Adams");
        Student student5 = new Student(5, "Oscar", "Dixon");
        group3.addStudent(student5);

        Subject subject1 = new Subject("Operation systems");
        Subject subject2 = new Subject("Functional programming");
        Subject subject3 = new Subject("Natural sciences");

        student1.addSubject(subject1);
        student1.addSubject(subject2);

        student2.addSubject(subject1);
        student2.addSubject(subject2);

        student3.addSubject(subject1);
        student3.addSubject(subject2);
        student3.addSubject(subject3);

        student4.addSubject(subject1);
        student4.addSubject(subject2);
        student4.addSubject(subject3);

        student5.addSubject(subject1);
        student5.addSubject(subject2);
        student5.addSubject(subject3);

        faculty1.addGroup(group1);
        faculty1.addGroup(group3);
        faculty2.addGroup(group2);

        subject1.addGrade(new Grade( 1, 7));
        subject1.addGrade(new Grade( 2, 8));
        subject1.addGrade(new Grade(3, 5));
        subject1.addGrade(new Grade(4, 5));
        subject1.addGrade(new Grade( 5, 5));
        subject1.addGrade(new Grade(1, 5));

        subject2.addGrade(new Grade(1, 7));
        subject2.addGrade(new Grade( 2, 4));
        subject2.addGrade(new Grade( 3, 6));
        subject2.addGrade(new Grade( 4, 8));
        subject2.addGrade(new Grade( 5, 9));
        subject2.addGrade(new Grade( 3, 7));

        subject3.addGrade(new Grade( 3, 7));
        subject3.addGrade(new Grade( 4, 4));
        subject3.addGrade(new Grade( 5, 6));
        subject3.addGrade(new Grade( 4, 8));
        subject3.addGrade(new Grade( 5, 9));
        subject3.addGrade(new Grade( 3, 7));

        University university = new University();
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        return university;
    }
}
