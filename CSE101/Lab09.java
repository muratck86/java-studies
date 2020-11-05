package CSE101;

public class Lab09 {
    public static void main(String[] args) {
        int[][] mat1 = {
                {2, 5, 7, 9, 21},
                {5, 11, 16, 85, 22},
                {0, 10, 41, 26, 13},
                {19, 14, 5, 72, 15} };
        int[][] mat2 = {
                {25, 16, 62, 68, 7},
                {62, 52, 63, 12, 22},
                {22, 88, 44, 69, 33},
                {25, 11, 83, 60, 3} };
        sumMatrix(mat1, mat2);
        timesTable(16);
    }
    public static int[][] sumMatrix(int[][] m1, int[][] m2){
        int [][] result = new int[m1.length][m1[0].length];
        for (int i = 0; i< m1.length; i++){
            for(int j = 0; j < m1[i].length; j++){
                result[i][j] = m1[i][j] + m2[i][j];
                System.out.print(result[i][j]+"\t");
            }
            System.out.println();
        }
        return result;
    }
    public static int[][] timesTable(int n){
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                result[i][j] = (i+1) * (j+1);
                System.out.print(result[i][j]+"\t");
            }
            System.out.println();
        }
        return result;
    }
}
