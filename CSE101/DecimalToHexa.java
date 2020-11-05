package CSE101;

import java.util.Scanner;

public class DecimalToHexa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer :");
        int decimal = input.nextInt();
        int temp = -1;
        String hexchar="";
        System.out.println(decimal);
        while (decimal!=0) {
            temp = decimal%16;
            decimal /= 16;
            switch (temp){
                case 10: hexchar = 'A'+hexchar;break;
                case 11: hexchar = 'B'+hexchar;break;
                case 12: hexchar = 'C'+hexchar;break;
                case 13: hexchar = 'D'+hexchar;break;
                case 14: hexchar = 'E'+hexchar;break;
                case 15: hexchar = 'F'+hexchar;break;
                default: hexchar = temp+hexchar;
            }
        }
        System.out.println("HEXADECIMAL :"+hexchar);
    }
}
