package ArrayAndString;

public class _238_Product_of_Array_Except_Self {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4} ;
		int[] work = new _238_Product_of_Array_Except_Self().work(nums) ;
		for(int i=0; i<nums.length; i++) {
			System.out.println("work is: " + work[i]) ;
		}
	}
	
	public int[] work(int[] nums) {
		return new Solution().productExceptSelf(nums) ;
	}
	
	public class Solution {
	    public int[] productExceptSelf(int[] nums) {
	    	int[] bR = new int[nums.length+2] ;
	    	int[] bL = new int[nums.length+2] ;
	    	
	    	// before left
	    	int total = 1 ;
	    	for(int i=1; i<=nums.length; i++) {
	    		bR[i] = total ;
	    		total *= nums[i-1] ;
	    	}
	    	
	    	// to left 
	    	total = 1 ;
	    	for(int i=nums.length; i>=1; i--) {
	    		bL[i] = total ;
	    		total *= nums[i-1] ;
	    	}
	    	
	    	for(int i=0; i<nums.length; i++) {
	    		nums[i] = (bR[i+1])*(bL[i+1]) ;
	    	}
	    	
	    	return nums ;
	    }
	}
}
