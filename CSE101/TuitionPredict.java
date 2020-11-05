package CSE101;

public class TuitionPredict {
    public static void main(String[] args) {
        double tuition = 10000;
        double nextTuition = tuition;
        double INCREASE_RATE = 0.07;
        int counter = 0;
        do{
            nextTuition *= (1+INCREASE_RATE);
            counter++;
        } while(nextTuition<tuition*2);
        System.out.println("Current tuition :"+tuition+"\nYears to tuition to double :"+
                counter+"\nExact value of tuition then :"+nextTuition);
    }
}
