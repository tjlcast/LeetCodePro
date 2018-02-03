package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;

/**
 * Created by tangjialiang on 2018/2/3.
 */
public class _260_Single_Number_III {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5} ;

        Solution sol = new Solution() ;
        int[] res = sol.singleNumber(nums) ;

        System.out.println("The result is: " + Arrays.stream(res).boxed().map(t -> t+"").reduce((a, b) -> a+" "+b).orElse("None")) ;
    }

    static class Solution {
        public int[] singleNumber(int[] nums) {

            int total = nums[0] ;
            for(int i=1; i<nums.length; i++) {
                total = total ^ nums[i] ;
            }

            int mask = total^(total & (total - 1)) ;

            int a = -1 ;
            for(int num : nums) {
                if ((mask&num) == 0) continue;
                a = (a == -1) ? (num) : (a^num) ;
            }

            int b = -1 ;
            for(int num : nums) {
                if ((mask&num) != 0) continue;
                b = (b == -1) ? (num) : (b^num) ;
            }

            int[] res =  {a, b} ;
            return res ;
        }
    }
}
