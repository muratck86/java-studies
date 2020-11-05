package CSE102;

import java.util.*;

public class ExampleCalendar {
    public static void main(String[] args) {
        //construct a Gregorian Calendar with the current date and time
        Calendar calendar = new GregorianCalendar();
        System.out.println("Current time is "+new Date()+"\t Code: new Date()");
        System.out.println("Current Month is "+calendar.get(Calendar.MONTH)+"\t Code: calendar.get(Calendar.MONTH)");
        System.out.println("Current Day of the month is "+calendar.get(Calendar.DATE)+
                "\t Code: calendar.get(Calendar.DATE)");
        System.out.println("Current Hour is "+calendar.get(Calendar.HOUR)+"\t Code: calendar.get(Calendar.HOUR)");
        System.out.println("Current Minute is "+calendar.get(Calendar.MINUTE)+"\t Code: calendar.get(Calendar.MINUTE)");
        System.out.println("Current AM_PM "+calendar.get(Calendar.AM_PM)+"\t Code: calendar.get(Calendar.AM_PM)");
        System.out.println("Current Time is "+ calendar.get(Calendar.HOUR)+":"+ calendar.get(Calendar.MINUTE));

        //Construct a Calendar for 12 July 1986
        Calendar calendar1 = new GregorianCalendar(1986,6,12);
        String[] dayNameOfWeek = {"Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday","Saturday"};
        System.out.println("12th July, 1986 is a "+dayNameOfWeek[calendar1.get(Calendar.DAY_OF_WEEK)-1]);

    }
}
