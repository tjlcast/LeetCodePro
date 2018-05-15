package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/11/18.
 *
 */
public class _123_Best_Time_to_Buy_and_Sell_Stock_III {

    class Solution {
        public int maxProfit(int[] prices) {

            int len = prices.length ;
            int[] former = new int[len] ;
            int[] laster = new int[len] ;

            int count = 0 ;
            int lastPrice = Integer.MAX_VALUE ;
            for(int i=0; i<prices.length; i++) {
                int price = prices[i] ;
                if (lastPrice > price) {
                    lastPrice = price ;
                } else {
                    count = Math.max(count, price - lastPrice) ;
                }
                former[i] = count ;
            }

            count = 0 ;
            int prePrice = 0 ;
            for(int i=prices.length-1; i>=0; i--) {
                int price = prices[i] ;
                if (price >= prePrice) {
                    prePrice = price ;
                } else {
                    count = Math.max(count, prePrice - price) ;
                }
                laster[i] = count ;
            }

            int ans = 0 ;
            for(int i=0; i<prices.length; i++) {
                ans = Math.max(ans, former[i]+laster[i]) ;
            }

            return ans ;
        }
    }
}
