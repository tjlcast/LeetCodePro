package Greedy;


public class _122_Best_Time_to_Buy_and_Sell_Stock_II {

	public static void main(String[] args) {
		int prices[] = {7, 1, 5, 3, 6, 4} ;
		int profit = new _122_Best_Time_to_Buy_and_Sell_Stock_II().work(prices) ;
		System.out.println("profit is: " + profit);

	}
	
	public int work(int[] prices) {
		return new Solution().maxProfit(prices) ;
	}
	
	public class Solution {
	    public int maxProfit(int[] prices) {
	        int profit = 0 ;
	        if (prices.length <= 1) return 0 ;
	        
	        for(int i=0; i<prices.length-1; i++) {
	        	int p = prices[i+1] - prices[i] ;
	        	if (p > 0) profit += p ;
	        }
	        
	        return profit ;
	    }
	}

}
