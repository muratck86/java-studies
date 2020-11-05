package CSE101;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle(10);
        System.out.println(c1);

        Circle c2 = new Circle(15);
        System.out.println(c2);

        c1.setCircleCount(5);
        System.out.println(c1);
        System.out.println(c2);


    }
    static class Circle{
        private double radius;
        static int circleCount = 0;
        public Circle(double radius){
            this.radius = radius;
            circleCount++;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public void setCircleCount(int circleCount) {
            this.circleCount = circleCount;
        }

        public int getCircleCount() {
            return circleCount;
        }

        @Override
        public String toString() {
            return "Circle{" +
                    "radius=" + radius +
                    ", circleCount=" + circleCount +
                    '}';
        }
    }

}
