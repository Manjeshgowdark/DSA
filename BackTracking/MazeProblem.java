package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class MazeProblem {
    public static void main(String[] args) {
//        System.out.println(maze(3,3));
//        path("",3,3);
//        System.out.println(Diagonal("",3,3));
        boolean [][] maze = {
                {true,true,true},
                {true,false, true},
                {true, true, true}
        };
        pathRestrictions("",maze, 0,0);
    }
    static int maze(int row, int col){
        if(row == 1 || col == 1){
            return 1;
        }
        int left = maze(row - 1, col);
        int right = maze(row, col - 1);
        return left + right;
    }
    static void path(String p , int r, int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(r > 1){
            path(p + 'D',r-1, c);
        }
        if(c > 1){
            path(p + 'R', r, c-1);
        }
    }
    static ArrayList<String> Diagonal(String p , int r, int c){
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(r>1 && c>1){

            list.addAll(Diagonal(p+'D',r-1,c-1));
        }
        if(r > 1){
            list.addAll(Diagonal(p+'V', r-1, c));
        }
        if(c > 1){
            list.addAll(Diagonal(p + 'H', r, c-1));
        }
        return list;
    }
    static void pathRestrictions(String p ,boolean[][] maze, int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r < maze.length-1){
            pathRestrictions(p + "D", maze, r + 1, c);
        }
        if(c < maze[0].length-1){
            pathRestrictions(p + "R", maze, r, c+1);
        }
    }
}
