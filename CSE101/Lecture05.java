package CSE101;

public class Lecture05 {
    public static void main(String[] args) {


        //WHILE LOOPS
        int count = 0;
        while (count<100){
            count++;
            System.out.printf("%-5d Welcome to java...\n",count);
        }



        //DO WHILE LOOPS
        int c = 4;
        do{
            //loop body
            System.out.println(c);
            c++;
        } while (c<15);


        //FOR LOOPS
        int i; //integer i must be defined before we use it in the loop...
        for (i = 1; i<=8;i+=2){// start from 1 and increase 2 every turn until i is not less than or equals to 8
            //For loop body
            System.out.println(i+" Hello World...");
        }
        //these for loops are also correct
        for (int k = 0;k<6;System.out.println(k++)){
            System.out.println("Murat");
        }
        for (int l = 0, m = 5;(l+m<20);l++,m+=2){
            System.out.println("Can");
        }


        //infinite loop of for and while and BREAK / CONTINUE
        /**
         * for(;;){
         *     expression..;
         * }
         * while (true){
         *     expression1..;
         *     expression2;
         *     expression3;
         *     expressionN;
         *
         *     break;
         *     continue;
         * }
         * These expressions above are same...
         */

        //another example of for loop...

        int n =1;
        for (;n<5;){
            System.out.println("n = "+n++);
            break;
            //continue;
        }
    }
}
