package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;

/**
 * Created by tangjialiang on 2017/9/2.
 */
public class _16_3Sum_Closest {
    /**
     * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

     For example, given array S = {-1 2 1 -4}, and target = 1.

     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4} ;
        int target = -3 ;

        _16_3Sum_Closest sum_closest = new _16_3Sum_Closest();
        int work = sum_closest.work(nums, target);
        System.out.println("work is: " + work) ;
    }

    public int work(int[] nums, int target) {
        Solution solution = new Solution();
        int i = solution.threeSumClosest(nums, target);
        return i ;
    }

    class Solution {

        int ansTotal = Integer.MAX_VALUE ;
        int ansDist = Integer.MAX_VALUE ;

        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);

            for(int i=0; i<nums.length-2; i++) {
                int l = i + 1 ;
                int r = nums.length - 1 ;

                while(l < r) {
                    int tempTotal = nums[i] + nums[l] + nums[r] ;
                    if (Math.abs(target - tempTotal) < ansDist) {
                        ansDist = Math.abs(target - tempTotal) ;
                        ansTotal = tempTotal ;
                    }

                    if (target == nums[i] + nums[l] + nums[r]) {
                        break ;
                    } else if (target < nums[i] + nums[l] + nums[r]) {
                        r-- ;
                    } else {
                        l++ ;
                    }
                }
            }

            return ansTotal ;
        }
    }
}
