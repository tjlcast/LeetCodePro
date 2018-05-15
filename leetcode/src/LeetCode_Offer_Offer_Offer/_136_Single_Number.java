package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/12/5.
 */
public class _136_Single_Number {
    /**
     * Given an array of integers, every element appears twice except for one. Find that single one.
     */

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4} ;

        Solution solution = new Solution();
        int i = solution.singleNumber(nums);

        System.out.println("work is : " + i) ;
    }

    static class Solution {
        public int singleNumber(int[] nums) {
            int ans = 1 ;

            for(Integer num : nums) {
                ans = ans ^ num ;
            }

            return ans ^ 1 ;
        }
    }
}
