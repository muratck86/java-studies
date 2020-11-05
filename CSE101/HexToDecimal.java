package CSE101;

import java.util.Scanner;

public class HexToDecimal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Hexadecimal digit :");

        String hexa = input.nextLine();

        //check if input is one digit?
        if (hexa.length()>1){
            System.out.print("Must be one digit...");
            System.exit(1);
        }
        hexa = hexa.toUpperCase();
        char ch = hexa.charAt(0);

        //check if char is greater than 'F'
        if (ch>'F'){
            System.out.print("Invalid Hexadecimal digit...");
            System.exit(1);
        }

        //check if ch is between 0-10
        else if (Character.isDigit(ch)) //Attention...
            System.out.print(ch);

        //check if ch is between A and F
        else if (ch>='A' && ch<='F'){
            int decimalValue = ch - 'A'+10;
            System.out.print(decimalValue);
        }
        else
            System.out.print("Invalid entry...");


    }
}
