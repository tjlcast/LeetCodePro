package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/2.
 */
public class _26_Remove_Duplicates_from_Sorted_Array {
    /**
     * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

     Do not allocate extra space for another array, you must do this in place with constant memory.

     For example,
     Given input array nums = [1,1,2],

     Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
     It doesn't matter what you leave beyond the new length.
     */

    public static void main(String[] args) {
        int[] nums = {1} ;
        _26_Remove_Duplicates_from_Sorted_Array remove_duplicates_from_sorted_array = new _26_Remove_Duplicates_from_Sorted_Array();
        int work = remove_duplicates_from_sorted_array.work(nums);

        System.out.println("work is: ") ;
        for(int i=0; i<work; i++) {
            System.out.print(nums[i] + " ") ;
        }
    }

    public int work(int[] nums) {
        Solution solution = new Solution();
        int i = solution.removeDuplicates(nums);
        return i ;
    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            int pos = 0 ;
            int p = 0 ;
            while(p < nums.length) {
                int num = nums[p];
                nums[pos++] = num ;

                p++ ;
                while(p<nums.length && nums[p]==nums[p-1]) p++ ;
            }

            return pos ;
        }
    }
}
