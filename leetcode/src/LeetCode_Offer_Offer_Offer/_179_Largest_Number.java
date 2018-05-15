package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/12/28.
 */
public class _179_Largest_Number {
    /**
     * Given a list of non negative integers, arrange them such that they form the largest number.

     For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

     Note: The result may be very large, so you need to return a string instead of an integer.
     * @param args
     */

    public static void main(String[] args) {
        int[] nums = {999999998,999999997,999999999} ;

        Solution solution = new Solution();
        String s = solution.largestNumber(nums);

        System.out.println("the work is: " + s) ;
    }

    static class Solution {
        public String largestNumber(int[] nums) {
            for(int i=0; i<nums.length; i++) {
                for(int j=i+1; j<nums.length; j++) {
                    if(shouldSwap(nums[i]+"", nums[j]+"")) {
                        int temp = nums[i] ;
                        nums[i] = nums[j] ;
                        nums[j] = temp ;
                    }
                }
            }

            int idx = -1 ;
            StringBuilder sb = new StringBuilder() ;
            for(int i=0; i<nums.length; i++) {
                if(idx == -1 && nums[i] != 0) idx = i ;
                sb.append(nums[i]+"") ;
            }

            if (idx == -1) return 0+"" ;
            return sb.toString() ;
        }

        boolean shouldSwap(String a, String b) {
            return Long.parseLong(a + b) < Long.parseLong(b + a) ;
        }
    }
}
