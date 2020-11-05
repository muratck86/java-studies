package CSE101;

import java.util.Scanner;

public class AngleCompute {
    public static void main(String[] args) {
        /**
         * A program that prompts the user to enter the x and y coordinates
         * of the three corner points in a triangle than displays the
         * triangle's angles.
         * A = acos((a*a-b*b-c*c)/(-2*b*c))
         * B = acos((b*b-a*a-c*c)/(-2*a*c))
         * C = acos((c*c-a*a-b*b)/(-2*a*b))
         * d = square root of ((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1))
         */
        Scanner input = new Scanner(System.in);

        //Obtain x and y coordinates of A, B and C corners...
        System.out.println("xA :");
        int xA = input.nextInt();

        System.out.println("yA :");
        int yA = input.nextInt();

        System.out.println("xB :");
        int xB = input.nextInt();

        System.out.println("yB :");
        int yB = input.nextInt();

        System.out.println("xC :");
        int xC = input.nextInt();

        System.out.println("yC :");
        int yC = input.nextInt();

        // define and calculate a, b, c lengths...
        double a = Math.sqrt((Math.pow(yC-yB,2)+Math.pow(xC-xB,2)));
        double b = Math.sqrt((Math.pow(yC-yA,2)+Math.pow(xC-xA,2)));
        double c = Math.sqrt((Math.pow(yA-yB,2)+Math.pow(xA-xB,2)));
        System.out.println(a+"\n"+b+"\n"+c);

        //define and calculate A, B, C corner angles, remember these are radian units

        double angleA = Math.acos((Math.pow(a,2)-Math.pow(b,2)-Math.pow(c,2))/(-2*b*c));
        double angleB = Math.acos((Math.pow(b,2)-Math.pow(a,2)-Math.pow(c,2))/(-2*a*c));
        double angleC = Math.acos((Math.pow(c,2)-Math.pow(b,2)-Math.pow(a,2))/(-2*b*a));

        // Display Results in degrees...
        System.out.println("Angle of A = "+Math.toDegrees(angleA)+" degrees.");
        System.out.println("Angle of B = "+Math.toDegrees(angleB)+" degrees.");
        System.out.println("Angle of C = "+Math.toDegrees(angleC)+" degrees.");





    }
}
