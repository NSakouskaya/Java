public class Grade {

    private int studentId;
    private int grade;

    public int getStudentId () {
        return this.studentId;
    }

    public int getGrade() {
        return this.grade;
    }

    public Grade(int studentId, int grade) {
        this.studentId = studentId;

        if (grade < 0 || grade > 10)
            throw new IllegalArgumentException("The grade shouldn't be less than 0 or more than 10");
        this.grade = grade;
    }
}