package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/10.
 */
public class _62_Unique_Paths {
    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

     The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

     How many possible unique paths are there?


     Above is a 3 x 7 grid. How many possible unique paths are there?

     Note: m and n will be at most 100.
     */

    public static void main(String[] args) {
        int m = 3 ;
        int n = 7 ;

        _62_Unique_Paths unique_paths = new _62_Unique_Paths();
        int work = unique_paths.work(m, n);

        System.out.println("work is: " + work) ;
    }

    public int work(int m, int n) {
        Solution solution = new Solution();
        int i = solution.uniquePaths(m, n);

        return i ;
    }

    class Solution {
        private int rows = -1 ;
        private int cols = -1 ;

        private int[][] dp ;

        public int uniquePaths(int m, int n) {
            rows = m ;
            cols = n ;
            dp = new int[rows][cols] ;

            int go = go(0, 0);
            return go ;
        }

        private int go(int row, int col) {
            if (dp[row][col]!=0) return dp[row][col] ;

            int count = 1 ;
            if (row==rows-1 && col==cols-1) {dp[row][col]=count;  return count ; }

            if (row==rows-1) { return go(row, col+1) ; }
            if (col==cols-1) { return go(row+1, col) ; }

            count = go(row, col+1) + go(row+1, col) ;
            dp[row][col]=count;
            return count ;
        }
    }
}
