package CSE101;

import java.util.Arrays;

public class FindNearestPoints {
    public static void main(String[] args) {
        double[][] points={
                {-1,3},
                {-1,-1},
                {1,1},
                {2,0.5},
                {2,-1},
                {3,3},
                {4,2},
                {4,-0.5}
        };
        double min = calcDistance(points[0],points[1]);
        double tempMin;
        double[][] minPoints = new double[2][2];
        for (int i = 0;i < points.length; i++){
            for (int j = i+1;j < points.length; j++){
                tempMin = calcDistance(points[i],points[j]);
                if (tempMin < min){
                min = tempMin;
                minPoints[0] = points[i];
                minPoints[1] = points[j];
                }
            }
        }
        System.out.println(Arrays.toString(minPoints[0])+ " and " + Arrays.toString(minPoints[1])+" are nearest points" +
                "and the distance is: "+(int)(min*100)/100.0);
    }
    public static double calcDistance(double[] a,double[] b){
        double dx = a[0]-b[0];
        double dy = a[1]-b[1];
        return Math.sqrt(dy*dy+dx*dx);
    }
}
