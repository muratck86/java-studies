package CSE101;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.net.URL;
public class Lecture09 {
    public static void main(String[] args) throws IOException {

        //CATCHING EXCEPTIONS

        /**try {
         * some statements that may throw exceptions;
         * }
         * catch (Exception1 exVar1){
         * handler for Exception1;
         * }
         * catch (Exception2 exVar2){
         * handler for Exception2;
         * }
         * ...
         * catch (ExceptionN exVarN){
         * handler for ExceptionN;
         * }
         * finally { //optional
         * do something;
         * }
         */



        //THE FILE CLASS
        //Important! This class cant read or write to a file....
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
        myFile1 = new File("murat.jpg");

        //declaration and assignment
        File myFile = new File("File.txt");
        File myDir = new File("myFilesDir");
        File myNoDir = new File("NoDir");
        File myChildDir = new File(myDir, "mySubDir");
        File myTxtFile = new File("C:/","murat.txt");
        File muratTxt = new File("murat.txt");



        // some of the methods...
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
         *             .renameTo(newName) //boolean returns true if name change is successful
         *             .mkdir() // boolean creates the dir(s) of the object and returns true if successful
         *             .mkdirs() // boolean same as mkdir but creates parents along too, if not exist
         */

        //myTxtFile.createNewFile();

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
        File file = new File("namesfile.txt");
        if (file.exists()){
            System.out.println(file.getName()+ " is already exists...\nWon't execute java.io.PrintWriter");
        }//else
        //    try(PrintWriter namesFile = new PrintWriter("namesFile.txt");
        //    ){
        //    namesFile.print("Murat Can Kurt ");
        //    namesFile.println(86);
        //    namesFile.print("Şafak Can Kurt ");
        //    namesFile.println(88);
        //    }

        //can pass File object as file name
        PrintWriter toNamesFile = new PrintWriter(file);
        toNamesFile.println("Nikola Tesla 1000");
        toNamesFile.close();


        //READING DATA USING SCANNER

        //Create file instance
        File myDocFile = new File("scores.txt");

        //Create a Scanner for the file
        Scanner input = new Scanner(myDocFile);

        //Read the data from file
        while (input.hasNext()){
            String firstName = input.next();
            String midName = input.next();
            String lastName = input.next();
            int score = input.nextInt();
            System.out.println(firstName+" "+midName+" "+lastName+":  "+score);
        }
        //Close the file..
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


        //READING DATA FROM THE WEB
        //must import java.net.URL

        URL url = new URL("https://www.imdb.com/chart/top");
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
    }
}
