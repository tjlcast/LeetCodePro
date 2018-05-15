package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/10.
 */
public class _63_Unique_Paths_II {
    /**
     * Follow up for "Unique Paths":

     Now consider if some obstacles are added to the grids. How many unique paths would there be?

     An obstacle and empty space is marked as 1 and 0 respectively in the grid.

     For example,
     There is one obstacle in the middle of a 3x3 grid as illustrated below.

     [
     [0,0,0],
     [0,1,0],
     [0,0,0]
     ]
     The total number of unique paths is 2.

     Note: m and n will be at most 100.


     */

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        } ;

        _63_Unique_Paths_II unique_paths_ii = new _63_Unique_Paths_II();
        int work = unique_paths_ii.work(grid);

        System.out.println("work is: " + work) ;
    }

    public int work(int[][] obstacleGrid) {
        Solution solution = new Solution();
        int i = solution.uniquePathsWithObstacles(obstacleGrid);

        return i ;
    }

    class Solution {
        /**
         * assume the (0, 0) position must not be obstacle.
         */
        private int[][] grid = null ;
        private int[][] dp = null ;
        private int rows = -1 ;
        private int cols = -1 ;

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            //obstacleGrid must have a row
            int ans = 0;
            int row_len = obstacleGrid[0].length ;
            int[] row = new int[row_len+1] ;

            row[0] = 0 ;
            for(int i=1; i<=row_len; i++) {
                if(obstacleGrid[0][i-1] == 0) {
                    row[i] = 1 ;
                } else {
                    for(; i<=row_len; i++) {
                        row[i] = 0 ;
                    }
                }
            }


            for(int i=2; i<=obstacleGrid.length; i++) {
                for(int j=1; j<=row_len; j++) {
                    row[j] = row[j] + row[j-1] ;
                    if(obstacleGrid[i-1][j-1] == 1) {
                        row[j] = 0 ;
                    }
                }
            }


            ans = row[row_len];

            return ans ;
        }
    }
}
