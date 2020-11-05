package CSE101;

import java.util.Scanner;

public class FtoCelcius {
    public static void main(String[] args) {
        System.out.println("Enter Fahrenheit tempereture degree :");
        Scanner read = new Scanner(System.in);
        double fahrTemp=read.nextDouble();
        double celcTemp= (5.0/9.0)*(fahrTemp - 32);
        System.out.println(fahrTemp+" F degrees is "+celcTemp+" C degrees");
    }
}
