package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/11.
 */
public class _73_Set_Matrix_Zeroes {
    /**
     * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

     click to show follow up.

     Follow up:
     Did you use extra space?
     A straight forward solution using O(mn) space is probably a bad idea.
     A simple improvement uses O(m + n) space, but still not the best solution.
     Could you devise a constant space solution?
     */

    public static void main(String[] args) {
        int[][] matrix = {
                {0,0,0,5},
                {4,3,1,4},
                {0,1,1,4},
                {1,2,1,3},
                {0,0,1,1}
        } ;

        _73_Set_Matrix_Zeroes set_matrix_zeroes = new _73_Set_Matrix_Zeroes();
        set_matrix_zeroes.work(matrix);

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ") ;
            }
            System.out.println() ;
        }
    }

    public void work(int[][] matrix) {
        Solution solution = new Solution();
        solution.setZeroes(matrix);

        return ;
    }


    class Solution {
        private int rows = -1 ;
        private int cols = -1 ;

        public void setZeroes(int[][] matrix) {
            rows = matrix.length ;
            cols = matrix[0].length ;

            boolean firstRowIsZero = false ;
            boolean firstColIsZero = false ;

            for(int i=0; i<rows; i++)
                if (matrix[i][0] == 0) {
                    firstColIsZero = true;
                    break ;
                }

            for(int j=0; j<cols; j++)
                if(matrix[0][j] == 0) {
                    firstRowIsZero = true;
                    break ;
                }

            for(int i=1; i<rows; i++) {
                for(int j=1; j<cols; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0 ;
                        matrix[0][j] = 0 ;
                    }
                }
            }


            for(int i=1; i<rows; i++) {
                for(int j=1; j<cols; j++) {
                    if (matrix[i][0]==0 || matrix[0][j]==0) {
                        matrix[i][j] = 0 ;
                    }
                }
            }


            if (firstColIsZero) {
                for(int i=0; i<rows; i++) matrix[i][0] = 0 ;
            }

            if (firstRowIsZero) {
                for(int j=0; j<cols; j++) matrix[0][j] = 0 ;
            }
        }
    }
}
