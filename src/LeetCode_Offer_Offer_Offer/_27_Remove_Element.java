package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/2.
 */
public class _27_Remove_Element {
    /**
     * Given an array and a value, remove all instances of that value in place and return the new length.

     Do not allocate extra space for another array, you must do this in place with constant memory.

     The order of elements can be changed. It doesn't matter what you leave beyond the new length.

     Example:
     Given input array nums = [3,2,2,3], val = 3

     Your function should return length = 2, with the first two elements of nums being 2.
     */

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3} ;
        int val = 3 ;
        int work = new _27_Remove_Element().work(nums, val) ;

        System.out.println("work is: ") ;
        for(int i=0; i<work; i++) {
            System.out.print(nums[i]) ;
        }
    }

    public int work(int[] nums, int val) {
        Solution solution = new Solution();
        int i = solution.removeElement(nums, val);
        return i ;
    }

    class Solution {
        public int removeElement(int[] nums, int val) {
            int pos = 0 ;
            int p = 0 ;
            while(p < nums.length) {
                int num = nums[p];
                if (num!=val) { nums[pos++] = num ; }
                p++ ;
            }

            return pos ;
        }
    }
}
