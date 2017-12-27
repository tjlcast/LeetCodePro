package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;

/**
 * Created by tangjialiang on 2017/12/27.
 */
public class _169_Majority_Element {
    /**
     * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

     You may assume that the array is non-empty and the majority element always exist in the array.
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 2, 3, 4} ;

        Solution solution = new Solution();
        int i = solution.majorityElement(nums);

        System.out.println("the work is: " + i) ;
    }

    static class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[(0+nums.length)/2] ;
        }
    }
}
