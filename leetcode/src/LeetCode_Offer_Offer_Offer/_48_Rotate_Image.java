package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/5.
 */
public class _48_Rotate_Image {
    /**
     * You are given an n x n 2D matrix representing an image.

     Rotate the image by 90 degrees (clockwise).

     Note:
     You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

     Example 1:

     Given input matrix =
     [
     [1,2,3],
     [4,5,6],
     [7,8,9]
     ],

     rotate the input matrix in-place such that it becomes:
     [
     [7,4,1],
     [8,5,2],
     [9,6,3]
     ]
     Example 2:

     Given input matrix =
     [
     [ 5, 1, 9,11],
     [ 2, 4, 8,10],
     [13, 3, 6, 7],
     [15,14,12,16]
     ],

     rotate the input matrix in-place such that it becomes:
     [
     [15,13, 2, 5],
     [14, 3, 4, 1],
     [12, 6, 8, 9],
     [16, 7,10,11]
     ]
     */

    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}} ;

        _48_Rotate_Image rotate_image = new _48_Rotate_Image();
        rotate_image.work(matrix);

        System.out.println("work is: ") ;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ") ;
            }
            System.out.println() ;
        }
    }

    public void work(int[][] matrix) {
        Solution solution = new Solution();
        solution.rotate(matrix);
    }

    class Solution {
        private int rows = -1 ;
        private int cols = -1 ;
        public void rotate(int[][] matrix) {
            rows = matrix.length ;
            cols = matrix[0].length ;

            // step.1 swap by diagonal
            for(int i=0; i<rows; i++) {
                for(int j=i; j<cols; j++) {
                    int swap = matrix[i][j] ;
                    matrix[i][j] = matrix[j][i] ;
                    matrix[j][i] = swap ;
                }
            }

            // step.2 swap by right and left
            for(int i=0; i<rows; i++) {
                int l = 0 ;
                int r = cols-1 ;
                while(l < r) {
                    int swap = matrix[i][l] ;
                    matrix[i][l] = matrix[i][r] ;
                    matrix[i][r] = swap ;
                    l++; r--;
                }
            }
        }
    }
}
