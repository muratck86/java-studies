package CSE101;

import java.util.Scanner;

public class Lecture07 {
    public static void main(String[] args) {

        //ARRAYS

        /**declaring an array
         * dataType[] name; //or
         * dataType name[]; //not preferred
         * example
         * int[] myList = new double[10];
         * */
        //declaring and creating in one step
        /**
         * dataType arrayRefVar[] = new dataType[arraySize];
         */
        double[] myExampleList = new double[10];
        //one an array is created its size can not be changed,
        //to find out size of an array:
        /**
         * myExampleList.length
         */
        System.out.println("\nmyExampleList Size   "+myExampleList.length);


        // When an array is created, its elements are assigned the default values which are:
        // 0 for primitive numeric types
        // '\u0000' for char types
        // false for boolean types
        // null for String types
        String[] myList1 = new String[5];
        System.out.println("\n2. index element of myList1   "+myList1[2]);
        char[] myList2 = new char[5];
        System.out.println("\n1. index element of myList2   "+myList2[1]);

        //INITIALIZERS
        //declaring, creating and initializing in one step:

        double[] myList3 ={1.5,2.7,-5.8,0.66,5.85,4}; // Must be in one statement

        //int[] myList0;
        //myList0 = {5,3,8,2} //ERROR.... WRONG.... DON'T DO

        String[] myList4 = new String[4];
        myList4[0] = "Murat";
        myList4[1] = "Şafak";
        myList4[2] = "Hasan";
        myList4[3] = "Abdurrezzak";
        System.out.println("\n\nmyList4 index 1 and 0 are   "+myList4[1]+" "+myList4[0]);

        //PRINTING ARRAYS
        System.out.print("\n\nmyList4 list is :\n");
        for (int i = 0; i < myList4.length; i++)
            System.out.print(myList4[i]+"\n");

        //INITIALIZING ARRAYS WITH INPUT VALUES
        int[] myList5 =new int[6];
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter "+myList5.length+" numbers :\n");
        //for (int i = 0; i < myList5.length; i++)
        //    myList5[i] = input.nextInt();

        //INITIALIZING ARRAYS WITH RANDOM VALUES
        char [] myList6 = new char[10];
        for (int i = 0; i < myList6.length; i++) {
            myList6[i] = (char) (Math.random() * ('z'-'A') + 'A');
            //System.out.print(myList6[i]+" , ");
        }
        //SUMMING ELEMENTS
        String password = "";
        for (int i = 0; i<myList6.length;i++)
            password +=myList6[i];
        System.out.print("\n\nPassword :"+password);

        double sum = 0;
        for (int i = 0; i<myList3.length;i++)
            sum +=myList3[i];
        System.out.printf("\n\nSum of myList3 : %.2f",sum);

        //FINDING THE LARGEST ELEMENT
        double max = myList3[0];
        for (int i = 0; i < myList3.length; i++)
            if (myList3[i]>max) max = myList3[i];
            System.out.print("\nGreatest element of myList3 is "+max+"\n");

        //RANDOM SHUFFLING ARRAY ELEMENTS
        int[] myList7 ={0,1,2,3,4,5,6,7,8,9};
        for (int i = 0; i<myList7.length;i++){
            int j = (int)(Math.random()*(myList7.length-1));
            int temp;
            temp = myList7[i];
            myList7[i] = myList7[j];
            myList7[j] = temp;
        }
        System.out.print("\n mylist8 shuffled :\n");
        for (int i = 0; i < myList7.length; i++)
            System.out.println(myList7[i]);

        //SHIFTING ELEMENTS
        int[] myList8 = {0,1,2,3,4,5,6,7,8,9};
        int temp = myList8[0];
        for (int i =0; i<myList8.length-1; i++){

            //shift elements left by one index
            myList8[i]=myList8[i+1];

            //move 0th element to last position
        } myList8[myList8.length-1]=temp;
        System.out.print("\n mylist8 shifted left :\n");
        for (int i = 0; i < myList8.length; i++)
            System.out.println(myList8[i]);

        //FOR EACH LOOP (ENHANCED FOR LOOP) (FOR LOOP WITHOUT AN INDEX VARIABLE)
        for (int each:myList8)
            System.out.print("\n"+each);
        /**
         * for (dataType varName: arrayRefVar){
         * sequential exppressions
         * }
         */


        //COPYING ARRAYS USING UTILITIES

        /**
         * System.arraycopy(soruceArray, source_position, targetArray, target_position, length)
         */
        //example
        int[] srcList = {2,5,7,0,6,8};
        int[] trgList = new int[9];
        System.arraycopy(srcList, 0, trgList,0,srcList.length);
        System.out.print("\nTarget Array after Copy :");
        for (int i = 0; i< trgList.length; i++)
            System.out.print(trgList[i]+" ");


        //PASSING ARRAYS TO METHODS
        /**
         * ----define a method...
         * public static void printArray(int[] name){
         * for loop to print array...
         * }
         *
         * ----invoke the method...
         * printArray(arrayName);
         *
         * ----or invoke the method with anonymous arrays
         * printArray(new int[]{2,6,82,9,4});
         *
         *
         * example defining method is outside of main method....
         */
        //invoke method..
        printArray(myList7);
        printArray(new int[]{6,7,0,0,41,1000000000}); //given argument is called an anonymous array

        //RETURNING AN ARRAY FROM A METHOD
        /**
         * public static int[] methodName(int[] arrayName){
         * process....
         * return resultArray;
         * }
         */
        //example
        printArray(reverseArray(new int[] {1,2,3,4,5,6}));

        // THERE ARE SOME METHODS FOR ARRAYS PROVIDED BY JAVA
        /**
         * Arrays.sort(array);
         * Array.toString(array); //Prints an array in square brackets and comma between each elements.
         */


        //INVOKING MAIN METHOD BY PASSING ARGUMENTS TO
        /**
         * public class TestFileB {
         *     public static void main(String[] args) {
         *         for (int i = 0; i < args.length; i++)
         *             System.out.println(args[i]);
         *     }
         * }
         *
         * public class TestFileA {
         *     public static void main(String[] args) {
         *         String[] nameList = {"murat", "Ahmet", "Hasan", "Cemal", "Melek", "Deniz"};
         *         TestFileB.main(nameList);
         *     }
         * }
         */
        //IN THE COMMAND LINE TO INVOKE A MAIN METHOD
        /**
         * >java TestFileB nameList
         * //or
         * >java TestFileB arg1 arg2 arg3 arg4 ......argn
         */




    }
    public static void printArray(int[] listName){
        System.out.print("\nListing array :\n");
        for (int i:listName)
            System.out.println(i);
    }
    public static int[] reverseArray(int [] numbers){
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            result[i] = numbers[numbers.length-1-i];
        }
        return result;
    }
}
