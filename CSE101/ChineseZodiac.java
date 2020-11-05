package CSE101;

import java.util.Scanner;

public class ChineseZodiac {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year :");
        int year = input.nextInt();
        String chineseYear = "";
        switch (year % 12){
            case 0: chineseYear = "monkey";break;
            case 1: chineseYear = "rooster";break;
            case 2: chineseYear = "dog";break;
            case 3: chineseYear = "pig";break;
            case 4: chineseYear = "rat";break;
            case 5: chineseYear = "ox";break;
            case 6: chineseYear = "tiger";break;
            case 7: chineseYear = "rabbit";break;
            case 8: chineseYear = "dragon";break;
            case 9: chineseYear = "snake";break;
            case 10: chineseYear = "horse";break;
            case 11: chineseYear = "sheep";break;
            default: chineseYear ="";
        }
        if (chineseYear != "")
            System.out.println("Chinese year is "+chineseYear);
    }
}
