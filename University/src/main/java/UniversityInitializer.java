public class UniversityInitializer {

    public static University initialize() {

        Faculty faculty1 = new Faculty( "Information Technologies", "There students study any IT science");
        Faculty faculty2 = new Faculty( "Psychology", "Students study Psychology");

        Group group1 = new Group("Information Technologies", "Beavers");
        Group group3 = new Group("Information Technologies", "Hummers");
        Group group2 = new Group("Psychology", "Ducks");


        Student student1 = new Student(1, "Beavers", "Tom", "Bailey");
        Student student3 = new Student(3, "Beavers", "Oliver", "Baker");
        group1.addStudent(student1);
        group1.addStudent(student3);

        Student student2 = new Student(2, "Hummers", "Harry", "Atkinson");
        group2.addStudent(student2);

        Student student4 = new Student(4, "Ducks", "Jack", "Adams");
        Student student5 = new Student(5, "Ducks", "Oscar", "Dixon");
        group3.addStudent(student5);

        Subject subject1 = new Subject(1, "Operation systems", "discover all new features of new OS");
        Subject subject2 = new Subject(2, "Functional programming", "Study functional programming");
        Subject subject3 = new Subject(3, "Natural sciences", "Study natural sciences");

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

        subject1.addGrade(new Grade(1, 1, 7));
        subject1.addGrade(new Grade(2, 2, 8));
        subject1.addGrade(new Grade(3, 3, 5));
        subject1.addGrade(new Grade(4, 4, 5));
        subject1.addGrade(new Grade(5, 5, 5));
        subject1.addGrade(new Grade(6, 1, 5));

        subject2.addGrade(new Grade(1, 1, 7));
        subject2.addGrade(new Grade(2, 2, 4));
        subject2.addGrade(new Grade(3, 3, 6));
        subject2.addGrade(new Grade(4, 4, 8));
        subject2.addGrade(new Grade(5, 5, 9));
        subject2.addGrade(new Grade(6, 3, 7));

        subject3.addGrade(new Grade(1, 3, 7));
        subject3.addGrade(new Grade(2, 4, 4));
        subject3.addGrade(new Grade(3, 5, 6));
        subject3.addGrade(new Grade(4, 4, 8));
        subject3.addGrade(new Grade(5, 5, 9));
        subject3.addGrade(new Grade(6, 3, 7));

        University university = new University();
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        return university;
    }
}
