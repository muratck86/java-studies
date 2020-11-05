package CSE101;

import java.util.Scanner;

public class Assignment102 {
    public static void main(String[] args) {
        int beersInStock = 0;
        double price = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to SUPER-DUPER MARKET");
        System.out.println("\n-----Store Iventory Entry-----\n");
        System.out.println("Enter the number of beers we have :");
        int checkNum =input.nextInt();
        if (checkNum<0) {
            System.out.println("Can't be negative, converting to positive...");
            beersInStock += -checkNum;
        }
        else
            beersInStock +=  checkNum;
        System.out.println("Enter the price of one bottle of beer: ");
        double checkPrice = input.nextDouble();
        if (checkPrice < 0){
            System.out.println("Can't be negative, converting to positive...");
            price += -checkPrice;
        }
        else
            price += checkPrice;
        System.out.println("\n--------Customer Entry--------\n");
        System.out.println("We have "+beersInStock+" bottles of beer.\nHow many would you like?");
        checkNum = input.nextInt();
        if (checkNum < 0){
            System.out.println("ERROR: must be positive");
        }
        else if (checkNum > beersInStock){
            System.out.println("ERROR: not enough beers in inventory");
        }
        else{
            beersInStock -= checkNum;
            System.out.println("Shopping Cost is :₺"+price*checkNum);
            System.out.println("Thank you for preferring SUPER-DUPER\nWe have left "+beersInStock+" in inventory.");
        }
    }
}
