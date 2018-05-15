package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;

/**
 * Created by tangjialiang on 2017/9/3.
 */
public class _33_Search_in_Rotated_Sorted_Array {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

     (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

     You are given a target value to search. If found in the array return its index, otherwise return -1.

     You may assume no duplicate exists in the array.
     */

    public static void main(String[] args) {
        int[] nums = {1, 3, 5} ;
        int target = 2 ;

        _33_Search_in_Rotated_Sorted_Array search_in_rotated_sorted_array = new _33_Search_in_Rotated_Sorted_Array();
        int work = search_in_rotated_sorted_array.work(nums, target);

        System.out.println("work is: " + work) ;
    }

    public int work(int[] nums, int target) {
        Solution solution = new Solution();
        int search = solution.search(nums, target);
        return search ;
    }

    class Solution {
        public int search(int[] nums, int target) {
            if (nums==null || nums.length==0) return -1 ;

            int i = myFind(nums, 0, nums.length - 1, target);
            return i ;
        }

        private int myFind(int[] nums, int l, int r, int target) {
            if (l==r) {
                if (target==nums[l]) return l ;
                else return -1 ;
            }

            int mid = (l + r) / 2 ;

            if (nums[mid] >= nums[l]) {
                // 2th
                if (target>=nums[l] && target<=nums[mid]) {
                    int i = Arrays.binarySearch(nums, l, mid + 1, target);
                    return (i>=0) ? (i) : (-1) ;
                } else {
                    return myFind(nums, mid+1, r, target) ;
                }
            } else {
                // 1th
                if (target>=nums[mid] && target<=nums[r]) {
                    int i = Arrays.binarySearch(nums, mid, r + 1, target);
                    return (i>=0) ? (i) : (-1) ;
                } else {
                    return myFind(nums, l, mid, target) ;
                }
            }
        }
    }
}
