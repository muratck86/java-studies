package CSE101;

import java.util.Scanner;

public class Decimal2Hexa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in   );
        System.out.println("Enter a decimal number :");
        int decimal = input.nextInt();
        String hexa = "";

        int temp = -1;
        while (decimal!=0){
            temp = decimal%16;
            decimal/=16;

            //Convert a to hexadecimal digit by ((boolean) ? (do if true ): (do if  false)) structure...
            char hexDigit =(temp<=9 && temp>=0) ? ((char)(temp+'0')):((char)(temp-10+'A'));
            hexa = hexDigit+hexa;
        }
        System.out.println(hexa);
    }
}
