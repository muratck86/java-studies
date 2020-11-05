package CSE101;

import java.util.Scanner;

public class Calculator {
    private String private1 = "Bu bir private denemedir.";
    public String private2 = "Bu bir public modifierli denemedir.";
    String private3 = "Bu bir default modifierlidir...";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter statement :");
        String a = input.next();
        String op = input.next();
        String b = input.next();
        String[] list = {a,op,b};
        calculator(new String[]{a,op,b});

    }

    /**Define a calculator method that takes three String args, and evaluates as binary math operations.
     */
    public static void calculator(String[] args){
        double result = 0;
        if (args.length != 3)
            System.out.print("ERROR: Enter Operand1 Operator Operand2");
        double op1 = Double.parseDouble(args[0]);
        double op2 = Double.parseDouble(args[2]);
        switch (args[1]){
            case "+": result = op1 + op2; break;
            case "-": result = op1 - op2; break;
        }
        System.out.println(result);

    }
}
