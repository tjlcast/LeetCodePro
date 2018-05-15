package LeetCode_Offer_Offer_Offer;

import static java.lang.Math.min;

/**
 * Created by tangjialiang on 2018/1/21.
 */
public class _209_Minimum_Size_Subarray_Sum {
    /**
     * Given an array of n positive integers and a positive integer s,
     * find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

     For example, given the array [2,3,1,2,4,3] and s = 7,
     the subarray [4,3] has the minimal length under the problem constraint.
     * @param args
     */

    public static void main(String[] args) {
        int s = 7 ;
        int[] nums = {2,3,1,2,4,3} ;

        Solution solution = new Solution();
        int i = solution.minSubArrayLen(s, nums);

        System.out.println("The work is: " + i) ;
    }

    static class Solution {

        public int minSubArrayLen(int s, int[] nums) {
            int begin = 0 ;
            int end = 0 ;
            int total = 0 ;
            int minLen = Integer.MAX_VALUE ;

            while(end < nums.length) {
                total += nums[end++] ;

                while(total >= s) {
                    minLen = Math.min(minLen, end-begin) ;
                    total -= nums[begin++] ;
                }
            }

            return (minLen==Integer.MAX_VALUE)?(0):(minLen) ;
        }


    }
}
