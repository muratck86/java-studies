package CSE101;

import java.util.Scanner;

public class IsLeapYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year :");
        int year = input.nextInt();
        boolean isLeapYear = (((year % 4 ==0) && (year % 100 != 0)) || (year % 400 == 0));
        if (isLeapYear)
            System.out.println("The year "+year+" is a leap year...");
        else
            System.out.println("The year "+year+" is NOT a leap year...");
    }
}
