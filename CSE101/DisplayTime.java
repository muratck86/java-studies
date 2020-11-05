package CSE101;

import java.util.Scanner;

public class DisplayTime {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter an integer fot seconds :");
        int seconds = read.nextInt();
        int mins = seconds/60;
        int secs = seconds%60;
        System.out.println(seconds+" seconds is "+mins+" minutes and "+secs+" seconds");
    }
}
