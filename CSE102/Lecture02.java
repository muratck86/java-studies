package CSE102;

import java.math.*;
import java.util.Arrays;

public class Lecture02 {
    public static void main(String[] args) {
        //AGGREGATION AND COMPOSITION
        /**
         * Aggregating class the collector class..
         * Aggregated class the class which has objects in aggregating class
         *
         * public class Student{ //Student class is aggregating class
         * private Name n1;      //Name class and Address class are aggregated classes
         * private Address a1;
         * ...
         * }
         */
        //Aggregation can also be between same class
        /**
         * public class Staff{
         * private Staff supervisor; //The type for the data is the class itself
         * }
         */
        //WRAPPER CLASSES
        /**
         * The wrapper classes do not have no-arg constructors
         * The objects of wrapper classes are immutable.
         * Examples:
         * java.lang.Integer
         * java.lang.Double
         */
        //Conversion Methods
        /**
         * Each numeric wrapper class implements the abstract methods
         * doubleValue,
         * floatValue,
         * intValue,
         * longValue and
         * shortValue,
         * which are defined in the 'Number' class. These methods 'convert' objects into primitive
         * type values.
         */
        //The static valueOf method
        /**
         * valueOf(String value);
         * method creates a new object initialized to the value represented by the specified string.
         */
        Double doubleObject = Double.valueOf("15.75");
        Integer integerObject = Integer.valueOf("81");
        System.out.println(doubleObject);
        int number = Integer.parseInt("122");

        //AUTOMATIC CONVERSION BETWEEN PRIMITIVE TYPES AND WRAPPER CLASS TYPES
        /**
         * Integer[] intArray = {new Integer(2), new Integer(4), new Integer(7)}; Equivalent: Integer[] intArray = {2,4,7};
         */

        Integer[] intArray = {2,4,7};
        System.out.println(intArray[0]); //Unboxing

        //BIGINTEGER and BIGDECIMAL
        BigInteger a = new BigInteger("9863221658665265216");
        BigInteger b = new BigInteger("2");
        BigInteger c = a.multiply(b);
        System.out.println(c);

        BigDecimal k = new BigDecimal(1.0);
        BigDecimal l = new BigDecimal(3);
        BigDecimal m = k.divide(l,20,BigDecimal.ROUND_UP);
        System.out.println(m);



        //THE STRING CLASS
        //Internet strings
        String s1 = "Welcome to Java";
        String s2 = "Welcome to Java"; //s1 == s2 is true, both of them are same object.

        //if new operator is used...
        String s3 = new String("Welcome to Java"); //new string object s3 == s1 or s2 is false, not the same object.
        /**
         * .replace(oldChar,newChar) //replaces all matching chars
         * .replaceFirst(oldString, newString) //replaces first matching substring
         * .replaceAll(oldString, newString)
         * .split(delimiter: String): String[] //removes delimiter while splitting
         */
        System.out.println("welcome".replaceAll("el","on")); //prints woncome
        System.out.println("mama miaa".replace("m","M")); //prints MaMa Miaa
        String[] ex = "mamama miaa".split("m");
        for (String s:ex)
            System.out.println(s);

        //Regular expressions
        //Matching, splitting and replacing by patterns
        /**
         * "Java".matches("Java");
         * "Java".equals("Java");
         * "Java is fun".matches("Java.*");
         * "Java is cool".matches("Java.*");
         */
        String s = "a+b$#c".replaceAll("[$+#]", "NNN"); //searches and replaces all chars in [] separately by NNN
        System.out.println(s);


        String[] tokens = "Java,C?C#,C++:Python.Fortran".split("[.,:;?]");
        for (int i = 0; i < tokens.length; i++)
            System.out.println(tokens[i]);

        //static valueOf method...
        /**
         * String.valueOf method converts various types into Strings...
         */
        String text = String.valueOf(513354);
        for (int i = 0; i < text.length(); i++)
            System.out.print(text.charAt(i)+"\t");

        //STRING BUILDER AND STRING BUFFER
        //Alternative to the String class, can be used everywhere we use Strings, and is mutable...
        /**java.lang.StringBuilder
         * StringBuilder() constructs an empty string builder with capacity 16
         * StringBuilder(capacity:int)
         * StringBuilder(text:String)
         * .append
         * .delete
         * .insert
         * .replace
         * .reverse()
         * .setCharAt
         */
        //Examples of string Regular Expressions (=regex)
        //additional operators table in 53rd slide in lecture02
        System.out.println();
        String deneme = "Java Java Java".replaceAll("v\\w", "wi") ;
        System.out.println(deneme);
        deneme = "Java Java Java".replaceFirst("v\\w", "wi") ;
        System.out.println(deneme);
        String[] stringArray = "Java1HTML2Perl".split("\\d");
        System.out.println(Arrays.toString(stringArray));

    }
}
