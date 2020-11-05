package CSE101;

public class CheckSudokuSolution {
    public static void main(String[] args) {
        int[][] sudoku1 ={
                {5,3,4,6,7,8,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9}
        };
        checkColumns(sudoku1);
        checkRows(sudoku1);
        checkEach(sudoku1);

    }
    public static void checkRows(int[][] sudoku){
        for (int i = 0; i < sudoku.length; i++){
            for (int j = 0;j<sudoku[i].length; j++){
                for (int k=j+1; k<sudoku[i].length; k++){
                    if (sudoku[i][j] == sudoku[i][k])
                        System.out.println((i+1)+"x"+(j+1)+" and "+(i+1)+"x"+(k+1)+" are "+sudoku[i][j]);
                }
            }
        }
    }
    public static void checkColumns(int[][] sudoku){
        for (int i = 0; i < sudoku.length; i++){
            for (int j = 0; j < sudoku[i].length; j++){
                for(int k = j+1; k<sudoku[i].length; k++){
                    if (sudoku[j][i] == sudoku[k][i]){
                        System.out.println((j+1)+"x"+(i+1)+" and "+(k+1)+"x"+(i+1)+" are "+sudoku[j][i]);
                    }
                }
            }
        }
    }
    public static void checkEach(int[][] sudoku){
        int[][] little = new int[3][3];
        for (int i = 0; i < (sudoku.length-2); i +=3){
            little[0][0] = sudoku[i][i];
            little[0][1] = sudoku[i][i+1];
            little[0][2] = sudoku[i][i+2];
            little[1][0] = sudoku[i+1][i];
            little[1][1] = sudoku[i+1][i+1];
            little[1][2] = sudoku[i+1][i+2];
            little[2][0] = sudoku[i+2][i];
            little[2][1] = sudoku[i+2][i+1];
            little[2][2] = sudoku[i+2][i+2];
            checkRows(little);
            checkColumns(little);
        }
    }
}
