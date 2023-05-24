import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;

public class BackTracking2 {
    public static void main(String[] args){
//        System.out.println(count(4,4));
//        print("", 3,3);
//        System.out.println(printlist("",3,3));
//        System.out.println(printlistDiagonal("",3,3));
//        boolean[][] matrix = {
//                {true,true,true},
//                {true,true,true},
//                {true,true,true}
//        };
////            pathRestriction("",matrix, 0,0);
//        int[][] path = new int[matrix.length][matrix[0].length];
//        AllPathPrint("",matrix, 0,0,path, 1);
        int n = 8;
        boolean[][] board = new boolean[n][n];
        System.out.println(queen(board,0));
    }
    static int count(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }
        int left = count(r-1, c);
        int right = count(r, c-1);
        return left + right;
    }
    static void print(String p, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(p);
        }
        if(r > 1){
            print(p+"D",r-1,c);
        }
        if(c > 1){
            print(p+"R",r,c-1);
        }
    }
    static ArrayList<String> printlist(String p,int r, int c){
        if(r== 1 && c == 1){
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<String>();
        if(r > 1){
            list.addAll(printlist(p+"D", r-1,c));
        }
        if(c > 1){
            list.addAll(printlist(p+"R", r,c-1)) ;
        }
        return list;
    }
    static ArrayList<String> printlistDiagonal(String p, int r, int c){
        if(r==1 && c == 1){
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<String>();
        if(r > 1 && c > 1){
            list.addAll(printlistDiagonal(p+"D",r-1,c-1));
        }
        if(r > 1){
            list.addAll(printlistDiagonal(p+"V",r-1,c));
        }
        if( c > 1){
            list.addAll(printlistDiagonal(p+"H",r,c-1));
        }
        return list;
    }
    static void pathRestriction(String p, boolean[][] matrix, int r, int c){
        if(r == matrix.length - 1 && c == matrix[0].length - 1){
            System.out.println(p);
            return;
        }
        if(!matrix[r][c]){
            return;
        }
        if(r < matrix.length-1){
            pathRestriction(p+"D",matrix,r+1,c);
        }
        if(c < matrix[0].length-1){
            pathRestriction(p+"R",matrix,r,c+1);
        }
    }
    static void AllPaths(String p, boolean[][] matrix, int r, int c){
        if(r == matrix.length - 1 && c == matrix[0].length - 1){
            System.out.println(p);
            return;
        }
        if(!matrix[r][c]){
            return;
        }
        matrix[r][c] = false;
        if(r < matrix.length-1){
            AllPaths(p+"D",matrix,r+1,c);
        }
        if(c < matrix[0].length-1){
            AllPaths(p+"R",matrix,r,c+1);
        }
        if(r > 0){
            AllPaths(p+"U",matrix,r-1,c);
        }
        if(c > 0) {
            AllPaths(p + "L", matrix, r, c - 1);
        }
        matrix[r][c] =true;
    }
    static void AllPathPrint(String p, boolean[][] matrix, int r, int c, int [][] path, int step){

        if(r == matrix.length - 1 && c == matrix[0].length - 1){
            path[r][c] = step;
            for(int[] arr: path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!matrix[r][c]){
            return;
        }
        path[r][c] = step;
        matrix[r][c] = false;
        if(r < matrix.length-1){
            AllPathPrint(p+"D",matrix,r+1,c,path,step+1);
        }
        if(c < matrix[0].length-1){
            AllPathPrint(p+"R",matrix,r,c+1,path,step+1);
        }
        if(r > 0){
            AllPathPrint(p+"U",matrix,r-1,c,path,step+1);
        }
        if(c > 0) {
            AllPathPrint(p + "L", matrix, r, c - 1,path,step+1);
        }
        matrix[r][c] =true;
        path[r][c] = 0;
    }
    static int queen(boolean[][] board , int row){
        if(row == board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        //placing the queen and checking for every row and col
        for(int col=0;col< board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col] = true;
                count += queen(board, row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //check vertical row
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }
        // diagonal left
        int maxleft = Math.min(row,col);
        for(int i=1; i<= maxleft; i++){
            if(board[row-i][col-i]){
                return false;
            }
        }
        int maxRight = Math.min(row, board.length-col-1);
        for(int i=1; i<= maxRight; i++){
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row: board){
            for(boolean element: row){
                if(element){
                    System.out.print("Q"+" ");
                }else{
                    System.out.print("X"+" ");
                }
            }
            System.out.println();
        }
    }
}
