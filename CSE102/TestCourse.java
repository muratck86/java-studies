package CSE102;


public class TestCourse{
    public static void main(String[] args) {
        Course course1 = new Course("Data Structures");
        Course course2 = new Course("Database Systems");

        course1.addStudent("Peter Jones");
        course1.addStudent("Brian Smith");
        course1.addStudent("Anne Kennedy");

        course2.addStudent("Peter Jones");
        course2.addStudent("Steve Smith");

        System.out.println("Number of students in "+course1.getCourseName()+": "
                + course1.getNumberOfStudents());
        String[] students = course1.getStudents();
        for (int i = 0; i < course1.getNumberOfStudents(); i++)
            System.out.print(students[i] + ", ");

        course1.dropStudent("anne kennedy");
        System.out.println("Number of students in "+course1.getCourseName()+": "
                + course1.getNumberOfStudents());
        students = course1.getStudents();
        for (int i = 0; i < course1.getNumberOfStudents(); i++)
            System.out.print(students[i] + ", ");

        System.out.println();
        System.out.print("Number of students in "+course2.getCourseName()+": "
                + course2.getNumberOfStudents());
    }
}

class Course {
    private String courseName;
    private String[] students = new String[4];
    private int numberOfStudents = 0;

    public Course(String courseName){
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
    public void addStudent(String student){
        students[numberOfStudents] = student;
        numberOfStudents++;
    }
    public void dropStudent(String student){
        students[numberOfStudents] = null;
        numberOfStudents--;
    }

    public String[] getStudents() {
        return students;
    }public int getNumberOfStudents(){
       return numberOfStudents;
    }
}
