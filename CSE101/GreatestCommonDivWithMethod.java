package CSE101;

import java.util.Scanner;

public class GreatestCommonDivWithMethod {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two integer numbers :");
        int num1 = input.nextInt();
        int num2 = input.nextInt();

        System.out.print("\n The GCD("+num1+","+num2+") is "+gcd(num1,num2));
    }
    public static int gcd(int n1, int n2){
        int gcd = 0;
        int i = Math.min(n1,n2);
        while (i>=1){
            if (n1%i ==0 && n2%i == 0){
                gcd =i;
                break;
            }
            i--;
        }
        return gcd;
    }
}
