package CSE101;

import java.util.Scanner;

public class GreatestCommonDiv {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Two numbers :");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        System.out.println("Number 1 is :"+num1+"\nNumber 2 is :"+num2);
        int count = 1;
        int gcd = 1;
        while (count <=Math.min(num1,num2)){
            if (num1%count==0 && num2%count==0){
                gcd=count;
            }
            count++;
        }
        System.out.println("The GCD("+num1+","+num2+") = "+gcd);
    }
}
