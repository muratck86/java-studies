package CSE102;

public class AssertionExample {
    public static void main(String[] args) {
        int i; int sum = 0;
        for (i = 0; i < 10; i++) {
            sum += i;
        }
        System.out.println("i = "+i+" Sum = "+sum);
        assert i == 10; //true
        assert sum > 10 && sum < 4 * 10 : "sum is " + sum; //true sum is 45 so it is between 10 and 50.
    }
}
