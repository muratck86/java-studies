package CSE102;

public class ExampleException {
    public static void main(String[] args) {
        /**Testing*/
        try {
            CircleWithException c1 = new CircleWithException();
            CircleWithException c2 = new CircleWithException();
            CircleWithException c3 = new CircleWithException(5);
            CircleWithException c4 = new CircleWithException(-3);
            CircleWithException c5 = new CircleWithException(8);
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }
        System.out.println("Total circles created: "+ CircleWithException.getNumOfCircles());
    }
}
class CircleWithException{
    /**the radius of the circle*/
    private double radius;
    /**the count of objects created*/
    private static int numOfCircles = 0;
    /**no Arg constructor with radius of 1*/
    public CircleWithException(){
        this(1.0);
    }
    /**constructor with a specified radius*/
    public CircleWithException(double newRadius){
        setRadius(newRadius);
        numOfCircles ++;
    }
    /**return radius of object*/
    public double getRadius() {
        return radius;
    }
    /**Set a new radius to an existing circle object*/
    public void setRadius(double newRadius) throws IllegalArgumentException {
        if (newRadius >= 0)
            this.radius = newRadius;
        else throw new IllegalArgumentException("Radius cannot be negative.");
    }
    public static int getNumOfCircles() {
        return numOfCircles;
    }
    public double getArea(){
        return 22/7.0*radius*radius;
    }
}
