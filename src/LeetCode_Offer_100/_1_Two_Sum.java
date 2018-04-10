package LeetCode_Offer_100;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/2/28.
 */
public class _1_Two_Sum {

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] ans = null ;
            if (nums==null || nums.length==0) return ans ;

            HashMap<Integer, Integer> recorders = new HashMap<>() ;
            for(int i=0; i<nums.length; i++) {
                int rest = target - nums[i] ;
                if (recorders.containsKey(rest)) {
                    int[] ansTemp = {recorders.get(rest), i} ;
                    return ansTemp ;
                }
                recorders.put(nums[i], i) ;
            }

            return ans ;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15} ;
        int target = 9 ;

        Solution sol = new Solution() ;
        int[] ints = sol.twoSum(nums, target) ;

        System.out.println("The ans is: ") ;
        for(Integer num : ints) {
            System.out.print(num + " ") ;
        }
        System.out.println() ;
    }
}
