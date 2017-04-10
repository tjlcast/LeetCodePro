package ArrayAndString;

public class _268_Missing_Number {

	public static void main(String[] args) {
		int[] nums = {0, 1, 3} ;
		int work = new _268_Missing_Number().work(nums) ;
		System.out.println("work is : " + work) ;
	}
	
	public int work(int[] nums) {
		return new Solution().missingNumber(nums) ;
	}
	
	public class Solution {
	    public int missingNumber(int[] nums) {
	    	int n = nums.length + 1 ;
	    	int count = 0 ;
	    	
	    	for(int i=0; i<n; i++) {
	    		count +=i ;
	    	}
	    	
	    	for(int i=0; i<nums.length; i++) {
	    		count -= nums[i] ;
	    	}
	    	
	        return count ;
	    }
	}
}	
