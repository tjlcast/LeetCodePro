package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/14.
 */
public class _80_Remove_Duplicates_from_Sorted_Array_II {
    /**
     * Follow up for "Remove Duplicates":
     What if duplicates are allowed at most twice?

     For example,
     Given sorted array nums = [1,1,1,2,2,3],

     Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
     It doesn't matter what you leave beyond the new length.

     */

    public static void main(String[] args) {
        int[] nums = {1, 2} ;

        _80_Remove_Duplicates_from_Sorted_Array_II remove_duplicates_from_sorted_array_ii = new _80_Remove_Duplicates_from_Sorted_Array_II();
        int work = remove_duplicates_from_sorted_array_ii.work(nums);

        System.out.println("work is: ") ;
        for(int i=0; i<work; i++) {
            System.out.print(nums[i] + " ") ;
        }
        System.out.println() ;
    }

    public int work(int[] nums) {
        Solution solution = new Solution();
        int i = solution.removeDuplicates(nums);
        return i ;
    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            int pos = 0 ;
            int index = 0 ;

            while(index < nums.length) {
                System.out.println("index " + index) ;
                // first
                int num = nums[index++] ;
                nums[pos++] = num ;

                // next
                if (index < nums.length && num == nums[index]) {
                    nums[pos++] = num ;
                    index++ ;
                }

                // skip same num
                while(index < nums.length && nums[index]==num) {
                    index++ ;
                }
            }

            return pos ;
        }
    }
}
