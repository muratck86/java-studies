package CSE101;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Enter a non negative whole number: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(n+"th fibonacci series is "+fibonacci(n));
    }
    public static int fibonacci(int n){
        if (n == 0) //Base Case
            return 0;
        else if (n == 1) //Base Case
            return 1;
        else return fibonacci(n-1)+fibonacci(n-2);
    }
}
//0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987
//1 2 3 4 5 6 7 8  9  10 11 12 13  14  15  16  17