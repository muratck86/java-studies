package CSE102;

import java.util.*;

public class deneme {
    public static void main(String[] args) {
        SortedMap<String, Integer> testMap = new TreeMap<>();
        testMap.put("Murat",2);
        testMap.put("Melek",1);
        try {
            System.out.println(testMap.get("Maaamut"));
        }catch (Exception ex){
         System.out.println(ex);
        }

    }
}
