package DynamicProgramming;

import java.util.Arrays;

/**
 * Created by tangjialiang on 2018/4/15.
 */
public class _279_Perfect_Squares {

    static class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1] ;
            Arrays.fill(dp, Integer.MAX_VALUE) ;
            dp[0] = 0 ;

            for (int i=1; i<=n; i++) {
                int j = 1 ;
                while (i >= j*j) {
                    dp[i] = Math.min(dp[i], dp[i - j*j] + 1) ;
                    j++ ;
                }
            }

            return dp[n] ;
        }
    }

    public static void main(String[] args) {
        int n = 12 ;

        Solution solution = new Solution();
        int i = solution.numSquares(n);
        
        System.out.println(i) ;
    }
}
