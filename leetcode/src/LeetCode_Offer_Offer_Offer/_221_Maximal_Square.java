package LeetCode_Offer_Offer_Offer;


import static java.lang.Math.*;

/**
 * Created by tangjialiang on 2018/1/24.
 */
public class _221_Maximal_Square {

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','1','1','1'},
                {'1','1','1','1'},
                {'1','1','1','1'}} ;

        Solution sol = new Solution() ;
        int ans = sol.maximalSquare(matrix) ;

        System.out.println("The work is: " + ans) ;
    }

    static class Solution {
        public int maximalSquare(char[][] matrix) {
            int rows = matrix.length ;
            if (rows==0) return 0 ;
            int cols = matrix[0].length ;
            if (cols==0) return 0 ;
            int dp[][] = new int[rows][cols] ;
            int maxLen = 0 ;

            for(int r=0; r<rows; r++) {
                for(int c=0; c<cols; c++) {
                    if(matrix[r][c] == '1') dp[r][c] = 1 ;
                }
            }

            for(int r=0; r<rows; r++) {
                for(int c=0; c<cols; c++) {
                    if (matrix[r][c] != '1') continue;

                    int len = 0 ;
                    try {
                        len = min(min(dp[r-1][c-1],dp[r-1][c]) , min(dp[r-1][c-1],dp[r][c-1])) ;
                    } catch (Exception e) {
                        len = 0 ;
                    }

                    dp[r][c] = len + 1 ;
                    maxLen = max(maxLen, dp[r][c]) ;
                }
            }

            return maxLen*maxLen ;
        }
    }
}
