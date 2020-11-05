package CSE102;

import java.io.Serializable;
import java.util.Comparator;
public class ExampleComparator{
    public static void main(String[] args) {
        GeometricObject g1 = new Rectangle(5,5);
        GeometricObject g2 = new Circle(5);
        GeometricObject g = max(g1, g2,new GeometricObjectComparator());
        System.out.println("The area of the larger object is "+g.getArea());
    }
    public static GeometricObject max(GeometricObject o1, GeometricObject o2, Comparator<GeometricObject> o){
        if (o.compare(o1, o2) > 0)
            return o1;
        else return o2;
    }
}

class GeometricObjectComparator implements Comparator<GeometricObject>, Serializable {
    public int compare(GeometricObject o1, GeometricObject o2){
        double area1 = o1.getArea();
        double area2 = o2.getArea();
        if(area1 < area2)
            return -1;
        else if (area1 == area2)
            return 0;
        else return 1;
    }
}
