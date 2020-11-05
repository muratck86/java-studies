package CSE102;

public class Lecture01 {
    public static void main(String[] args) {
        //Static and non static modifier
        /**
         * Static modifier concerns all of the class and class objects.
         * A static method or property can be accessed from an object of the class or
         * class itself.
         * If I change a static property it effects all the objects' that property.
         * A non static property is just for that object.
         * Like radius of a circle object.
         */
        //VISIBILITY MODIFIERS AND ACCESSOR/MUTATOR METHODS
        /**
         * There are three kinds of visibility...
         * public: everywhere
         * private: inside of a class
         * default inside of a package (if no public or private modifier specified, then it is default)
         */
        //Default
        /**By default a class variable or method can be accessed by any class in the same PACKAGE.*/
        //Public
        /**The class, data or method is visible to any class in any package.
         * if a class is public, the file name must be same as class name and, there can't be another public
         * class outside that class in the same java file.
         */
        //Private
        /**The data or methods can be accessed by only the declaring class
         */

        //IMMUTABLE OBJECTS AND CLASSES
        /**if properties of a class are private and there are no setter methods, then the class and its objects
         * are called immutable. But although a class has its all properties are private and no mutators, still
         * it is not certainly immutable, there must be no any other references, classes or method could change
         * its fields at all.
         */

        //THE THIS KEYWORD
        /**
         * -It is the name of a reference that refers to an object itself.
         * -It is reference a class' hidden fields.(we use in the setters to change the private fields)
         * -It is used to enable a constructor to invoke another constructor of the same class (we use in the
         * constructors)
         */

    }
}
