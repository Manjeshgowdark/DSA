package BackTracking;

public class SudokuSolver {
    public static void main(String[] args) {
       int [][] board = new int [][]{
               {3, 0 ,6, 5, 0, 8, 4, 0, 0},
               {5 ,2, 0, 0, 0, 0, 0, 0, 0},
               {0, 8, 7, 0, 0, 0, 0, 3, 1 },
               {0, 0, 3, 0, 1, 0, 0, 8, 0},
               {9, 0, 0, 8, 6, 3, 0, 0, 5},
               {0 ,5, 0, 0, 9, 0, 6, 0, 0},
               {1 ,3 ,0, 0, 0, 0, 2, 5, 0},
               {0, 0, 0, 0, 0, 0, 0, 7, 4},
               {0, 0, 5, 2, 0, 6, 3, 0, 0}
       };
       if(sudoku(board)){
           display(board);
       }else{
           System.out.println("Can't solve the board");
       }
    }
    public static boolean sudoku(int board[][]){
        for(int i=0;i<board.length;i++){
            for(int j=0; j< board[0].length; j++){
                if(board[i][j] == 0){
                    for(int k= 1 ;k<=9 ;k++){
                        if(isSafe(board, i, j, k)) {
                            board[i][j] = k;

                            if (sudoku(board) == true) {
                                return true;
                            }
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isSafe(int board[][], int row, int col, int k){
        for(int i=0;i<9;i++){
            if(board[row][i] == k){
                return false;
            }
            if(board[i][col] == k){
                return false;
            }
            if(board[3 * (row/3) + row/3][3 * (col/3) + col%3] == k){
                return false;
            }
        }
        return true;
    }
    public static void display( int [][] board){
        for(int[] row: board){
            for(int num : row){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
