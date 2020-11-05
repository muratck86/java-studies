package CSE101;

import java.util.Scanner;

public class SubtractionExerciseTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many questions?");
        int QUESTION_COUNT = input.nextInt();
        int correctCount = 0;
        int count = 1;
        int answer =-1;
        String resultMessage ="";
        System.out.println("Are you ready? (Start/Quit)(*/N)");
        String ready = input.next();
        if (ready.equalsIgnoreCase("N"))
            System.exit(1);
        long startTime =System.currentTimeMillis();
        while (count<=QUESTION_COUNT){
            int num1 = (int)(Math.random()*10);
            int num2 = (int)(Math.random()*10);

            if (num1<num2){
                int temp = num1;
                num1 = num2;
             num2 = temp;
            }
            System.out.printf("\n\nQ%02d:   What is %d - %d =? ",count,num1,num2);
            answer = input.nextInt();
            if (answer==(num1-num2)){
                System.out.print(" correct.");
                correctCount++;
            }
            else
                System.out.println("Your answer is wrong.");
            System.out.printf("\nA%02d:   %d - %d = %d",count,num1,num2,num1-num2);
            count++;
            resultMessage+="\n"+num1+" - "+num2+" = "+(num1-num2) + (((num1-num2)==answer) ? "  correct":"  wrong");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("\nResults :"+resultMessage);
        System.out.printf("\n\nTest duration is %02d mins. %02d secs",(endTime-startTime)/1000/60,(endTime-startTime)/1000%60);
        System.out.printf("\n%-10s%-10s%-10s","Question","Correct","Wrong");
        System.out.printf("\n%-10s%-10s%-10s",QUESTION_COUNT,correctCount,QUESTION_COUNT-correctCount);


    }
}
