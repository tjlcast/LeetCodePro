package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;

/**
 * Created by tangjialiang on 2017/9/14.
 */
public class _81_Search_in_Rotated_Sorted_Array_II {
    /**
     * Follow up for "Search in Rotated Sorted Array":
     What if duplicates are allowed?

     Would this affect the run-time complexity? How and why?
     Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

     (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

     Write a function to determine if a given target is in the array.

     The array may contain duplicates.


     */

    public static void main(String[] args) {
        int[] nums = { 3, 1 } ;
        int target = 1 ;

        _81_Search_in_Rotated_Sorted_Array_II search_in_rotated_sorted_array_ii = new _81_Search_in_Rotated_Sorted_Array_II();
        boolean work = search_in_rotated_sorted_array_ii.work(nums, target);

        System.out.println("work is: " + work) ;
    }

    public boolean work(int[] nums, int target) {
        Solution solution = new Solution();
        boolean search = solution.search(nums, target);

        return search ;
    }

    class Solution {
        /**
         * 注意：本题的输入可以重复数字。 普通的rotate array的输入是各不相同的数字。
         */
        public boolean search(int[] nums, int target) {
            if (nums==null || nums.length==0) return false ;

            int len = removeDuplicates(nums);
            boolean b = mySearch(nums, 0, len - 1, target);
            return b ;
        }

        private int removeDuplicates(int[] nums) {
            int pos = 0 ;
            int index = 0 ;

            while(index < nums.length) {
                int num = nums[index++];
                nums[pos++] = num ;

                while(index < nums.length && nums[index]==num) index++ ;
            }
            return pos ;
        }

        private boolean mySearch(int[] nums, int l, int r, int target) {
            System.out.println("l " + l + " r " + r);

            if (l == r) {
                if (target == nums[l]) return true;
                else return false;
            }

            int mid = (l + r) / 2;

            if (nums[mid] >= nums[l]) {
                // 2th
                if (target >= nums[l] && target <= nums[mid]) {
                    int i = Arrays.binarySearch(nums, l, mid + 1, target);
                    return (i >= 0) ? (true) : (false);
                } else {
                    return mySearch(nums, mid + 1, r, target);
                }
            } else {
                // 1th
                if (target>=nums[mid] && target<=nums[r]) {
                    int i = Arrays.binarySearch(nums, mid, r + 1, target);
                    return (i>=0) ? (true) : (false) ;
                } else {
                    return mySearch(nums, l, mid, target) ;
                }
            }

        }
    }
}
