package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/11/18.
 */
public class _121_Best_Time_to_Buy_and_Sell_Stock {

    class Solution {
        public int maxProfit(int[] prices) {
            int ans = 0 ;

            // Sol.1 O(n*n)
            // for(int i=0; i<prices.length; i++) {
            //     for(int j=i+1; j<prices.length; j++) {
            //         ans = Math.max(ans, prices[j] - prices[i]) ;
            //     }
            // }


            // Sol.2 O(n)
            int lastP = Integer.MAX_VALUE ;
            for(int i=0; i<prices.length; i++) {
                if (lastP >= prices[i]) {
                    lastP = prices[i] ;
                }
                ans = Math.max(ans, prices[i]-lastP) ;
            }

            return ans ;
        }
    }
}
