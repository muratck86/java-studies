package CSE101;

public class Descriptions02Conditionals {
    public static void main(String[] args) {


        //IF - ELSE/ IF - ELSE IF

        /**
         * if (condition)
         *   expression;
         *   expression;
         * else
         *   expression;
         *   expression;
         *
         *   CAN BE USED WITH OR WITHOUT BRACE
         * if (condition) {
         *   expression;
         * }
         * else{
         *   expression;
         * }
         *
         * if (condition)
         *   expression;
         * else if (condition)
         *   expression;
         * else if (condition)
         *   expression;
         * else
         *   expression;
         *
         * PAY ATTANTION, There is no semicolon at the end of if or else statement.
         * The else clause matches the most recent if clause in the
         * same block.
         */
        //for the piece of code below nothing will be printed because else clause matches the 2nd if
        int i = 1;
        int j = 2;
        int k = 3;
        if (i > j) //1st if
            if (i > k)//2nd if
                System.out.println("A");

            else
                System.out.println("B");
        //To make else clause match 1st if we must use braces to specify blocks
        //for the piece of code below nothing will be printed because else clause matches the 2nd if
        if (i > j) { //1st if
            if (i > k)//2nd if
                System.out.println("2A");
        }
            else
                System.out.println("2B");

            //BOOLEAN TYPE
        int number = 15;
        boolean even = number % 2 ==0;

        // EXIT PROGRAM
        //System.exit(1);

        // LOGICAL OPERATORS
        /**
         * && and
         * || or
         * ^ exclusive or
         * ! not
         * example:
         * ((12%2==0) || (12%3==0)) True
         * ((12%2==0) ^ (12%3==0)) False
         * !((x>5) && (z<2)) False (there is "not=!" at the beginning)
         */
        // THE | AND & OPERATORS
        /**
         *
         */
        // CONDITIONAL EXPRESSIONS: A KIND OF IF STATEMENT TO USE IN A STRING
        /**
         *y=(x > 0) ? 0:1; //This expression exactly means same as this if statement below:
         *
         *if (x>0)
         *  y = 0;
         *else
         *  y = 1;
         *
         * Example:
         * boolean a = x < 0;
         * System.out.println("number "+x+ " is " + (a ?  "Negative" : "Not Negative ")");
         *
         * if a is true, "Negative" will be printed, otherwise Not Negative will be printed.
         *Example:
         * System.out.println((year < 2020) ? "was" : (year == 2020) ? "is" : "will be");
         * Like in the excell
         */


        //RANDOM NUMBER CREATION
        /**
         * Math.random() creates a number that is between 0 and 1, to obtain a lest say, 2 digit integer:
         * int varName = (int) (Math.random()*100);
         */


        //SWITCH STATEMENT
        /**
         * switch(switch-expression){//switch-expression must be char, short, byte or int and must be in parentheses
         *  case 0: compute 0 case expressions; //case value types must be = to type of switch-expression and must be constant
         *      break; // is optional but must be used, if not used the rest of the case conditions will be evaluated.
         *  case 1: compute1 cares;
         *      break;
         *  case 2:..............;
         *      break;
         *  ...
         *  ...
         *  case n: compute n case;
         *      break;
         *  default: compute default (example: print error message) expression; /default case is optional, it is for in case of none of the cases is = to switch-expression
         */


    }
}
