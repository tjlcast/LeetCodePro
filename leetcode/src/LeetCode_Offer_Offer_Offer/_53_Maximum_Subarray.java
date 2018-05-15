package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/7.
 */
public class _53_Maximum_Subarray {

    /**
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

     For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
     the contiguous subarray [4,-1,2,1] has the largest sum = 6.
     * @param args
     */

    public static void main(String[] args) {
//        int[] nums = {-2} ;
        int[] nums = {-2, -1, -10} ;

        _53_Maximum_Subarray maximum_subarray = new _53_Maximum_Subarray();
        int work = maximum_subarray.work(nums);

        System.out.println("work is: " + work) ;
    }

    public int work(int[] nums) {
        Solution solution = new Solution();
        int i = solution.maxSubArray(nums);
        return i ;
    }

    class Solution {

        private int maxVal = Integer.MIN_VALUE ;

        public int maxSubArray(int[] nums) {
            int lastSum = 0 ;

            for(int i=0; i<nums.length; i++) {
                int num = nums[i];
                lastSum += num ;
                if (lastSum > maxVal) maxVal = lastSum ;
                if (lastSum < 0) lastSum = 0 ;
            }

            return maxVal ;
        }
    }
}
