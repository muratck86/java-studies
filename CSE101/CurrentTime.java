package CSE101;

public class CurrentTime {
    public static void main(String[] args) {
        //Obtain total milliseconds past since EPOCH
        long totalMillisecs = System.currentTimeMillis();
        //Obtain Seconds...
        long totalSecs = totalMillisecs/1000;
        //Obtain current Second
        long currentSec = totalSecs%60;
        //Obtain current minute
        long currentMin = totalSecs/60%60;
        //Obtain current hour
        long currentHour = totalSecs/60/60%60%24;
        //GMT +3 for Turkey
        currentHour+=3;

        //Print results
        System.out.println("Current Time is "+currentHour+":"+currentMin+":"+currentSec);


    }
}
