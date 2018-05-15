package ArrayAndString;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/8/8.
 */
public class _54_Spiral_Matrix {
    public static void main(String[] args) {

    }

    public List<Integer> work(int[][] matrix) {
        return new Solution().spiralOrder(matrix) ;
    }

    public class Solution {

        boolean[][] flag = null ;
        int[][] matrix = null ;
        List<Integer> ansList = new LinkedList<>() ;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}} ;
        int rows = -1 ;
        int cols = -1 ;

        void preStart(int[][] matrix) {
            this.matrix = matrix ;
            rows = matrix.length ;
            cols = matrix[0].length ;

            flag = new boolean[rows][cols] ;

            for(int i=0; i<rows; i++)
                for(int j=0; j<cols; j++)
                    flag[i][j] = false ;
        }

        void dfs(int row, int col, int dir) {
            // row and col position must be useful

            int val = matrix[row][col] ;
            ansList.add(val) ;
            flag[row][col] = true ;

            int newRow = row + directions[dir][0] ;
            int newCol = col + directions[dir][1] ;
            int oldDir = dir ;
            while (!((0<=newRow&&newRow<rows) && (0<=newCol&&newCol<cols) && (!flag[newRow][newCol]))){
                dir = (dir + 1) % 4 ;
                newRow = row + directions[dir][0] ;
                newCol = col + directions[dir][1] ;
                if (oldDir == dir) return ;
            }

            dfs(newRow, newCol, dir) ;

        }

        public List<Integer> spiralOrder(int[][] matrix) {
            try {
                preStart(matrix) ;
            } catch(Exception e) {
                return ansList ;
            }

            dfs(0, 0, 0) ;
            return ansList ;
        }


    }
}
