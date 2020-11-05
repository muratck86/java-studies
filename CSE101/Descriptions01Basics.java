package CSE101;

import java.util.Scanner;

// Every java program must have at least one class.. our class is Descriptions01Basics, seen as below
// Class name have to be same with the file name.
public class Descriptions01Basics {
    //Second line defines the main method as seen below...
    //In order to run a class, the class must contain a method named main.
    // The program is executed from the main method.
    public static void main(String[] args) {
        // and after that come statements, every statement must end with semicolon ; called state terminator
        System.out.println("Welcome to Java!");
        //A block is formed between a pair of braces {}...


        //READING INPUT FROM THE CONSOLE
        //to call Scanner() java.util.Scanner must be imported
        //import java.util.Scanner;

        System.out.println("Enter a value :");//print a message to enter a value
        Scanner read = new Scanner(System.in); //create Scanner object named read
        double d= read.nextDouble();


        //DEFINING VARIABLES

        int a; //integer a
        double b; //double b
        char z='j'; // character 'j' assigned to z (one character)
        String c = "Any Text"; //String
        final double PI = 3.14159; //define a named constant PI and assign 3.14159 value to
        //named constants conventionally written in uppercase and used underscore letters
        //between words
        long number; //long integer...

        //READING NUMBERS FROM KEYBOARD

        /**
         * nextByte() integer of byte type
         * nextDouble()
         * nextShort() integer of the short type
         * nextInt() integer of int type
         * nextFloat() float number of float type
         *
         */


         // EXPONENT OPERATIONS
        System.out.println(Math.pow(2,3)); // returns 8
        System.out.println(Math.pow(25,0.5)); //5


        //DOUBLE VS FLOAT AND BYTE VS INT

        //byte is just one byte long, so it is between -256 and +255
        //float and double is used as:
        //52.2f or 15.3F
        //22.9D
        // double is more accurate then float
        // int/int returns int
        System.out.println("float :"+1.0f/3.0f); //Prints 7 digits after dot
        System.out.println("double :"+1.0d/3.0d); // prints 16 digits after dot

        //GETTING CURRENT TIME
        System.currentTimeMillis(); //returns the epoch time in milliseconds count



        //INCREMENT AND DECREMEN OPERATIONS

        int x = 0;
        ++x; //preincrement increase a by 1 BEFORE use in the statement
        x++; //postincrement use a in the statement THAN increase by 1
        --x;
        x--;


        //NUMERIC TYPE CONVERSION
        byte i = 100;
        long k = i*3+4;
        double m = i*3.1+k/2;


        // if one of the vars is double, then the others converted to double
        // otherwise if there is float then converts the others to float
        // otherwise long
        // otherwise int
        // byte < short < int < long < float < double

        int p = (int)(3.5);
        System.out.println(p);

        //SLIDE 44









    }
}
