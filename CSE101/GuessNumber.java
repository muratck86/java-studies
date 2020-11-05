package CSE101;

import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        int number = (int)(Math.random()*100);
        Scanner input = new Scanner(System.in);
        int count = 1;
        int guess = -1;
        while (guess!=number){
            System.out.printf("Anttempt %d :\n Your guess:",count);
            guess = input.nextInt();
            if (guess == number){
                System.out.printf("\nCongratulations, you hit it!\nIn %d times.",count);
            }
            else if (guess<number){
                System.out.println("\nGuess is too low, try again...");
            }
            else
                System.out.println("\nGuess is too high, try again...");
            count++;

        }
    }
}
