package CSE101;

import java.util.Scanner;

public class ComputeLoan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Yearly interest rate
        System.out.println("Enter yearly interest rate :");
        double yearlyRate = input.nextDouble();

        //calculate monthly interes rate
        double monthlyRate = yearlyRate/1200;

        //Enter number of years
        System.out.println("Enter number of years :");
        int years = input.nextInt();

        //Enter Loan Amount

        System.out.println("Enter Loan Amount :");
        double loan = input.nextDouble();

        //Calculate annual payment
        double monthlyPayment = loan*monthlyRate/(1-1/Math.pow(1+monthlyRate,years*12));
        double totalPayment = monthlyPayment*years*12;

        //Display Results
        System.out.println("Monthly Payment is ₺"+(int)(monthlyPayment*100)/100.0);
        System.out.println("Total Payment is ₺"+(int)(totalPayment*100)/100.0);

    }
}
