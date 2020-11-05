package CSE101;

public class TotalScore {
    public static void main(String[] args) {
        double[][][] scores = {
                {{7.5, 20.5}, {9.0, 22.5}, {15, 33.5}, {13, 21.5}, {15, 2.5}},
                {{4.5, 21.5}, {9.0, 22.5}, {15, 34.5}, {12, 20.5}, {14, 9.5}},
                {{6.5, 30.5}, {9.4, 10.5}, {11, 33.5}, {11, 23.5}, {10, 2.5}},
                {{6.5, 23.5}, {9.4, 32.5}, {13, 34.5}, {11, 20.5}, {16, 7.5}},
                {{8.5, 26.5}, {9.4, 52.5}, {13, 36.5}, {13, 24.5}, {16, 2.5}},
                {{9.5, 20.5}, {9.4, 42.5}, {13, 31.5}, {12, 20.5}, {16, 6.5}},
                {{1.5, 29.5}, {6.4, 22.5}, {14, 30.5}, {10, 30.5}, {16, 6.0}}};
        double total = 0;
        double examtotal = 0;
        for (int i =0; i < scores.length; i++){
            examtotal =0;
            System.out.printf("\nTotal score of student %d",i+1);
            for (int j = 0; j < scores[i].length;j++){
                total = 0;
                for (double s: scores[i][j])
                    total += s;
                System.out.printf("\n       Exam %d = %.2f", j+1, total);
                examtotal +=total;
            }
            System.out.println("\n       All exams Total :"+examtotal+"  Average : "+(examtotal/scores[i].length));
        }
    }
}
