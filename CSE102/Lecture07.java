package CSE102;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Lecture07 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> courses = new HashMap<>();
        courses.put("CSE1",new ArrayList<String>(Arrays.asList(new String[] {"123","234","456"})));
        courses.put("CSE2",new ArrayList<String>(Arrays.asList(new String[]{"456","567"})));

        System.out.println(courses);
        //System.out.println(switchMap(courses));
        //System.out.println(courses.get("CSE1"));
        //System.out.print(courses.keySet());
        System.out.println(courses);
        System.out.println(switchMap(courses));
    }
    public static HashMap<String,ArrayList<String>> switchMap(HashMap<String,ArrayList<String>> myMap){
        HashMap<String,ArrayList<String>> students = new HashMap<>();
        for (String k: myMap.keySet()){
            ArrayList<String> mL = new ArrayList<>();
            for (String s: myMap.get(k))
                students.put(s,mL);
                mL.add(k);
        }
        return students;
    }

}
