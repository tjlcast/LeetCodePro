package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/11/18.
 */
public class _122_Best_Time_to_Buy_and_Sell_Stock_II {

    class Solution {
        public int maxProfit(int[] prices) {
            int total = 0 ;

            for (int i=0; i<prices.length; i++) {
                int price = prices[i] ;

                if (i!=prices.length-1) {
                    int nextPrice = prices[i+1] ;
                    if (nextPrice > price) {
                        total += (nextPrice - price) ;
                    }
                }
            }

            return total ;
        }
    }
}
