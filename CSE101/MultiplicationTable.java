package CSE101;

public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1;i<10;i++){
            System.out.print("\n");
            int j = 1;
            while (j<10){
                System.out.print("\t"+j+" x "+i+" = "+i*j);
                j++;
            }
        }
    }
}
