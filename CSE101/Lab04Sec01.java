/**
 * @author Murat Can Kurt
 * @since 24.02.2020
 */

package CSE101;


import java.util.Scanner;

public class Lab04Sec01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number :");
        int number = input.nextInt();

        if (number < 0){
            number *= -1;
        }

        for (int i=0;i <= number;i++){
            int temp = i;
            int sum = 0;
            while (temp > 0){
                sum += ((temp % 10));
                temp = temp/10;
            }
            System.out.println(i + " Total :" + sum);
        }
    }
}
