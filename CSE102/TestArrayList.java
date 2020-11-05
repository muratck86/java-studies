package CSE102;

import java.util.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList cityList = new ArrayList();
        cityList.add("Adana");
        cityList.add("Mersin");
        cityList.add("Konya");
        cityList.add("Malatya");
        cityList.add("Zonguldak");
        System.out.println("List size? "+cityList.size());
        System.out.println("Is Ankara in the list? "+cityList.contains("Ankara"));
        System.out.println("Is Adana in the list? "+cityList.contains("Adana"));
        System.out.println("The location of Malatya? "+cityList.indexOf("Malatya"));
        System.out.println("Is the list empty? "+cityList.isEmpty());

        //insert a new city at index 2
        cityList.add(2,"Diyarbakır");
        System.out.println("List size? "+cityList.size());
        cityList.remove("Mersin");
        System.out.println("List size? "+cityList.size());

    }
}
