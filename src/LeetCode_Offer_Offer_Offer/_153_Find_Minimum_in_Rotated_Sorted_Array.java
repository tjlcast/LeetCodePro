package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;

/**
 * Created by tangjialiang on 2017/12/17.
 */
public class _153_Find_Minimum_in_Rotated_Sorted_Array {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

     (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

     Find the minimum element.

     You may assume no duplicate exists in the array.
     */

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2} ;

        Solution solution = new Solution();
        int solutionMin = solution.findMin(nums);

        System.out.println("work is: " + solutionMin) ;
    }

    static class Solution {
        public int findMin(int[] nums) {
            return binarySearch(nums, 0, nums.length-1) ;
        }

        private int binarySearch(int[] nums, int begin, int end) {
            int mid = (begin + end) / 2 ;
            int midNum = nums[mid] ;

            int beginNum = nums[begin] ;
            int endNum = nums[end] ;

            if (beginNum > endNum) {
                if (midNum >= beginNum) {
                    return binarySearch(nums, mid+1, end) ;
                } else if (midNum < beginNum) {
                    return binarySearch(nums, begin, mid) ;
                }
            } else if (beginNum < endNum) {
                return beginNum ;
            } else {
                int borderNum = beginNum ;
                if (midNum > borderNum) {
                    return binarySearch(nums, mid+1, end) ;
                } else if (midNum < borderNum) {
                    return binarySearch(nums, begin, mid) ;
                } else {
                    // todo ;
                    return beginNum ;
                }
            }
            return -1 ;
        }
    }
}
