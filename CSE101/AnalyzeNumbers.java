package CSE101;

public class AnalyzeNumbers {
    public static void main(String[] args) {
    //Create an array that has 100 integer elements randomly (each element is between 0 and 250)
    int[] dataList = new int[100];
    for (int i = 0; i < dataList.length; i++){
        dataList[i] = (int)(Math.random()*250);
    }
    //Print created array to be sure it is proper
    for (int a:dataList)
        System.out.print(a+" ");

        //Calculate average...
        int sum = 0;
        for (int i:dataList){
            sum+=i;
        }
        double average = sum/(dataList.length*1.0);

        //Create an empty array for variations
        double[] variations = new double[100];

        //Calculate every variation and put into variations array in order
        //count elements greater than average
        int count = 0;
        for (int i = 0; i < variations.length; i++){
            variations[i] = dataList[i] - average;
            if (dataList[i]>average)
                count++;
        }
        System.out.print("\nAverage :\n"+average+"\n");

        //Print created array to be sure it is proper
        System.out.println("Variations List :");
        for (double a:variations)
            System.out.print(a+" ");

        //Print count of elements greater than average
        System.out.print("\nNumber of elements greater than average :\n"+count);
    }
}
