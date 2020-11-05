package CSE101;

public class GradeExam {
    public static void main(String[] args) {
        char[] key = {'D','B','D','C','C','D','A','E','A','D'};
        char[][] students = {
                {'A','B','A','C','C','D','E','E','A','D'},
                {'D','B','A','B','C','A','E','E','A','D'},
                {'E','D','D','A','C','B','E','E','A','D'},
                {'C','B','A','E','D','C','E','E','A','D'},
                {'A','B','D','C','C','D','E','E','A','D'},
                {'B','B','E','C','C','D','E','E','A','D'},
                {'B','B','A','C','C','D','E','E','A','D'},
                {'E','B','E','C','C','D','E','E','A','D'}
        };
        for (int i = 0; i < students.length; i++){
            System.out.println("Student "+i+" Grade: "+gradeStudent(students[i],key));
        }

    }
    public static double gradeStudent(char[] ans, char[] key){
        double studentPoint = 0;
        for (int i = 0; i < key.length; i++){
            if (ans[i]==key[i])
                studentPoint ++;
        }
        return studentPoint;
    }


}
