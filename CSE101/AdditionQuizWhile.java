package CSE101;

import java.util.Scanner;

public class AdditionQuizWhile {
    public static void main(String[] args) {
        //generate 2 random numbers between 0 - 10
        int num1 = (int) (Math.random()*10);
        int num2 =(int) (Math.random()*10);

        Scanner input = new Scanner(System.in);
        int answer=0;
        int sum = num1+num2;
        while (answer != sum) {
            System.out.printf("What is %d + %d ?",num1,num2);
            answer = input.nextInt();
            if (sum != answer)
                System.out.println("Wrong! Try again...");
        }

    }
}
