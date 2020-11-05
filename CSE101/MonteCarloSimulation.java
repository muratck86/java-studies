package CSE101;

public class MonteCarloSimulation {
    public static void main(String[] args) {
        final int NUM_OF_TRIALS = 10000000;
        int numOfHits = 0;
        for (int i=0;i<=NUM_OF_TRIALS;i++){
            double x = Math.random()*2.0-1;
            double y = Math.random()*2.0-1;
            if (Math.pow(x,2)+Math.pow(y,2)<=1)
                numOfHits++;
        }
        double pi = 4.0*numOfHits/NUM_OF_TRIALS;
        System.out.println("Pi is :"+pi);
    }
}
