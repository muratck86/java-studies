package CSE102Midterm;

import java.util.ArrayList;
import java.util.Arrays;

public class Astronaut extends Payload {
    private int count = 2;
    private ArrayList<String> passengers = new ArrayList<>();
    public Astronaut(){
    }
    public Astronaut(int count, String[] passengers){
        this.count = count;
        this.passengers.addAll(Arrays.asList(passengers));
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<String> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<String> passengers) {
        this.passengers = passengers;
    }
}
