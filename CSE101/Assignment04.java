/**
 * @author Murat Can Kurt 20195156018
 * @since 08.03.2020
 */

import javax.swing.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;


public class Assignment04 {
    public static void main(String[] args) throws Exception {
        String baseFilename = "Assignment04";
        String errors ="";
        int count = countInventory(baseFilename+"_Inventory.txt");
        if (count ==-2 || count == 0){
            errors += "ERROR: "+baseFilename+"_Inventory.txt contains no data.\n";
            writeLog(errors);
        }
        if (count ==-1){
            errors += "ERROR: "+baseFilename+"_Inventory.txt file not found.\n";
            writeLog(errors);
        }
        String[] items = new String[count];
        int[] quantity = new int[count];
        double[] price = new double[count];
        getInventory(items,quantity,price,baseFilename);
        File customerFile = new File(baseFilename+"_Customer.txt");
        if (!customerFile.exists()){
            errors += "ERROR: "+baseFilename+"_Customer.txt file not found.\n";
        }
        Scanner customerInput = new Scanner(customerFile);
        int customerCount = countInventory(baseFilename+"_Customer.txt");
        int [] cart = new int[count];
        int temp = 0;
        String item = "";
        for (int i = 0; i < customerCount; i++){
            item = customerInput.next();
            System.out.println(item);
            for (int j = 0; j < count; j++){
                if (item.equalsIgnoreCase(items[j])){
                    temp = customerInput.nextInt();
                    System.out.println(temp);
                    if (temp > quantity[j]){
                        errors +=j+"ERROR: "+items[j]+" - "+temp+" requested, only "+quantity[j]+" availible.\n";
                    } else if (temp < 0){
                        errors +=j+ "ERROR: Invalid request ("+temp+")\n";
                    }else{
                        cart[j] = temp;
                        quantity[j] -= cart[j];
                    }
                } else {
                    errors +="ERROR: Item "+item+" not found.\n";
                }
            }
        }
        customerInput.close();
        writeInventory(items,quantity,price,baseFilename);
        System.out.println(errors);
    }



        /**
         * Error codes:
         * -1 File not found
         * -2 File is empty
         *
         */
        //takes only base file name as argument
        //Read the inventory from {basefile}_Inventory.txt
        //read customer requests from file {basefile}_Customer.txt
        //Write the customer receipt to a file {basefile}_Receipt.txt
        //Write any errors to a file {basefile}_Log.txt
        //Write Resulting inventory to {basefile}_Remaining.txt
    public static int countInventory(String filename) throws Exception{
        //read file count the lines in the file
        File invFile = new File(filename);
        if (!invFile.exists())
            return -1;
        else if (invFile.length() == 0)
            return -2;
        Scanner input = new Scanner(invFile);
        int count = 0;
        while (input.hasNextLine()){
            input.nextLine();
            count +=1;
        }
        input.close();
        return count;
    }
    public static void getInventory(String[] item, int[] quantity, double[] price, String filename) throws Exception{
        //fill the arrays with the inventory information
        File inventoryFile = new File(filename+"_Inventory.txt");
        Scanner input = new Scanner(inventoryFile);
        for (int i = 0; i < item.length; i++){
            item[i] = input.next();
            quantity[i] = input.nextInt();
            price[i] = input.nextDouble();
        }
        input.close();
    }
    public static void writeInventory(String[] item, int[] quantity, double[] price, String filename) throws Exception{
        File remainingFile = new File(filename+"_Remaining.txt");
        PrintWriter output = new PrintWriter(remainingFile);
        for (int i = 0; i < item.length; i++){
            output.println(item[i] + " "+quantity[i]+" "+price[i]);
        }
        output.close();
    }
    public static void writeLog(String errorcodes){
            System.out.println(errorcodes);
        }
    //public static void writeReceipt(){

    //}
    public static boolean validRequest(int entered, int existing){
        if (entered<=existing && entered>0) return true;
        return false;
    }
}
