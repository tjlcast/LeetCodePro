package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;

/**
 * Created by tangjialiang on 2018/1/22.
 */
public class _213_House_Robber_II {
    /**
     * After robbing those houses on that street,
     * the thief has found himself a new place for his thievery so that he will not get too much attention.
     * This time, all houses at this place are arranged in a circle.
     * That means the first house is the neighbor of the last one.
     * Meanwhile, the security system for these houses remain the same as for those in the previous street.

     Given a list of non-negative integers representing the amount of money of each house,
     determine the maximum amount of money you can rob tonight without alerting the police.
     * @param args
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4} ;

        Solution solution = new Solution();
        int rob = solution.rob(nums);

        System.out.println("The work is: " + rob) ;
    }

    static class Solution {
        public int rob(int[] nums) {
            if (nums==null || nums.length==0) return 0 ;
            if (nums.length == 1) return nums[0] ;

            int ans1 = work(Arrays.copyOfRange(nums, 1, nums.length)) ;
            int ans2 = work(Arrays.copyOfRange(nums, 0, nums.length-1)) ;
            return Math.max(ans1, ans2) ;
        }

        public int work(int[] nums) {
            int ans = 0 ;
            int n = nums.length;
            if (n==0) return 0 ;
            if (n==1) return nums[0] ;
            if (n==2) return Math.max(nums[0], nums[1]) ;
            int[] local = new int[n] ;

            // init
            local[0] = nums[0] ;
            local[1] = Math.max(nums[0], nums[1]) ;

            for(int i=2; i<n; i++) {
                local[i] = Math.max(local[i-1], local[i-2]+nums[i]) ;
            }
            return local[n-1] ;
        }
    }
}
