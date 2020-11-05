package CSE101;

public class PrimeNumbers {
    /**
     * Prints the first 50 prime numbers in 50 lines.
     * 10 numbers each line.
     */
    public static void main(String[] args) {
        int isPrime = 3;
        int counter = 1;
        System.out.print(2+"\t");
        while (counter<50){
            for (int s = 2; s <= isPrime; s++) {
                if (isPrime % s == 0) {
                    break;
                }
                else if (s>=(isPrime/2)){
                    System.out.print(isPrime + "\t");
                    counter++;
                    if (counter%10==0)
                        System.out.println();
                    break;
                }
            }
            isPrime+=2;

        }
    }
}
