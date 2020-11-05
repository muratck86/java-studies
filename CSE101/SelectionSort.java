package CSE101;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] myList = LinearSearch.createRandomArray(50,350);
        printArray(myList);
        int [] mySortedArray = selectionSort(myList);
        printArray(mySortedArray);
        System.out.println( Arrays.toString(mySortedArray));
    }

    /**Selection Sort*/
    public static int[] selectionSort(int[] list){
        int temp ;
        int counter = 0;
        while(counter < list.length) {
            int min = list[counter];
            int tempIndex = counter;
            for (int i = counter; i < list.length; i++) {
                if (min > list[i]) {
                    min = list[i];
                    tempIndex = i;
                }
            }
            list[tempIndex] = list[counter];
            list[counter] = min;
            counter++;
        }
        return list;
    }

    /** A method to print an array*/
    public static void printArray(int[] array){
        System.out.print("\n");
        for (int i = 0;i < array.length; i++){
            System.out.print(array[i]+"\t");
        }
        System.out.print("\n");
    }
}
