package CSE101;

import java.util.Scanner;

public class ComputeTax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Income :");
        double income = input.nextDouble();
        System.out.println("________________________________________________\nEnter number of status :\n");
        System.out.println("0-Single\n1-Married file jointly or qualifying widow(er)\n" +
                "2-Married file separated\n3-head of household");
        System.out.println("________________________________________________\nChoice :");
        int status = input.nextInt();
        double tax = 0;
        if (status == 0) {
            if (income >= 372951)
                tax = income*0.35;
            else if (income >= 171551)
                tax = income*0.33;
            else if (income >= 82251)
                tax = income*0.28;
            else if (income >= 33951)
                tax = income*0.25;
            else if (income >= 8351)
                tax = income*0.15;
            else if (income > 0)
                tax = income*0.10;
        }
        else if (status == 1) {
            if (income >= 372951)
                tax = income*0.35;
            else if (income >= 208851)
                tax = income*0.33;
            else if (income >= 137051)
                tax = income*0.28;
            else if (income >= 67901)
                tax = income*0.25;
            else if (income >= 16701)
                tax = income*0.15;
            else if (income > 0)
                tax = income*0.10;
        }
        else if (status == 2) {
            if (income >= 186476)
                tax = income*0.35;
            else if (income >= 104426)
                tax = income*0.33;
            else if (income >= 68526)
                tax = income*0.28;
            else if (income >= 33951)
                tax = income*0.25;
            else if (income >= 8351)
                tax = income*0.15;
            else if (income > 0)
                tax = income*0.10;
        }
        else if (status == 3) {
            if (income >= 372951)
                tax = income*0.35;
            else if (income >= 190201)
                tax = income*0.33;
            else if (income >= 117451)
                tax = income*0.28;
            else if (income >= 45501)
                tax = income*0.25;
            else if (income >= 11951)
                tax = income*0.15;
            else if (income > 0)
                tax = income*0.10;
        }
        else{
            System.out.println("ERROR: Invalid status choice");
            System.exit(1);
        }
        System.out.println("Your tax is $"+tax);




    }
}
