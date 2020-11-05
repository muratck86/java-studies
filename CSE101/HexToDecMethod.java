package CSE101;

import java.util.Scanner;

public class HexToDecMethod {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Hexadecimal number to convert into Decimal :");
        String hexanumber = input.next();
        System.out.printf("hex %s = decimal %d",hexanumber,hex2Dec(hexanumber));
    }
    public static int hex2Dec(String hexNum){
        hexNum = hexNum.toUpperCase();
        //find out the last index number hexa number from string length and assign to lastIndex var
        int lastIndex = hexNum.length()-1;
        int power = 0; //to use while calculating power of 16
        int decimal =0; //represents transformed number in decimal
        for (int i=lastIndex;i>=0;i--){ //get every hexadecimal digit from right to left
            char hexDigit = hexNum.charAt(i);
            // convert every hexa digit to decimal numbers...
            // every char have a integer value, for example as a char, 0 gets value of 48 and 1 gets 49,2 gets 50
            //and so on, Thus to obtain hexDigit's integer value, (int)hexDigit-(int)('0')
            // same logic with A to F chars... int value of A is 65, and F is 70 so, to get 15 which is F in hexa
            // we use F-A+10 means 70-65+10=15=F
            int decDigit = ((int)hexDigit-(int)('0')<=9) ? ((int)hexDigit-(int)('0')):((int) (hexDigit-'A')+ 10);
            // a hexadecimal number AF84 is = 10*16*16*16+15*16*16+8*16+4
            decimal += decDigit*Math.pow(16,power);
            power++;
        }
        return decimal;
    }
}
