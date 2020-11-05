package CSE101;

import java.util.Scanner;

public class FormatExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter angle value in degrees :");
        int degrees = input.nextInt();
        double radians = Math.toRadians(degrees);
        System.out.printf("%-10s%-10s%-10s%-10s%-10s\n","Degrees","Radians","Sinus","Cosinus","Tangent");
        System.out.printf("%-10d%-10.4f%-10.2f%-10.2f%-10.2f",degrees,radians,Math.sin(radians),Math.cos(radians),Math.tan(radians));
    }
}
