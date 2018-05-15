package ArrayAndString;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class _448_Find_All_Numbers_Disappeared_in_an_Array {

	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1} ;
		List<Integer> work = new _448_Find_All_Numbers_Disappeared_in_an_Array().work(nums) ;
		for(Integer i: work) {
			System.out.println(i);
		}
	}
	
	public List<Integer> work(int[] nums) {
		return new Solution().findDisappearedNumbers(nums) ;
	}
	
	class Solution {
	    public List<Integer> findDisappearedNumbers(int[] nums) {
	    	LinkedList<Integer> ans = new LinkedList<Integer>() ;
	    	
	        for(int i=0; i<nums.length; i++) {
	        	while(nums[i] != i+1) {
	        		int toPos = nums[i] ;
	        		// 处理已经出现两次的数据
	        		if (nums[toPos-1] == toPos) {
	        			break ;
	        		}
	        		int temp = nums[i] ;
	        		nums[i] = nums[toPos-1] ;
	        		nums[toPos-1] = temp ;
	        	}
	        }
	        
	        for(int i=0; i<nums.length; i++) {
	        	if (nums[i] != (i+1)) {
	        		ans.add(i+1) ;
	        	}
	        }
	        return ans ;
	    }
	}
	
	class Solution_Bad_Space {
	    public List<Integer> findDisappearedNumbers(int[] nums) {
	        TreeSet<Integer> recorder = new TreeSet<Integer>() ;
	        ArrayList<Integer> ans = new ArrayList<Integer>() ;
	        
	        for(int i=0; i<nums.length; i++) {
	            recorder.add(nums[i]) ;
	        }
	        
	        for(int i=1; i<=nums.length; i++) {
	            if (!recorder.contains(i)) ans.add(i) ;
	        }
	        
	        return ans ;
	    }
	}
}
