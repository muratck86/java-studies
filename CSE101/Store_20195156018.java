package CSE101;

/**
 * @author Murat Can Kurt
 * @since 25.02.2020
 */

import java.util.Scanner;

public class Store_20195156018 {
    public static void main(String[] args) {
        String[] items ={"BEER","wINe","WhiSky","raki","Vodka","wateR"};
        double[] prices={11.25,88.50,165.60,111.75,108.80,1.25};
        int[] inventory={24,6,10,4,12,40};
        store(items,inventory,prices);
    }

//------------------------------------------------END OF MAIN----------------------------------------------------------



    //METHODS DEFINED HERE
// *******************************************************************************************************************

    //displayMenu Method
    //------------------------------------------------------------------------
    /**displayMenu Method takes two arrays and returns none....
     * displays a schematic view of store product and price information
      * @param items array of product names
     * @param prices array of product prices must be same length and same order with items
     */
    public static void displayMenu(String[] items, double[] prices) {
        String header = "" +
                "\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" +
                "\n|||                WELCOME TO SUPER-DUPER MARKET                     |||" +
                "\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" +
                "\n|||     Name               Price                                     |||" +
                "\n|||     -------------      --------                                  |||";
        String body = "" +
                "\n|||%2d"+" - "+"%-19s%-8.2fTL%32s|||";
        System.out.print(header);
        for (int i = 0; i < items.length; i++)
            System.out.printf(body, (i+1), items[i], prices[i],"");
        String bottom = "" +
                "\n|||%66s|||" +
                "\n||| 0 - Checkout%53s|||" +
                "\n|||Please enter the number of the product or 0 to checkout:          |||" +
                "\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n";
        System.out.printf(bottom, "", "", "");
    }

    //store Method
    //------------------------------------------------------------------------

    /**store method
     * The main menu
     * @param products is an array of product names on sale...
     * @param invAmount is amount of each product in inventory, must be in same order with products
     * @param prices is price of each product in inventory, must be in same order with products
     */

    public static void store(String[] products, int[] invAmount, double[] prices) {
        capitalize(products);
        Scanner input = new Scanner(System.in);
        int selection;
        int amount;
        double payment =0;
        int[] cart = new int[products.length];

        /** customer product selection menu
         * displays product number, and price...
         * gets selection parameter, which is a number represents product, from customer
         */

        while (true){
            displayMenu(products,prices);
            selection = input.nextInt();
            if (selection == 0) {
                break;
            }else if (validRequest(selection,products.length)){
                displayMenu(products,prices,selection);
                amount = input.nextInt();
                if (validRequest(amount,invAmount[selection-1]))
                    cart[selection-1] += amount;
                else {System.out.println("Invalid number or, not enough stock, please enter any key to try again...");
              //This scanner does nothing, just to pause program and wait for customer to read and enter a key to cont.
                input.next();
                }
            }
            else {System.out.println("Invalid Selection... Enter any key to try again...");
            input.next();}
        }
        double total =0;
        for (int i = 0; i < cart.length; i++)
            total += cart[i]*prices[i];
        double cash = 0;

        if (total == 0){
            System.out.println("Shopping cancelled, have a nice day...");
            System.exit(1);
        }

        /**Displays shopping summary, total cost, and asks for payment*/

        while (true){
            displayMenu(products,cart,prices,payment, total,"");
            cash =input.nextDouble();
            if (cash <= 0){
                System.out.println("Error invalid value...\nEnter any key to try again...");
                input.next();
                continue;
            } else
                payment +=cash;
            if (payment < total) {
                displayMenu(products, cart, prices, payment, total, "Not enough payment...");
            }else break;
        }
        displayMenu(cashReturned(payment,total));
    }


