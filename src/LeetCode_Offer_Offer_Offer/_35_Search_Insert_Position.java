package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/3.
 */
public class _35_Search_Insert_Position {
    /**
     * Given a sorted array and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.

     You may assume no duplicates in the array.

     Here are few examples.
     [1,3,5,6], 5 → 2
     [1,3,5,6], 2 → 1
     [1,3,5,6], 7 → 4
     [1,3,5,6], 0 → 0
     */
    public static void main(String[] args) {
        int[] nums = {1,3,5,6} ;
        int target = 2 ;

        _35_Search_Insert_Position search_insert_position = new _35_Search_Insert_Position();
        int work = search_insert_position.work(nums, target);

        System.out.println("work is: " + work) ;
    }

    public int work(int[] nums, int target) {
        Solution solution = new Solution();
        int i = solution.searchInsert(nums, target);
        return i ;
    }

    class Solution {
        public int searchInsert(int[] nums, int target) {
            for(int i=0; i<nums.length; i++) {
                if (target<=nums[i]) return  i ;
            }
            return nums.length ;
        }
    }
}
