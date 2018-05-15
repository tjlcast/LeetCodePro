package DynamicProgramming;

import static java.lang.Math.min ;

/**
 * Created by tangjialiang on 2018/4/15.
 */
public class _64_Minimum_Path_Sum {

    static class Solution {
        int[][] matrix ;
        int rows ;
        int cols ;

        public int minPathSum(int[][] grid) {
            matrix = grid ;
            rows = grid.length ;
            cols = grid[0].length ;

            // init
            int[][] dp = new int[rows][cols] ;
            dp[0][0] = matrix[0][0] ;
            for (int i = 1; i < rows; i++) {
                dp[i][0] = dp[i-1][0] + matrix[i][0] ;
            }
            for (int i = 1; i < cols; i++) {
                dp[0][i] = dp[0][i-1] + matrix[0][i] ;
            }

            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < cols; j++) {
                    int topVal = dp[i-1][j] ;
                    int leftVal = dp[i][j-1] ;
                    dp[i][j] = min(topVal, leftVal) + matrix[i][j] ;
                }
            }

            return dp[rows-1][cols-1] ;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        } ;

        Solution sol = new Solution() ;
        int i = sol.minPathSum(grid);

        System.out.println(i);
    }
}
