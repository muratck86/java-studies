package CSE101;

import java.util.Scanner;

public class Lecture04 {
    public static void main(String[] args) {
        //MATH CLASS CONSTANTS AND METHODS
        /**Constants
         * PI
         * E
         *
         * Methods
         */
        //Trigonometric Methods (uses radians)
        Math.sin(30);
        Math.cos(30);
        Math.tan(30);
        Math.acos(30);
        Math.atan(30);
        Math.sin(Math.PI/6);
        double degree = Math.toDegrees(Math.PI);
        double radyan = Math.toRadians(90);
        System.out.println("Degree of PI is :"+degree);
        System.out.println("Radian of 90 degree is :"+radyan);
        //Exponent Methods
        double ePow = Math.exp(3); //third power of E
        System.out.println("E³ = "+ePow);

        double eLog = Math.log(50); //Log (base E)((50)
        System.out.println(eLog);



        Math.log10(12.52); //log (base 10) (12.52)
        Math.pow(5,3);
        Math.sqrt(25); // square root
        Math.abs(-5); //absolute value
        Math.ceil(75.12); // round up result = 76
        Math.floor(79.98); // round down reault = 79
        Math.rint(75.5); // round to nearest integer, if equally close to two integers, then round to even one.
        Math.round(27.5); // returns 27
        Math.max(15,20);
        Math.min(15,20);
        Math.random(); // generates a random value between 0 and 1
        // 15 + Math.random() * 20; // is a random number between a and a+b excluding a+b


        //CHARACTER DATA TYPE
        /**
         *
         * char harf = 'A' //ASCII note that there is no double quote usage, instead we use '
         * char harfno = '4' //ASCII
         * char harfno = '\u0054' //unicode, must be \\uxxxx (4 digit)
         */

        char harf ='\u0054';
        System.out.println(harf++ +"\n" + harf); // this is OK, can use increment or decrement operators..


        //UNICODE FORMAT..


        //CHARACTER CLASS METHODS
        /**
         * char ch='h' //example
         * isDigit(ch)
         * isLetter(ch)
         * isLetterOrDigit(ch)
         * isLowerCase(ch)
         * isUpperCase(ch)
         * toLowerCase(ch) //returns the lowercase of ch
         * toUpperCase(ch) //returns the uppercase of ch
         */


        //THE STRING TYPE
        //These methods are instance methods (because any string is an instance of a String class)
        //A non-instance method is called static method. A static method can be invoked without using an Object
        //All the methods defined in the Math class are static methods.
        // The syntax to invoke an instance method is:

        // variableName.methodName(argument);

        //For example:
        String hello = "Welcome to Java";
        hello = hello.toUpperCase();
        System.out.println(hello);
        System.out.println("Hello World".toUpperCase());

        /**
         * String hello = "Welcome to Java";
         * length()
         * charAt(index) //Returns the char at the specified index from this string
         * concat(string1) //Returns a new string that concatenates this string with string1
         * toUpperCase()
         * toLowerCase()
         * trim() //Returns a new string with whitespaces trimmed on both sides
         *
         */
        String exampleText = "I know Kung Fu! -Show me!";
        System.out.println("Length of this example string is :"+exampleText.length());
        System.out.println("The 5th character in this string is :"+exampleText.charAt(4));

        exampleText = "I know Kung Fu!";
        String exampleText2 = exampleText.concat("--Show me!");
        System.out.println(exampleText2);

        String exampleText3 = exampleText + " Let's Fight...";
        System.out.println(exampleText3);

        String s = "Lecture "+ 4;
        System.out.println(s);

        //READING A STRING FROM CONSOLE
        Scanner input = new Scanner(System.in); //create a Scanner object named input by instantiation of Scanner Class
        System.out.println("Enter three words separated by spaces :");
        String word1 = input.next();
        String word2 = input.next();
        String word3 = input.next();

        System.out.println(word1+"\n"+word2+"\n"+word3);


        /**
         * equals(string1) //returns boolean if this string is equals to string1 case sensitive
         * equalsIgnoreCase(string1) // not case sensitive of equals() method
         * compareTo(s1) //returns an integer value greater than 0, equals to 0 or less than 1 to indicate whether
         * this string is greater than, equals to or less than s1
         * compareToIgnoreCase(s1) //case insensitive version
         * startsWith(prefix) // returns boolean value of if this string starts with specified prefix
         * endsWith(suffix)
         * substring(beginIndex)
         * substring(beginIndex,Endindex) //endIndex is not included
         * indexOf(ch)
         * indexOf(ch, fromIndex)
         * indexOF(string1) //returns the index of first occurrence of first char of string1
         * indexOf(string1, fromIndex)
         * lastIndexOf(ch, fromIndex)
         * lastIndexOf(string1, fromIndex)
         *
         *
         * if no match, than returns -1
         */
        //example
        String fullName = "Murat Can Kurt";
        String name = fullName.substring(0,9);
        String lastName = fullName.substring(fullName.lastIndexOf(' ')+1);

        System.out.println("Name is :"+name);
        System.out.println("Last Name is :"+lastName);



        //CONVERSION BETWEEN STRINGS AND NUMBERS
        /**
         * int intValue = Integer.parseInt(intString);
         * double doubleValue = Double.parseDouble(doubleString);
         * String s = number +"";
         */

        //PRINTF FORMATTING OUTPUT
        /**
         * System.out.printf(format,item1,item2...);
         * %b  boolean
         * %c char
         * %d decimal integer
         * %f floating point number
         * %e scientific display of number
         * %s string
         */
        //example
        int count = 12;
        String unit = "meter";
        System.out.printf("Count is %d and the measuring unit is %s",count,unit);






    }
}
