package ArrayAndString;

public class _283_Move_Zeroes {
	public static void main(String[] args) {
		int[] nums = {0, 1} ;
		new _283_Move_Zeroes().work(nums); 
		
		System.out.println(nums);
		
	}
	
	public void work(int[] nums) {
		new Solution().moveZeroes(nums);
	}
	
	public class Solution {
	    public void moveZeroes(int[] nums) {
	        int noZeroPos = nums.length - 1 ;
	        while(noZeroPos>=0 && nums[noZeroPos]==0) { noZeroPos--; }
	        
	        for(int i=nums.length-2; i>=0; i--) {
	            if (nums[i]==0) {
	                int curPos = i+1 ;
	                while(curPos<nums.length) {
	                    nums[curPos-1] = nums[curPos] ;
	                    curPos++ ;
	                }
	                nums[nums.length-1] = 0 ;
	            }
	        }
	    }
	}
}
