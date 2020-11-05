package CSE101;

//AN EXAMPLE TO SHOW HOW TO GAIN TWO DIGIT NUMBER AFTER DECIMAL POINT.


import java.util.Scanner;

public class Tax_calc {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter  Price : ");
    double price = input.nextDouble();
    double tax = price * 0.18;
    System.out.println("Sales tax is : "+(int)(tax*100)/100.0); //multiply by 100 and convert to int, than divide
        // by two digit (100.0) to re-convert to double while gaining two digits after decimal point.
    }
}
