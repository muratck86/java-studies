package CSE101;

import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your Weight (kg) :");
        double weight = input.nextDouble();
        double bmi=0;
        if (weight < 35){
            System.out.println("ERROR: Invalid value of weight...");}
        else {
            System.out.println("Enter Your Height (m) :");
            double height = input.nextDouble();
            if (height < 0.6){
                System.out.println("ERROR: Invalid value of height...");}
            else
                bmi = weight / Math.pow(height, 2);
            String result = "";
            if (bmi < 18.5) {
                result = "underweighted";}
            else if (bmi < 25.0)
                    result = "normal";
                else if (bmi < 30.)
                    result = "overweighted ";
                else
                    result = "obese";
                System.out.println("Your BMI is " + (int) (bmi * 100) / 100.0 + "\nYou are " + result);

        }







    }
}
