package ArrayAndString;

import java.util.LinkedList;
import java.util.List;

public class _442_Find_All_Duplicates_in_an_Array {
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1} ;
		List<Integer> work = new _442_Find_All_Duplicates_in_an_Array().work(nums) ;
		for(Integer i : work) {
			System.out.println(i);
		}
	}
	
	public List<Integer> work(int[] nums) {
		return new Solution().findDuplicates(nums) ;
	}
	
	class Solution {
	    public List<Integer> findDuplicates(int[] nums) {
	    	
	    	LinkedList<Integer> ans = new LinkedList<Integer>() ;
	        
	        for(int i=0; i<nums.length; i++) {
	        	while(nums[i] != (i+1)) {
	        		int curPos = nums[i]-1 ;
	        		if (nums[curPos] == curPos+1) {
	        			if (!ans.contains(curPos+1))ans.add(curPos+1) ;
	        			break ;
	        		} ;
	        		// swap 
	        		int temp = nums[i] ;
	        		nums[i] = nums[curPos] ;
	        		nums[curPos] = temp ;
	        	}
	        }
	       
	        return ans ;
	    }
	}
}
