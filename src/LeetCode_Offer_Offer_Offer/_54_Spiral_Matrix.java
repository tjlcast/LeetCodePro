package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/7.
 */
public class _54_Spiral_Matrix {
    /**
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

     For example,
     Given the following matrix:

     [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
     ]
     You should return [1,2,3,6,9,8,7,4,5].
     */
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        _54_Spiral_Matrix spiral_matrix = new _54_Spiral_Matrix();
        List<Integer> work = spiral_matrix.work(matrix);

        System.out.println("work is: ") ;
        for(Integer i : work) {
            System.out.println(i) ;
        }
    }


    public List<Integer> work(int[][] matrix) {
        Solution solution = new Solution();
        List<Integer> integers = solution.spiralOrder(matrix);

        return integers ;
    }

    class Solution {

        private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}} ;
        private List<Integer> ansList = new LinkedList<>() ;
        private int rows = -1 ;
        private int cols = -1 ;

        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix==null || matrix.length==0) return ansList ;

            rows = matrix.length ;
            cols = matrix[0].length ;

            go(0, 0, matrix, 0) ;

            return ansList ;
        }

        private void go(int row, int col, int[][] matrix, int d) {
            // row and col must be invalid
            ansList.add(matrix[row][col]) ;
            matrix[row][col] = Integer.MAX_VALUE ;

            for(int i=0; i<4; i++) {
                int newRow = row + directions[(d+i)%directions.length][0] ;
                int newCol = col + directions[(d+i)%directions.length][1] ;
                if (isPositionInvalid(newRow, newCol, matrix)) go(newRow, newCol, matrix, (d+i)%directions.length);
            }


        }

        private boolean isPositionInvalid(int row, int col, int[][] matrix) {
            if (row < 0 || row>=rows) return false ;
            if (col < 0 || col>=cols) return false ;
            if (matrix[row][col] == Integer.MAX_VALUE) return false ;

            return true ;
        }
    }
}
