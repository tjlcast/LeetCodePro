package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;

/**
 * Created by tangjialiang on 2017/12/20.
 */
public class _164_Maximum_Gap {
    /**
     * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

     Try to solve it in linear time/space.

     Return 0 if the array contains less than 2 elements.

     You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
     * @param args
     */

    public static void main(String[] args) {
        int[] nums = {} ;

        Solution solution = new Solution();
        int i = solution.maximumGap(nums);

        System.out.println("the work is: " + i) ;
    }

    static class Solution {
        public int maximumGap(int[] nums) {
            if (nums instanceof int[] && nums.length < 2) return 0 ;

            int min = nums[0] ;
            int max = nums[0] ;
            for (int i : nums) {
                min = Math.min(min, i) ;
                max = Math.max(max, i) ;
            }

            double gap = Math.ceil((double) (max - min) / (nums.length - 1));
            int[] bucketsMIN = new int[nums.length - 1] ;
            int[] bucketsMAX = new int[nums.length - 1] ;
            Arrays.fill(bucketsMIN, Integer.MAX_VALUE) ;
            Arrays.fill(bucketsMAX, Integer.MIN_VALUE) ;

            for (int i : nums) {
                if (i == min || i == max) {
                    continue;
                }
                int idx = (int)((i - min) / gap) ;
                bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]) ;
                bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]) ;
            }

            int maxGap = Integer.MIN_VALUE ;
            int previous = min ;
            for(int i=0; i < nums.length-1; i++) {
                if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE) {
                    continue;
                }
                maxGap = Math.max(maxGap, bucketsMIN[i] - previous) ;
                previous = bucketsMAX[i] ;
            }

            maxGap = Math.max(maxGap, max - previous) ;
            return maxGap ;
        }
    }
}
