package DynamicProgramming;

public class _121_Best_Time_to_Buy_and_Sell_Stock {
	
	public static void main(String[] args) {
		int prices[] = {7, 1, 5, 3, 6, 4} ;
		int profit = new _121_Best_Time_to_Buy_and_Sell_Stock().work(prices) ;
		System.out.println("profit is: " + profit);
	}
	
	public int work(int[] prices) {
		return new Solution().maxProfit(prices) ;
	}
	
	public class Solution {
	    public int maxProfit(int[] prices) {
	        int profit = 0 ;
	        if (prices.length==0) return profit ;
	        int min = prices[0] ;
	        
	        for(int i=0; i<prices.length; i++) {
	            profit = Math.max(profit, prices[i]-min) ;
	            min = Math.min(min, prices[i]) ;
	        }
	        
	        return profit ;
	    }
	}
}
