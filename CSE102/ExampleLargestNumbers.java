package CSE102;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class ExampleLargestNumbers {
    public static void main(String[] args) {
        ArrayList<Number> list = new ArrayList<>();
        list.add(45); //add an integer
        list.add(254.628); //add a double
        list.add(new BigInteger("585456552685456855")); //add a BigInteger
        list.add(new BigDecimal("6526555658.55656556162985545")); //add a BigDecimal

        System.out.println("The largest number in the list is:\n"+getLargestNumber(list));
    }
    public static Number getLargestNumber(ArrayList<Number> list) {
        if (list == null ||list.size()==0)
            return null;
        Number number = list.get(0);
        for (int i = 1; i <list.size(); i++)
            if (number.doubleValue() < list.get(i).doubleValue())
                number = list.get(i);
        return number;
    }
}
