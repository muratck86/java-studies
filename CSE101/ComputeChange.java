package CSE101;

import java.util.Scanner;

public class ComputeChange {
    public static void main(String[] args) {

        //Create Scanner Object name it input
        Scanner input = new Scanner(System.in);

        //Get the amount
        System.out.println("Enter amount of money : ");
        double givenAmount = input.nextDouble();
        //Convert to pennies
        int amount = (int) (givenAmount*100);

        //One $s
        int one$s = amount/100;
        amount = amount%100;

        // quarters
        int quarters = amount/25;
        amount = amount%25;
        //dimes
        int dimes = amount/10;
        amount = amount%10;

        //nickels
        int nickels = amount/5;
        amount %=5;

        //pennies
        int pennies = amount;

        //Display Results

        System.out.println("$"+givenAmount+" is consist of :\n");
        System.out.println(one$s+" dollars\n"+quarters+" quarters\n"+dimes+" dimes\n"+nickels+
                " nickels\n"+pennies+" pennies");

    }
}
