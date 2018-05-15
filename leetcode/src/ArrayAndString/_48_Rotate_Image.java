package ArrayAndString;

/**
 * Created by tangjialiang on 2017/5/31.
 */
public class _48_Rotate_Image {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}} ;
        new _48_Rotate_Image().work(matrix);
    }

    public void work(int[][] matrix) {
        new Solution().rotate(matrix);
    }

    public class Solution {
        public void rotate(int[][] matrix) {
            // swap from horizontal
            for(int i=0; i<matrix.length/2; i++) {
                for(int j=0; j<matrix[0].length; j++) {
                    int temp = matrix[i][j] ;
                    matrix[i][j] = matrix[matrix.length-i-1][j] ;
                    matrix[matrix.length-i-1][j] = temp ;
                }
            }

            // swap from diagonal
            for (int i=0; i<matrix.length; i++) {
                for (int j=0; j<matrix[0].length; j++) {
                    if (i>j) {
                        int temp = matrix[i][j] ;
                        matrix[i][j] = matrix[j][i] ;
                        matrix[j][i] = temp ;
                    }
                }
            }

            return  ;
        }
    }
}
