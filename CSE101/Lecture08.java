package CSE101;

import java.util.Scanner;

public class Lecture08 {
    public static void main(String[] args) {
        //DECLARE A TWO DIMENSIONAL ARRAY
        /**
         * dataType[][] refVar;
         */
        //CREATE A TWO DIMENSIONAL ARRAY AND ASSIGN TO A VARIABLE
        /**
         * refVar = new dataType[arraySize][arraySize]];
         */

        //DECLARE AND ASSIGN IN ONE STATEMENT
        /**
         * dataType[][ refVar = new dataType[arraySize][arraySize]];
         * //or
         * dataType refVar[][] = new dataType[arraySize][arraySize];
         *
         * int[][] matrix = new int[5][5]
         * int[row][column]
         *
         */
        //example
        /**int[][] matrix = new int[5][5];
         * matrix[1][3] = 7;
         *
         * results:
         *
         *     [0]  [1]  [2]  [3]  [4]
         * [0]  0    0    0    0    0
         * [1]  0    0    0    7    0
         * [2]  0    0    0    0    0
         * [3]  0    0    0    0    0
         * [4]  0    0    0    0    0
         *
         */
        int[][] matrix ={
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}
        };
        System.out.println("matrix.length is "+matrix.length);
        System.out.println("matrix[0].length is "+matrix[0].length);
        //matrix[4].length : ArrayIndexOutOFBoundsException

        /**
         * Each row in a two dimensional array may have different lengths, so these kind of two dimensional
         * arrays known as ragged arrays.
         */
        //INITIALIZING ARRAYS WITH INPUT VALUES

        Scanner input =new Scanner(System.in);
        System.out.println("Enter "+matrix.length+" rows and "+matrix[0].length+" columns: ");
        for (int row = 0; row < matrix.length; row++){
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = input.nextInt();
            }
        }
        for (int row = 0; row < matrix.length; row++){
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column]+"\t");
            }
            System.out.println();
        }
        //PASSING TWO DIMENSIONAL ARRAYS TO METHODS...





    }
}
