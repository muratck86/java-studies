package CSE101;

public class LinearSearch {
    public static void main(String[] args) {
        //create a list of arrays
        int [] myList = createRandomArray(50,100);

        //Print lis to have a look at
        for (int i:myList)
            System.out.print(i+"\t");
        System.out.print("\n");

        //Linear Search the array if an integer exists in it and print the result (-1 if don't exists)
        System.out.print(linearSearch(myList,30));
    }
    /**Create a method to generate a list of given number of random integer elements each between 0-max.*/
    public static int[] createRandomArray(int num,int max){
        int[] myList = new int[num];
        for(int i=0;i<myList.length;i++)
            myList[i] =(int)(Math.random()*max);
        return myList;
    }

    /**Create a method to find an element (int) in an array of integers..
     * If there are more than one, index of the first found will return*/
    public static int linearSearch(int[] nums, int num){
        for (int i = 0;i < nums.length; i++){
            if (num ==nums[i])
                return i;
        }
        return -1;
    }
    /**Gives index of given integer in an array*/

}
