package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/9.
 */
public class _59_Spiral_II {
    /**
     * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

     For example,
     Given n = 3,

     You should return the following matrix:
     [
     [ 1, 2, 3 ],
     [ 8, 9, 4 ],
     [ 7, 6, 5 ]
     ]

     */

    public static void main(String[] args) {
        int n = 0 ;

        _59_Spiral_II spiral_ii = new _59_Spiral_II();
        int[][] work = spiral_ii.work(n);

        System.out.println("work is: ") ;
        for(int[] line : work) {
            for(int num : line) {
                System.out.print(num + " ") ;
            }
            System.out.println() ;
        }

    }

    public int[][] work(int n) {
        Solution solution = new Solution();
        int[][] ints = solution.generateMatrix(n);
        return ints ;
    }

    class Solution {
        private int[][] matrix = null ;
        private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}} ;
        private int rows = -1 ;
        private int cols = -1 ;
        private int steps = 1 ;

        public int[][] generateMatrix(int n) {
            if (n == 0) {
                return new int[0][] ;
            }

            matrix = new int[n][n] ;
            rows = n ;
            cols = n ;

            go(0, 0, 0) ;

            return matrix ;
        }

        private void go(int row, int col, int direct) {

            matrix[row][col] = steps++ ;

            for(int i=0; i<4; i++) {
                int newRow = row + directions[(direct+i)%4][0] ;
                int newCol = col + directions[(direct+i)%4][1] ;

                if (canGo(newRow, newCol)) {
                    go(newRow, newCol, (direct+i)%4) ;
                    break ;
                }
            }
        }

        private boolean canGo(int row, int col) {
            if (row<0 || row>=rows) return false ;
            if (col<0 || col>=cols) return false ;
            if (matrix[row][col]!=0) return false ;

            return true ;
        }
    }
}
