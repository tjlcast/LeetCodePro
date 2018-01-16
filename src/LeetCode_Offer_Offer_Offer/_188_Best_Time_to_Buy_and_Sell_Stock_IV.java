package LeetCode_Offer_Offer_Offer;

import sun.applet.Main;

/**
 * Created by tangjialiang on 2017/12/29.
 */
public class _188_Best_Time_to_Buy_and_Sell_Stock_IV {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.

     Design an algorithm to find the maximum profit. You may complete at most k transactions.

     Note:
     You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     */

    public static void main(String[] args) {
        int k = 10 ;
        int[] prices = {1, 2, 3, 4, 5} ;

        Solution solution = new Solution();
        int i = solution.maxProfit(k, prices);

        System.out.println("the work is: " + i);
    }

    static class Solution {

        /**
         * local[i][j]表示，前i天进行了j次交易，并且第i天进行了第j次交易的最大利润，
         * 所以local[i][j]中必然有一次交易，也就是当近一次交易，发生在第i天。
         * (在第i天，进行了第j次的最大盈利量)
         *
         * global[i][j]表示，在第i天时，一共进行了j次的最大盈利量
         *
         * local[i][j] = max(global[i-1][j-1]+max(diff,0), local[i-1][j]+diff)
         * global[i][j] = max(local[i][j], global[i-1][j])
         *
         * @param k
         * @param prices
         * @return
         */
        public int maxProfit(int k, int[] prices) {
            int n = prices.length ;

            // validate input 1
            if (k <= 0 || n == 0) return 0;

            // validate input 2 : if k is large enough, the question will be the same as question II.
            if (k >= n / 2) {
                int result = 0;
                for (int i = 1; i < n; ++i) {
                    if (prices[i] - prices[i - 1] > 0) {
                        result += prices[i] - prices[i - 1];
                    }
                }
                return result;
            }

            if (k <= 0 || n == 0) return 0 ;

            int[][] localProfit = new int[n][k + 1] ;
            int[][] globalProfit = new int[n][k + 1] ;

            for(int j=1; j <= k; j++)
                for(int i=1; i<n; i++) {
                    localProfit[i][j] = Math.max(
                            localProfit[i - 1][j] + prices[i] - prices[i - 1],
                            globalProfit[i - 1][j - 1] + Math.max(0, prices[i]-prices[i-1]) // 如果diff小于零，那就在第i天当天进行一次买卖，凑一次交易的次数，但是产生利润为0.
                    ) ;
                    globalProfit[i][j] = Math.max(localProfit[i][j], globalProfit[i-1][j]) ;
                }

            return globalProfit[n - 1][k] ;
        }
    }

    static class Solution_1 {
        public int maxProfit(int k, int[] prices) {
            int len = prices.length ;

            int[][] t = new int[k+1][len] ;
            for(int i=1; i<=k; i++) {
                int tmpMax = -prices[0] ;
                for(int j=1; j<len; j++) {
                    t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax) ;
                    tmpMax = Math.max(tmpMax, t[i - 1][j - 1] - prices[j]) ;
                }
            }

            return t[k][len - 1] ;
        }
    }
}
