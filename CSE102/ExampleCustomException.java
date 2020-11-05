//package CSE102;

public class ExampleCustomException {
    public static void main(String[] args) {
        /**Testing*/
        CircleWithCustomException c1 = new CircleWithCustomException();
        CircleWithCustomException c2 = new CircleWithCustomException();
        CircleWithCustomException c3 = new CircleWithCustomException(5);
        CircleWithCustomException c4 = new CircleWithCustomException(-3);
        CircleWithCustomException c5 = new CircleWithCustomException(8);
        System.out.println("Total circles created: "+ CircleWithCustomException.getNumOfCircles());
        System.out.println(c5.getRadius());
    }
}
class CircleWithCustomException {

    /**the radius of the circle*/
    private double radius;

    /**the count of objects created*/
    private static int numOfCircles = 0;

    /**no Arg constructor with radius of 1*/
    public CircleWithCustomException(){
        this(1.0);
    }
    /**constructor with a specified radius*/
    public CircleWithCustomException(double newRadius){
        try {
            setRadius(newRadius);
            numOfCircles++;
        }
        catch (InvalidRadiusException ex){
            ex.printStackTrace();
            //System.out.println(ex);
        }
    }

    /**return radius of object*/
    public double getRadius() {
        return radius;
    }

    /**Set a new radius to an existing circle object*/
    /**InvalidRadiusException custom exception class is defined below*/
    public void setRadius(double newRadius) throws InvalidRadiusException {
        if (newRadius >= 0)
            this.radius = newRadius;
        else throw new InvalidRadiusException(newRadius);
    }

    public static int getNumOfCircles() {
        return numOfCircles;
    }
    public double getArea(){
        return 22/7.0*radius*radius;
    }
}
/**Creation of a custom exception*/
class InvalidRadiusException extends Exception {
    private double radius;

    /**constructor of the exception*/
    public InvalidRadiusException(double radius) {
        super("Invalid Radius" + radius);
        this.radius = radius;
    }

    /**return the radius*/
    public double getRadius() {
        return radius;
    }
}
