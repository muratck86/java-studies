package CSE102;
/**
 * @author Murat Can Kurt
 * @since 11.05.2020
 */

import java.util.*;

public class CSE102Lab08App {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        LinkedList<Integer> list2 = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        LinkedList<Integer> greater = maxSum(list1,list2,new LinkedListIntegerSumComparator());
        System.out.println("The list which has greater sum is "+greater.toString());
    }
    public static LinkedList maxSum(LinkedList<Integer> list1, LinkedList<Integer> list2,
                                    Comparator<LinkedList<Integer>> s){
        if (s.compare(list1,list2) > 0)
            return list1;
        else return list2;
    }
}
class LinkedListIntegerSumComparator implements Comparator<LinkedList<Integer>> {
    public int compare(LinkedList<Integer> l1, LinkedList<Integer> l2){
        int sum1 = sum(l1);
        int sum2 = sum(l2);
        return Integer.compare(sum1, sum2);
    }
    private int sum(LinkedList<Integer> list1){
        ListIterator<Integer> listIterator = list1.listIterator();
        int sum = 0;
        while (listIterator.hasNext()){
            sum += listIterator.next();
        }
        return sum;
    }
}
