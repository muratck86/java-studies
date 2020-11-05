package CSE102;

import java.util.Date;

public class ExampleAbstractClass {
    /**The main method*/
    public static void main(String[] args) {
        /** Testing Abstract class subject*/
        //Declare and initialize geometric objects by their own classes and GeometricObject class
        GeometricObject c1 = new Circle(8);
        GeometricObject r1 = new Rectangle(8,6);
        GeometricObject r2 = new Rectangle(3,16);
        GeometricObject c2 = new Circle();
        Rectangle r3 = new Rectangle(10,12);
        Rectangle r4 = new Rectangle();
        Circle c3 = new Circle(5);

        //How do we initialize a circle or rectangle with color or/and filled value?

        //Display area or Perimeter
        System.out.println(c1.getArea());
        System.out.println(r1.getArea());

        //display area and perimeter of a GeometricObject object by
        //invoking displayObject() method.
        displayObject(c1);

        //compare areas of two GeometricObject objects
        System.out.println(isAreasEqual(c1,r2));
        System.out.println(isAreasEqual(r3,r2));

        //Other methods of abstract class
        System.out.println(c1.toString());
        System.out.println(c3.getArea());
        System.out.println(r1.getPerimeter());

        //Methods of subclasses
        //why I can't invoke methods of subclasses that defined by Abstract Super class?
        //System.out.println(r1.getHeight());
        //System.out.println(c2.getRadius());
        System.out.println(r4.getHeight());
        System.out.println(c3.getRadius());





    }
    /**A method to compare if areas are equal*/
    public static boolean isAreasEqual(GeometricObject obj1, GeometricObject obj2){
        return obj1.getArea() == obj2.getArea();
    }
    /**A method for displaying a GeometricObject*/
    public static void displayObject(GeometricObject obj){
        System.out.println();
        System.out.println("The area is "+obj.getArea());
        System.out.println("The perimeter is "+obj.getPerimeter());
    }
}


//-----------------------------------------Abstract Super Class--------------------------
/**Abstract classes defined with abstract key*/
abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    /**no-arg Constructor*/
    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }
    /**construct a geometric object with a color and filled value*/
    protected GeometricObject(String color,boolean filled){
        this.dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }
    /** getColor method*/
    public String getColor() {
        return color;
    }
    /** set a new color method*/
    public void setColor(String color) {
        this.color = color;
    }
    /**Return filled, since filled is boolean,
     * the method is named isFilled */
    public boolean isFilled() {
        return filled;
    }
    /**set a new filled*/
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    /** get created date*/
    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "Created on " +dateCreated+"\nColor : "+color+" and filled : "+filled;
    }
    /**Abstract method getArea*/
    public abstract double getArea();

    /**Abstract method getPerimeter*/
    public abstract double getPerimeter();
}
//----------------------------------------Concrete Classes------------------------------
class Circle extends GeometricObject {
    private double radius;

    public Circle(){
    }
    public Circle(double radius){
        this.radius = radius;
    }
    /** get radius */
    public double getRadius() {
        return radius;
    }
    /**set radius */
    public void setRadius(double radius) {
        this.radius = radius;
    }
    /** Override empty getArea() method of Super class (abstract)
     * this is the logic of abstract classes, abstract methods of abstract
     * have to be Overridden
     */
    @Override
    public double getArea() {
        return 22/7.0*radius*radius;
    }
    /**Override abstract method getPerimeter*/
    @Override
    public double getPerimeter() {
        return 2*22/7.0*radius;
    }
    /**getDiameter method*/
    public double getDiameter(){
        return 2*radius;
    }
    /**print circle info method */
    public void printCircleInfo(){
        System.out.println("Circle Creation Date : "+getDateCreated()+"\n Radius : "+radius);
    }
}
class Rectangle extends GeometricObject{
    private double width;
    private double height;

    public Rectangle(){
    }
    public Rectangle(double width, double height){
        this.height = height;
        this.width = width;
    }
    /**getter and setters of this class*/
    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    /**Override abstract methods*/
    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getPerimeter() {
        return 2*(width+height);
    }
}
