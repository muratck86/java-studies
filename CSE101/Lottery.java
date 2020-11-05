package CSE101;

import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your ticket number :");
        int ticket = input.nextInt();
        int lottery =(int)(Math.random()*100);
        if (lottery == ticket)
            System.out.println("Congratulations! You won the lottery, your award is $10.000");
        else if ((lottery/10 == ticket%10) && (lottery%10 == ticket/10))
            System.out.println("Congratulations! Your award is $3.000\nLucky number was "+lottery);
        else if ((lottery/10 == ticket%10) ^ (lottery%10 == ticket/10) ^ (lottery/10 == ticket/10) ^ (lottery%10 == ticket%10))
            System.out.println("Congratulations! Your award is $1.000\nLucky number was "+lottery);
        else
            System.out.println("Sorry not this time, please try again...\nLucky number was "+lottery);
    }
}
