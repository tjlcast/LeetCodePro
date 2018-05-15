package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18_4Sum {
	public static void main(String[] args) {
		int[] nums = {-3,-2,-1,0,0,1,2,3} ;
		int target = 0 ;
		
		List<List<Integer>> work = new _18_4Sum().work(nums, target) ;
		System.out.println("work is : " + work) ;
	}
	
	public List<List<Integer>> work(int[] nums, int target) {
		return new Solution().fourSum(nums, target) ;
	}
	
	public class Solution {
		ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>() ;
		
	    public List<List<Integer>> fourSum(int[] nums, int target) {
	    	
	    	Arrays.sort(nums);
	    	for(int i=0; i<nums.length-3; i++) {
	    		for(int j=i+1; j<nums.length-2; j++) {
	    			int rest = target - nums[i] - nums[j] ;
	    			findTargetFromArea(nums, i, j, j+1, nums.length-1, rest) ;
	    		}
	    	}
	        return ans ;
	    }
	    
	    public void findTargetFromArea(int[] nums, int i, int j, int b, int e, int target) {
	    	while(b < e) {
	    		int total = nums[b] + nums[e] ;
	    		
	    		if (target == total) {
	    			
	    			// add 
	    			ArrayList<Integer> item = new ArrayList<>() ;
	    			item.add(nums[i]) ; 
	    			item.add(nums[j]) ;
	    			item.add(nums[b]) ;
	    			item.add(nums[e]) ;
	    			
	    			if (!ans.contains(item))ans.add(item) ;
	    			b++ ;
	    			e-- ;
	    			
	    		} else if (target > total){
	    			b++ ;
	    		} else {
	    			e-- ;
	    		}
	    	}
	    }
	}
}
