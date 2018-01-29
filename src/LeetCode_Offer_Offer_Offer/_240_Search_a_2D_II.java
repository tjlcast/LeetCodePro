package LeetCode_Offer_Offer_Offer;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/1/29.
 */
public class _240_Search_a_2D_II {
    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

     Integers in each row are sorted in ascending from left to right.
     Integers in each column are sorted in ascending from top to bottom.
     For example,

     Consider the following matrix:

     [
     [1,   4,  7, 11, 15],
     [2,   5,  8, 12, 19],
     [3,   6,  9, 16, 22],
     [10, 13, 14, 17, 24],
     [18, 21, 23, 26, 30]
     ]
     Given target = 5, return true.

     Given target = 20, return false.
     */

    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        } ;
        int target = 21 ;

        Solution sol = new Solution() ;
        boolean b = sol.searchMatrix(matrix, target);

        System.out.println("The work is: " + b) ;

    }

    /**
     *

     对于某个元素x有以下性质(+大于当前，-小于当前)

     ------
     ------
     -----x+++++++
          ++++++++
          ++++++++
     */
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int rows = 0 ;
            int cols = 0 ;
            try {
                rows = matrix.length ;
                cols = matrix[0].length ;
            } catch (Exception e) {
                return false ;
            }

            int row = 0;
            int col = cols-1;

            while(row<rows && col>=0) {
                int num = matrix[row][col] ;
                if (num < target) row++ ;
                else if (num > target) col-- ;
                else return true ;
            }

            return false ;
        }
    }
}
