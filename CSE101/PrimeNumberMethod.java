package CSE101;

import java.util.Scanner;

public class PrimeNumberMethod {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many prime numbers :");
        printPrimeNums(input.nextInt());
    }
    // A method which prints a given (num1 below) number of prime numbers starts from 2 and num2 numbers in each line
    public static void printPrimeNums(int num1){
        boolean result;
        int i = 0;
        int count =1;
        while (i < num1){
            count++;
            result = isPrime(count);
            if (result){
                System.out.printf("%-6d",count);
                i++;
            }
            if (i%10==0 && result)
                System.out.println();
        }
    }
    // A method which returns true if given argument is a prime number...
    public static boolean isPrime(int num){
        boolean result = true;
        if (num<2)
            result = false;
        else if (num ==2)
            return true;
        else {
            for (int i=2;i<=num/2;i++){
                if (num%2 == 0)
                    return false;
                else if(num%i == 0){
                    result = false;
                }
            }
        }
        return result;
    }
}
