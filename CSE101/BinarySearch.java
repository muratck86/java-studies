package CSE101;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        //Generate an array invoking a method I defined before..
        int[] myList= LinearSearch.createRandomArray(32,64);
        // Let's display generated array
        System.out.println("Generated array :");
        SelectionSort.printArray(myList);

        //To use binary search the array must be in order so to invoke a method I defined before...
        int[] mySortedList = SelectionSort.selectionSort(myList);

        // Let's display sorted array
        System.out.println("\nSorted array :");
        for (int i = 0; i < mySortedList.length; i++)
            System.out.print(i+"\t");
        SelectionSort.printArray(mySortedList);

        //Now We can search for a value in the list...
        Scanner input =new Scanner(System.in);
        System.out.println("Enter a value to search in the list:");
        int searchNum = input.nextInt();

        int result = binarySearch(mySortedList, searchNum);
        if (result ==-1){
            System.out.println("Not Found...");
        }else System.out.println("Index number of "+searchNum+" in the array is :"+result);
    }
    public static int binarySearch(int[] array, int value){//37
        int max = array.length-1; //60
        int min = 0;
        int mid = max/2;
        while (true){
            if (min == 0)
                mid = max / 2;
            mid = (max + min)/2;
            System.out.println(mid);
            System.out.println("min: "+min+ "mid: "+mid+" max: "+max);
            if(Math.abs(min - mid) < 1){
                System.out.println("No Match...");
                return -1;
            }
            else if (value > array[mid]){ //30 //45 //32
                System.out.println("Is greater...");
                min =mid; //20 //38
            }
            else if (value < array[(max+min)/2]){ //45 //32 //38
                System.out.println("Is less...");
                max = mid; //45 //38
            }
            else if (value == array[mid]){
                System.out.println("Is Equals to...");
            return mid;
            }
        }
    }
}
