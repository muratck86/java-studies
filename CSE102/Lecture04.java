package CSE102;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Lecture04 {
    public static void main(String[] args) throws Exception {
        //EXCEPTIONS & TEXT I/O

        //CHECKED and UNCHECKED EXCEPTIONS
        /**
         * RuntimeException and Errors (and their subclasses) are unchecked exceptions. All other exceptions are
         * checked exceptions, which means that the compiler forces the programmer to check and deal with the
         * exceptions.
         *Object<--Throwable--<Exception|Error
         *              |ClassNotFoundException
         * Exception -- |IOException
         *              |RunTimeException (ArithmeticException, NullPointerException, IndexOutOfBoundsException, IllegalArgumentException,...)
         *              |other Exceptions...
         *
         *              |LinkageError
         * Error  --    |VirtualMachineError
         *              |other Errors...
         *
         */
        //DECLARING, THROWING and CATCHING EXCEPTIONS
        /**Every method must state the types of checked exceptions it might throw. This is known as declaring.
         * myMethod1() throws Exception { //Declare Exception
         *    if (an error occurs) {
         *       throw new Exception(); //throw Exception
         *    }
         * }
         *
         * myMethod2() {
         * //catch Exception
         *    try {
         *      invoke myMethod1;
         *   }
         *   catch (Exception myException) {
         *      process Exception;
         *   }
         * }
         *
         * public void myMethod () throws IOException, OtherException {
         */
        //Example
        /**set a new radius*/
        //public void setRadius (double newRadius) throws IllegalArgumentException {
        //    if (newRadius >= 0)
        //        radius = newRadius;
        //    else throw new IllegalArgumentException("Radius can't be negative.");
        //}

        //CATCHING EXCEPTIONS
        /**
         * try {
         *      statements that may throw exception;
         * }
         * catch (Exception1 exName1) {
         *      handler for exception;
         * }
         * catch (Exception2 exName2) {
         *      handler for exception;
         * }
         * finally {
         *      final statements, that are executed whether there are exceptions caught or not;
         * }
         *
         */
        //CATCHING OR DECLARING CHECKED EXCEPTIONS
        /**We have to declare the exception or use a try-catch[-finally] block
         * if our method may throw checked Exception.
         */
        //RETHROWING EXCEPTIONS
        /** IF AN EXCEPTION is rethrown, program ends there so even if there is a finally block,
         * it wont execute. (Of course it is not caught again before finally block)
         * try {
         *    statements;
         * }
         * catch(TheException ex) {
         *    perform operations before exits;
         *    throw ex;
         * }
         */
        //WHEN WE SHOULD THROW EXCEPTION
        /**An exception occurs in a method, if we intend to handle that exception in another method which calls the
         * exception thrower, it is ok. But if we want to handle the exception in the same method which occur,
         * so there is no need to throw an exception.
         */
        //WHEN WE SHOULD USE TRY-CATCH
        /**It is used to deal with unexpected conditions, we don't use it with simple, expected conditions.
         * If we can, we should get it over with such as if blocks...
         */
        //Example... Instead of this usage;
        //try {
        //    System.out.println(refVar.toString());
        //}
        //catch (NullPointerException ex) {
        //    System.out.println("refVar is Null");
        //}
        //We Should use this:
        //if (refVar !=Null)
        //    System.out.println(refVar.toString());
        //else
        //    System.out.println("refVar is Null");

        //DEFINING CUSTOM EXCEPTION CLASSES
        /**Define custom exception classes by extending Exception class or one of its subclasses.
         * review the "ExampleCustomException.java" file
         */

        //ASSERTIONS
        /**
         * an assertion contains a boolean expression that should be true during program execution
         *
         * declaration:
         */
        //assert a==0;
         /** or
         */
         //assert a==0: detailMessage //(detailMessage is a primitive type or an Object value)

        //Executing assertions
        /**java evaluates the assertion and if it is false, an AssertionError will be thrown. The AssertionError
         * class has a no-arg constructor and 7 single arg constructors of int, long, float, double, boolean, char
         * and Object.
         * If there is no detailMessage, no-arg constructor is used, or if there is an arg, then suitable single-arg
         * constructor is used.
         * Since AssertionError is also an Error, if assertion is false, program will display a message and exits.
         */
        //review the "AssertionExample.java" file //it wont throw an error if assert is false because: read below.
        /**
         * if we want to see how assertions work we should execute assertions in terminal since assertions
         * can be disabled and they are disabled by default.
         *
         * To enable, after compiling the java file execute program in terminal as below:*/
         //>java -ea AssertionExample
        /**
         * other usages of enabling are:
         */
        //>java -enableassertions AssertionExample //long form
        //>java -ea:packageName -da:ClassName AssertionExample //enabling or disabling assertions in specific
        //classes or packages.

        //Assertions ARE NOT FOR Exception HANDLING

        //An example for usage of assertion:

        //switch (month){
        //case 1:....;break;
        //case 2:....;break;
        //...
        //case 12:...;break;
        //default: assert false: "Invalid Month" + month
        //}

//--------------------------------------------------------------------------------------

        //THE FILE CLASS
        //Important! This class cant read or write to a file....
        //File class is just a wrapper class for a file name and its directory path.
        //Scanner for reading and PrintWriter for writing is needed for i/o operations.. (They are below)
        /**File operations can be done by creating a File object.
         * Than there are plenty of File class methods to use:
         * In this case: the specified file name "murat.txt" is in this
         * project directory (if exists) (default relative path)
         * if any directory is not passed as argument
         * To create an  object, Specified path or file name doesn't require to be exists
         */
        //declaration
        File myFile1;
        //assignment
        //File(path: String)
        myFile1 = new File("murat.jpg");

        //declaration and assignment
        File myFile = new File("File.txt"); //can be just a file name
        File myDir = new File("myFilesDir"); //can be just a directory name
        File myChildDir = new File(myDir, "mySubDir"); //can be a directory path and file name
        File myNoDir = new File("NoDir");
        File muratTxt = new File("murat.txt");
        File myTxtFile = new File("courses.txt");



        // some of the methods...
        /**
         * .exists(): boolean
         * .canRead(): boolean
         * .canWrite(): boolean
         * .isDirectory(): boolean
         * .isFile(): boolean
         * .isAbsolute(): boolean
         * .isHidden(): boolean
         *
         * .getAbsolutePath(): String
         * .getCanonicalPath(): String
         */

        //examples and how to use
        System.out.println("Length of  file "+myFile.length()+" bytes");
        System.out.println("Length of directory "+myDir.length()+" bytes");
        System.out.println("Absolute Path of "+myChildDir.toString()+":\n"+ myChildDir.getAbsolutePath());
        System.out.println("Path of "+myChildDir.toString()+":\n"+ myChildDir.getPath());
        System.out.println("Absolute Path of "+muratTxt.toString()+":\n"+ muratTxt.getAbsolutePath());
        System.out.println("Path of "+muratTxt.toString()+":\n"+ muratTxt.getPath());
        //System.out.println("Canonical Path of "+myChildDir.toString()+":\n"+ myChildDir.getCanonicalPath());
        System.out.println();

        System.out.println("Does "+myChildDir+" exists? -"+myChildDir.exists());
        System.out.println("Does "+myTxtFile+" exists? -"+myTxtFile.exists());
        System.out.println("Does "+myFile+" exists? -"+myFile.exists());
        System.out.println("Does "+muratTxt+" exists? -"+muratTxt.exists());
        System.out.println();

        System.out.println("Can "+muratTxt+" read? -"+muratTxt.canRead());
        System.out.println("Can "+myDir+" read? -"+myDir.canRead());
        System.out.println("Can "+myNoDir+" read? -"+myNoDir.canRead());
        System.out.println("Can "+myFile+" read? -"+myFile.canRead());
        System.out.println();

        System.out.println("Can "+muratTxt+" be written? -"+muratTxt.canWrite());
        System.out.println("Can "+myDir+" be written? -"+myDir.canWrite());
        System.out.println("Can "+myFile+" be written? -"+myFile.canWrite());
        System.out.println("Can "+myNoDir+" be written? -"+myNoDir.canWrite());
        System.out.println();
        System.out.println("Is "+muratTxt+" directory? -"+muratTxt.isDirectory());
        System.out.println("Is "+myDir+" file? -"+myDir.isFile());
        System.out.println();

        System.out.println("Is "+myDir+" created using an absolute path? -"+myDir.isAbsolute());
        System.out.println("Is "+myTxtFile+" a hidden file? -"+myTxtFile.isHidden());

        //some of other methods..
        /**
         * myFileObject.getName() //returns a String, that is the last element of the path of the object (file or dir)
         * myFileObject.getParent() //returns a String, that is the given parent of the object when creation.
         * myFileObject.LastModified() //returns long
         * myFileObject.length() //returns size of the file or 0 if doesn't exists or is a directory
         * myFileObject.listFile() // returns File[], that is an array of files in the object if its a directory
         *             .delete() //boolean returns true if deletion is success, deletes the file or dir
         *             .renameTo(dest: File) //boolean returns true if name change is successful
         *             .mkdir() // boolean creates the dir(s) of the object and returns true if successful
         *             .mkdirs() // boolean same as mkdir but creates parents along too, if not exist
         */

        //myTxtFile.createNewFile(); //creates the file represented in myTxtFile File


        //TEXT I/O

        //WRITING DATA USING PRINTWRITER (must import java.io.PrintWriter)
        //main method must have throws java.io.IOException

        //declaration and assignment
        //Create an object and the given file, if already exists, then bye to the old one, hello to new empty one..
        PrintWriter fileTxt = new PrintWriter("file.txt");

        //Some Methods
        /**
         * fileTxt.print(String) //void, prints String to file
         *        .print(char)
         *        .print(cArray[]) // print array of chars
         *        .print(int)
         *              (float)
         *              (double)
         *              (long)
         *              (boolean)
         *        .println(...)
         *        .printf(...)
         */
        //example continuing previously created fileTxt object...
        File file = new File("NameList.txt");
        if (file.exists()){
            System.out.println(file.getName()+ " is already exists...\nWon't execute java.io.PrintWriter");
        }else
            try(PrintWriter nameList = new PrintWriter("NameList.txt");
            ){
            nameList.print("Murat Can Kurt ");
            nameList.println(86);
            nameList.print("Şafak Can Kurt ");
            nameList.println(88);
            }

        //can pass File object as file name
        PrintWriter toNamesFile = new PrintWriter(file);
        toNamesFile.println("Nikola Tesla 1000");
        //IF it is not used in try block, DON'T FORGET TO CLOSE
        toNamesFile.close();





        //READING DATA USING SCANNER

        //Create file instance
        File myDocFile = new File("scores.txt");

        //Create a Scanner for the file
        Scanner input = new Scanner(myDocFile);
        //alternative
        // Scanner input = new Scanner("scores.txt");

        //Read the data from file
        while (input.hasNext()){
            String firstName = input.next();
            String midName = input.next();
            String lastName = input.next();
            int score = input.nextInt();
            System.out.println(firstName+" "+midName+" "+lastName+":  "+score);
        }
        //Close the file.. DON'T FORGET
        input.close();

        /**
         * Scanner Methods..
         * hasNext(): boolean is there another token in input?
         * close(): close this scanner
         * next(): String return next token as String
         * nextByte():byte return next token as byte
         * nextShort():
         * nextInt():
         * nextLong():
         * nextFloat():
         * nextDouble():
         * useDelimiter(pattern:String): Set this scanners delimiting pattern
         */




        /**Just to pause java before reaching internet every time I run this
         * file to have a change to cancel continuing*/
        Scanner tempinput = new Scanner(System.in);
        System.out.println("\nReading data from URL Subject Starts from here, enter a key to continue...\n");
        tempinput.next();
        tempinput.close();
        /***/

        //READING DATA FROM THE WEB
        //must import java.net.URL

        /** Create an URL object*/
        URL url = new URL("https://www.imdb.com/chart/top");

        /**Use openStream() method of the URL class to open an input stream and
         * use this stream to create a Scanner*/
        try(Scanner inputUrl = new Scanner(url.openStream());
        ){
            String code ="";
            while (inputUrl.hasNext()){
                code +="\n"+ inputUrl.nextLine();
            }
            System.out.println(code); // all html codes of url printed
        }
        catch (MalformedURLException mex){
            System.out.println("Invalid url");
        }
        catch (IOException mex ){
            System.out.println("I/O Error");
        }
        /**review the example file "ExampleWebCrawler.java"*/
    }
}
