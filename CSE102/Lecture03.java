package CSE102;

import java.util.ArrayList;

public class Lecture03 {
    public static void main(String[] args) {
        //
        /**
         * Super class's constructor is not inherited, They are invoked explicitly or implicitly.
         * explicitly using the keyword "super"...
         * if the constructor is not invoked, then no arg constructor is invoked automatically
         */
        //These classes are equal...
        /**
         * public A(){
         * }
         *
         * public A(){
         * super();
         * }
         */

        /**
         * if there is super() keyword, then it must be the first statement
         * And super keyword can be used for two things:
         * to call a superclass constructor
         * to call a superclass method.
         */
        //A private method can not be overridden since it is not accessible, but they are inherited as well as
        //the other methods

        //POLYMORPHISM, DYNAMIC BINDING GENERIC PROGRAMMING
        /**
         * if a method takes a parameter of for example Person class, it can be invoked with any class which are
         * subclasses of Person.
         * If the method is defined with a parameter of Object type, then it can be invoked with any object.
         * This feature is called polymorphism.
         *
         * Consider Class's GradStudent, Student, Person, Object and a method met defined with parameter Object
         * as below:
         * public static void met(Object somebody){
         * System.out.println(somebody.toString());
         * }
         * So in this case, which class's toString method will be called? Each class's toString method can be different
         * JVM binds the appropriate toString() method of which class's instance (Student? , Person?...) is passed to
         * met This is called dynamic binding.
         *When a method is called, Java searches the method in the class's in an order from most specific to most
         * general (the most general class is the Object class) and calls the first found one.
         *
         */

        //CASTING OBJECTS
        /**
         * implicit casting is legal from super class to subclass but cant be used from sub class to superclass
         * Object ex = new Student(); //implicit casting is legal
         * Student b = ex; //Even we know that o is an instance of Student this format doesn't work.
         * We have to use explicit casting:
         * Student b = (Student)ex
         */

        //THE INSTANCEOF OPERATOR
        /**
         * this operator is used for testing whether an object is an instance of a class
         * Object ex = new Student();
         * if (ex instanceof Person) //true
         *    do something
         */

        //THE ARRAYLIST CLASS
        /**
         * This class is a generic class with a generic type E
         * A specific type can be specified while defining
         * The size is not fixed unlike Arrays.
         * ArrayList()
         * .add(object) //append an object at the end of the list
         * .add(index, object)
         * .clear()
         * .contains(object): boolean
         * .get(index)
         * .indexOf(object) //first matching
         * .isEmpty()
         * .lastIndexOf(object)
         * .remove(object)
         * .size()
         * .remove(index)
         * .set(index, object) changes the element in the specified index
         */
        //Creating and implementing ArrayList
        ArrayList<String> names = new ArrayList<>();
        names.add("Murat");
        names.add("Şafak");
        names.add("Rojhat");
        names.add("Tinda");
        names.add("Uygar");
        System.out.println(names);
        System.out.println(names.get(2));
        names.set(2,"melek");
        System.out.println(names.get(2));
        names.add(2,"Rojhat");
        System.out.println(names.get(2));
        System.out.println(names);

        //VISIBILITY MODIFIERS
        /**
         * public       accessed from same class same package subclass different package
         * protected    accessed from same class same package subclass
         * default      accessed from same class same package
         * private      accessed from same class
         *
         * A subclass can override a protected method and change its visibility to public but cant change it to
         * default or private. (can not reduce visibility, but can increase)
         *
         * the final class can not be extended and can not be overridden
         */






    }
}
