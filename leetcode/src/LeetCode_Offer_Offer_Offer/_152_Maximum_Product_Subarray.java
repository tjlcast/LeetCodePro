package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;

/**
 * Created by tangjialiang on 2017/12/15.
 */
public class _152_Maximum_Product_Subarray {
    /**
     * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

     For example, given the array [2,3,-2,4],
     the contiguous subarray [2,3] has the largest product = 6.
     */

    public static void main(String[] args) {
        int[] nums = {-4, -3} ;

        Solution solution = new Solution();
        int i = solution.maxProduct(nums);

        System.out.println("the work is: " + i);
    }

    static class Solution {
        public int maxProduct(int[] nums) {

            int[] maxLocal = Arrays.copyOf(nums, nums.length) ;
            int[] minLocal = Arrays.copyOf(nums, nums.length) ;
            int maxGlobal = Math.max(maxLocal[0], minLocal[0]) ;

            for(int i=1; i<nums.length; i++) {
                int num = nums[i] ;
                maxLocal[i] = Math.max(Math.max(maxLocal[i-1]*num, minLocal[i-1]*num), num) ;
                minLocal[i] = Math.min(Math.min(maxLocal[i-1]*num, minLocal[i-1]*num), num) ;

                maxGlobal = Math.max(Math.max(maxLocal[i], minLocal[i]), maxGlobal) ;
            }

            return maxGlobal ;
        }
    }
}
