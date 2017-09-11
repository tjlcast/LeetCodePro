package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/10.
 */
public class _64_Minimum_Path_Sum {
    /**
     * Given a m x n grid filled with non-negative numbers,
     * find a path from top left to bottom right which minimizes the sum of all numbers along its path.

     Note: You can only move either down or right at any point in time
     */

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3},
                {3, 2, 1},
                {3, 1, 2},
        } ;

        _64_Minimum_Path_Sum minimum_path_sum = new _64_Minimum_Path_Sum();
        int work = minimum_path_sum.work(grid);

        System.out.println("work is: " + work) ;
    }

    public int work(int[][] grid) {
        Solution solution = new Solution();
        int i = solution.minPathSum(grid);

        return i;
    }

    class Solution {

        int[][] grid = null ;
        int[][] dp = null ;
        int rows = -1 ;
        int cols = -1 ;

        public int minPathSum(int[][] grid) {
            try {
                this.grid = grid ;
                rows = grid.length ;
                cols = grid[0].length ;
                dp = new int[rows][cols] ;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e) ;
                return 0 ;
            }

            int ans = getLastMinSum(0, 0) ;
            return ans ;
        }

        private int getLastMinSum(int row, int col) {
            if (dp[row][col] != 0) return dp[row][col] ;

            if (row==rows-1 && col==cols-1) return grid[row][col] ;

            if (row == rows-1) { dp[row][col] =  grid[row][col] + getLastMinSum(row, col+1); return dp[row][col]; }
            if (col == cols-1) { dp[row][col] =  grid[row][col] + getLastMinSum(row+1, col); return dp[row][col]; }

            dp[row][col] = grid[row][col] + Math.min(getLastMinSum(row+1, col) , getLastMinSum(row, col+1)) ;
            return dp[row][col] ;
        }
    }
}
