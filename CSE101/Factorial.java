package CSE101;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("Enter a non negative whole number: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(n+"! = "+factorial(n));
    }
    public static long factorial(int n){
        if(n == 0) //Base case
            return 1;
        else return n * factorial(n-1);
    }
}
