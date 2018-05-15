package ArrayAndString;


public class _485_Max_Consecutive_Ones {

	public static void main(String[] args) {
		int[] nums = {1,1,0,1} ;
		int work = new _485_Max_Consecutive_Ones().work(nums) ;
		System.out.println("the work result is " + work);
	}
	
	public int work(int[] nums) {
		return new Solution().findMaxConsecutiveOnes(nums);
	}
	
	class Solution {
	    public int findMaxConsecutiveOnes(int[] nums) {
	        int ans = 0 ;
	        
	        int pos = -1 ;
	        for(int i=0; i<nums.length; i++) {
	            if (nums[i]==0) {
	                pos = i ;
	            } else {
	                ans = Math.max(ans, i-pos) ;
	            }
	        }
	        
	        return ans ;
	    }
	}
}
