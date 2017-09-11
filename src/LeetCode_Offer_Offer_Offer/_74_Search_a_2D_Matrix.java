package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/11.
 */
public class _74_Search_a_2D_Matrix {
    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

     Integers in each row are sorted from left to right.
     The first integer of each row is greater than the last integer of the previous row.
     For example,

     Consider the following matrix:

     [
     [1,   3,  5,  7],
     [10, 11, 16, 20],
     [23, 30, 34, 50]
     ]
     Given target = 3, return true.
     */

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        } ;
        int target = 12 ;

        _74_Search_a_2D_Matrix search_a_2D_matrix = new _74_Search_a_2D_Matrix();
        boolean work = search_a_2D_matrix.work(matrix, target);

        System.out.println("work is: " + work) ;

    }

    public boolean work(int[][] matrix, int target) {
        Solution solution = new Solution();
        boolean b = solution.searchMatrix(matrix, target);
        return b ;
    }

    class Solution {
        private int rows = -1 ;
        private int cols = -1 ;

        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix==null || matrix.length==0) return false ;

            rows = matrix.length ;
            cols = matrix[0].length ;

            boolean b = find(matrix, 0, cols - 1, target);
            return b ;
        }

        public boolean find(int[][] matrix, int row, int col, int target) {
            if (row >= rows || col <0) return false ;

            if (row==rows-1 && col==0 && matrix[row][col]!=target) return false ;

            int num = matrix[row][col];
            if (num == target) return true ;

            if (num < target) {
                return find(matrix, row+1, col, target) ;
            }

            if (num > target) {
                return find(matrix, row, col-1, target) ;
            }

            return false ;
        }
    }
}
