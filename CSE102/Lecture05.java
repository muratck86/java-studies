package CSE102;

public class Lecture05 {
    public static void main(String[] args) {

        //JUNIT BASICS
        /**JUnit is the de facto framework for testing java programs.
         * If we want to test a class name A we write a test class named ATest
         * This test class contains the methods we write for testing class A
         */
        //Obtain and run JUnit
        /**
         * http://sourceforge.net/projects/junit/files/
         * junit-4.10.jar is te file to download and put into:
         * c:\book\lib
         * add this to the environment variables as follows:
         * in the terminal enter line:
         *
         * set classpath=.;%classpath%;c;\book\lib\junit-4.10.jar
         *
         * or in the system variables window:
         *
         * name:"classpath"
         * value:".;%classpath%;c;\book\lib\junit-4.10.jar"
         *
         * to check if it is correctly added, enter the following line to the console:
         *
         * java org.junit.runner.JUnitCore
         */
        //review the "ExampleTesting.java" file

        /**To run the test from the console:
         *
         * java org.junit.runner.JUnitCore mytest.ATest //mytest is package name...
         *
         */
        //review the "ExampleArrayListTest.java" file, another example
        //review the "ExampleLoanTest.java" file another example


        //FILE I/O
        //review "ExampleAddressBook.java"
    }
}
