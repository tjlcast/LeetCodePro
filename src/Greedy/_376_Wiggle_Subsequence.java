package Greedy;

import java.util.ArrayList;

public class _376_Wiggle_Subsequence {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 1};

		int res = new _376_Wiggle_Subsequence().work(nums);
		System.out.println("res: " + res);
	}

	int work(int[] nums) {
		return new Solution().wiggleMaxLength(nums);
	}

	public class Solution {
		public int wiggleMaxLength(int[] nums) {
	    	
	    	// less or equal to 1 
	    	if (nums.length <= 1) return nums.length ;
	    	
	    	// bigger than 1
	    	int count = 1 ;
	    	ArrayList<Integer> diffs = new ArrayList<Integer>() ;
	    	for(int i=1; i<nums.length; i++) {
	    		if (nums[i] - nums[i-1]!=0)diffs.add(nums[i] - nums[i-1]) ;
	    	}
	    	
	    	if (diffs.size()==0) return 1 ;
	    	
	    	for(int i=1; i<diffs.size(); i++) {
	    		if (diffs.get(i-1)*diffs.get(i) < 0) count++ ; 
	    	}
	    		
	        return count+1;
	    }
	}
}
