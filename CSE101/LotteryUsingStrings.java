package CSE101;

import java.util.Scanner;

public class LotteryUsingStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your lottery ticket number :");
        String ticket = input.next();

        //generate a random 2 digit number and convert to string
        String lottery = ""+(int)(Math.random()*100);
        System.out.println(lottery);

        if (ticket.equals(lottery)){
            System.out.print("You won, award is $10.000");
        }
        else if ((ticket.charAt(0) == lottery.charAt(1))
                && (ticket.charAt(1) == lottery.charAt(0))) {
            System.out.print("Your award is $3.000");
        }
        else if ((ticket.charAt(0)==lottery.charAt(0))
               ||(ticket.charAt(0)==lottery.charAt(1)
               ||(ticket.charAt(1)==lottery.charAt(0)
               ||(ticket.charAt(1)==lottery.charAt(1))))){
            System.out.print("Your award is $1.000");
        }
        else
            System.out.print("Sorry...");

    }
}
