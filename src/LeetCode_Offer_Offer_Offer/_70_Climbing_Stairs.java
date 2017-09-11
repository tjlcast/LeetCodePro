package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/11.
 */
public class _70_Climbing_Stairs {
    /**
     * You are climbing a stair case. It takes n steps to reach to the top.

     Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

     Note: Given n will be a positive integer.
     */

    public static void main(String[] args) {
        int n = 2 ;

        _70_Climbing_Stairs climbing_stairs = new _70_Climbing_Stairs();
        int work = climbing_stairs.work(n);

        System.out.println("work is: " + work) ;
    }

    public int work(int n) {
        Solution solution = new Solution();
        int i = solution.climbStairs(n);
        return i ;
    }

    class Solution {
        private int[] dp = null ;

        public int climbStairs(int n) {
            dp = new int[n+1] ;
            int ans = go(n) ;
            return ans ;
        }

        private int go(int n) {
            if (n==1 || n==0) return 1 ;
            if (dp[n]!=0) return dp[n] ;

            dp[n] = go(n-1) + go(n-2) ;
            return dp[n] ;
        }
    }
}