    //Capitalize methods
    /** capitalize Method take an array of strings and capitalizes every item
     * in the array...
     *
     * @param arr array of strings
     */
    //------------------------------------------------------------------------
    public static void capitalize(String[] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] =capitalize(arr[i]);
        }
    }
    /**
     * capitalize method for string capitalizes any given string
     * @param name given string
     * @return capitalized version of the given string..
     */
    public static String capitalize(String name){
        name = name.toLowerCase();
        name = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
        return name;
    }

    //validRequest Method
    //------------------------------------------------------------------------
    /**validRequest method to check if a value is between or equals to
     * another value of double
     * @param entered the value to check
     * @param existing the boundary value
     * @return boolean
     */
    public static boolean validRequest(int entered, int existing){
        if (entered<=existing && entered>0) return true;
        return false;
    }

    // cashReturned Method
    //------------------------------------------------------------------------
    /**cashReturned method gives count of bills and coins of returned money
     * @param cash paid amount of money by the customer
     * @param sum cost of the chart
     * @return String - sum (as a list of bills and coins)
     */
    public static String cashReturned(double cash, double sum){
        int bill = (int) ((cash-sum));
        int coin =(int)((cash-sum)*100)%100;
        String message =""+
                "\n||| Cash Return:%53s|||\n|||----------------------------------------%26s|||";
        if (bill/100 > 0)
            message += "\n||| "+bill/100+"  x  100TL%54s|||";
        if (bill%100/50>0)
            message += "\n||| "+bill%100/50+"  x   50TL%54s|||";
        if (bill%100%50/20>0)
            message += "\n||| "+bill%100%50/20+"  x   20TL%54s|||";
        if (bill%100%50%20/10>0)
            message += "\n||| "+bill%100%50%20/10+"  x   10TL%54s|||";
        if (bill%100%50%20%10/5>0)
            message += "\n||| "+bill%100%50%20%10/5+"  x    5TL%54s|||";
        if (bill%100%50%20%10%5>0)
            message += "\n||| "+bill%100%50%20%10%5+"  x    1TL%54s|||";
        if (coin/50>0)
            message += "\n||| "+coin/50+"  x    0.50TL%51s|||";
        if (coin%50/25>0)
            message += "\n||| "+coin%50/25+"  x    0.25TL%51s|||";
        if (coin%50%25/10>0)
            message += "\n||| "+coin%50%25/10+"  x    0.10TL%51s|||";
        if (coin%50%25%10/5>0)
            message += "\n||| "+coin%50%25%10/5+"  x    0.05TL%51s|||";
        if (coin%50%25%10%5>0)
            message += "\n||| "+coin%50%25%10%5+"  x    0.01TL%51s|||";
        message +="\n|||----------------------------------------%26s|||\n||| Total Return:"
                +(int)(cash-sum)*100/100.0+"%43s|||";
        return message;
    }
    //displayMenuMethod
    //------------------------------------------------------------------------
    /**displayMenu Method takes two arrays and one int and returns none....
     * displays a schematic view of store product and price information
     * @param items array of product names
     * @param prices array of product prices must be same length and same order with items
     * @param selected number of product in the list
     */
    public static void displayMenu(String[] items, double[] prices, int selected) {
        String header = "" +
                "\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" +
                "\n|||                WELCOME TO SUPER-DUPER MARKET                     |||" +
                "\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" +
                "\n|||     Name               Price                                     |||" +
                "\n|||     -------------      --------                                  |||";
        String body = "" +
                "\n|||%2d"+" - "+"%-19s%-8.2fTL%32s|||";
        System.out.print(header);
        for (int i = 0; i < items.length; i++)
            System.out.printf(body, (i+1), items[i], prices[i],"");
        String bottom = "" +
                "\n|||%66s|||" +
                "\n|||Please enter amount of %-7syou would like to buy:              |||" +
                "\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n";
        System.out.printf(bottom, "", items[selected-1]);
    }


    /**displayMenu method for shopping summary
     *
     * @param products array of all products on sale
     * @param cart chosen products for buying
     * @param prices array of all prices of products
     * @param paid sum of paid amount if not enough
     * @param total Total cost of the cart
     * @param note "Not enough payment" note displayed if payment is not enough
     */
    public static void displayMenu(String[] products, int[] cart, double[] prices,double paid, double total,String note){
        String header = "" +
                "\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" +
                "\n|||                WELCOME TO SUPER-DUPER MARKET                     |||" +
                "\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" +
                "\n|||     Name            Amount      Price                            |||" +
                "\n|||     -------------   ------      --------                         |||";
        String body = "" +
                "\n|||%2d"+" - "+"%-19s%-5d%-8.2fTL%27s|||";
        System.out.print(header);
        for (int i = 0; i < products.length; i++) {
            if(cart[i]>0)
            System.out.printf(body, (i + 1), products[i],cart[i], prices[i], "");
        }
        String bottom = "" +
                "\n|||              Total Cost:    %-7.2fTL                            |||" +
                "\n|||%-66s|||"+
                "\n|||Amount Paid:%-7.2fTL Please enter addition amount:               |||" +
                "\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n";
        System.out.printf(bottom, total, note, paid);
    }

    /**displayMenu method for cashReturn
     * combines a part of displayMenu method with String passed from cashReturned method
     * @param message string passed from cashReturned method
     */
    public static void displayMenu(String message){
        String header = "" +
                "\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" +
                "\n|||                WELCOME TO SUPER-DUPER MARKET                     |||" +
                "\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" +
                "\n|||%-66s|||";
        System.out.printf(header,"");
        System.out.printf(message,"","","","","","","","","","","","","","","");
        String bottom = "" +
                "\n||| Thank you for shopping with us today...                          |||"+
                "\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n";
        System.out.printf(bottom,"");
    }

}
