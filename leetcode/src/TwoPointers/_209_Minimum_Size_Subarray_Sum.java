package TwoPointers;

public class _209_Minimum_Size_Subarray_Sum {

	public static void main(String[] args) {
		int s = 2 ;
		int[] nums = {1, 2, 3} ;
		
		int work = new _209_Minimum_Size_Subarray_Sum().work(s, nums) ;
		System.out.println("work :" + work) ;
	}
	
	public int work(int s, int[] nums) {
		return new Solution().minSubArrayLen(s, nums) ;
	}
	
	public class Solution {
	    public int minSubArrayLen(int s, int[] nums) {
	        int nextNum = 0 ;
	        int[] dp = new int[nums.length] ;
	        
	        
	        while(nextNum < nums.length) {
	            for(int i=0; i<dp.length; i++) if (i+nextNum < nums.length)dp[i] += nums[i+nextNum] ;
	            
	            for(int i=0; i<dp.length; i++) {
	                if (dp[i] >= s) return (nextNum+1) ;
	            }
	            nextNum++ ;
	        }
	        
	        return 0 ;
	    }
	}

}
