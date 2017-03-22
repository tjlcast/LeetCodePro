package Sum;

public class Solution {
	
	/**
	 * https://leetcode.com/problems/two-sum/#/description
	 * @desc add two num to a target
	 */
	public int[] twoSum(int[] nums, int target) {
		
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if (nums[i]+nums[j] == target) {
					int[] ans = {i, j} ;
					return ans ;
				}
			}
		}
        return null;
    }

}
