package CSE102;

public class Lecture06 {
    public static void main(String[] args) {

        //ABSTRACT CLASSES AND METHODS

        /**
         * Abstract classes are defined with abstract key, and there are abstract
         * methods also defined with abstract key:
         * abstract class ClassName{
         *    some attributes...
         *    some constructors..
         *    some methods..
         *    abstract methodName(){} //nothing in method
         *    public abstract getArea(){} //nothing in method
         */
        //Abstract classes can not be instantiated and abstract methods must be overridden and defined
        //in the subclasses. By this way, any object of subclass can be treated as an object of the common
        //parent class.

        //See the example "ExampleAbstractClass.java"

        //An abstract method can not be defined in a non-abstract class.
        //A class contains abstract methods must be abstract class, but it is possible to define
        //an abstract class that contains no abstract class method.
        //An abstract class can not be instantiated by new operator. An abstract class is a base class for
        //defining a new subclass.

        //Subclass can be abstract even if its super class is concrete.
        //For example the Object class is concrete and it is super class of any abstract or concrete class.
        //A subclass can override a method from its super to be an abstract method.


        //Abstract classes can't be instantiated but they can be used as data types. For example:
        /**
         * following statement is true for GeometricObject class which is an abstract class:
         *
         * GeometricObject[] objList = new GeometricObject[10]
         *
         */


        //THE ABSTRACT NUMBER CLASS
        //Double, Float, Long, Integer, Short, Byte, BigInteger, BigDecimal classes are subclasses of Number class
        /**java.lang.Number
         * .byteValue()
         * .shortValue()
         * .intValue()
         * .longValue()
         * .floatValue()
         * .doubleValue()
         */
        //review "ExampleLargestNumbers.java" file


        //THE ABSTRACT CALENDAR CLASS AND ITS GREGORIANCALENDAR SUBCLASS
        /**java.util.Calendar
         *
         * Calendar() //constructs a default calendar
         * .get(field: int): int //returns the value of the given field
         * .set(field:int, value: int): void //sets the given calendar to the given value
         * .set(year: int, month: int, day: int): void //sets the calendar with the specified year, month and day
         * //the month is 0 based (january = 0)
         * .getActualMaximum(field:int) int //returns the max value that the calendar field could have
         * .add(field: int, amount: int) void //void adds or subtracts the given amount of time
         * .getTime(): java.util.Date // returns a Date object million seconds from epoch
         * .setTime(date: java.util.Date) void //set this calendars time with the given Date object.
         *
         * java.util.GregorianCalendar
         * GregorianCalendar() // constructs a Gregorian calendar for the current time.
         * GregorianCalendar(year: int, month: int, day: int) // january = 0
         * GregorianCalendar(year: int, month: int, day: int, hour: int, minute: int, second: int) //january = 0
         */
        //java.util.Date is a class, an instant of it represents milliseconds in time
        //java.util.Calendar is an abstract base class to extract year, month, day,
        // hour, minute and second from a Date object.
        //Subclasses of Calendar such as GregorianCalendar is one of specific calendar systems

        //new GregorianCalendar() can be used to construct a default GregorianCalendar with the current time
        //new GregorianCalendar(year, month, day) for a specified date, january is 0

        //get method in calendar class
        //get(int field) method is used for extracting date and time info from a calendar object. The fields are
        //constants as below:
        /**YEAR
         * MONTH
         * DATE //day of month
         * HOUR //12 hour notation
         * HOUR_OF_DAY //24 hour notation
         * MINUTE
         * SECOND
         * DAY_OF_WEEK //1 for sunday
         * DAY_OF_MONTH //same as DATE
         * DAY_OF_YEAR //1 for first day of the year
         * WEEK_OF_MONTH //1 for first week
         * WEEK_OF_YEAR //1 for first week
         * AM_PM //0 for AM and 1 for PM
         */

        //review "ExampleCalendar.java" file example

    }
}
