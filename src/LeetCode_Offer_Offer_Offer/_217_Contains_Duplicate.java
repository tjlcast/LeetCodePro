package LeetCode_Offer_Offer_Offer;

import java.util.HashSet;

/**
 * Created by tangjialiang on 2018/1/22.
 */
public class _217_Contains_Duplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5} ;

        Solution sol = new Solution() ;
        boolean ans = sol.containsDuplicate(nums) ;

        System.out.println("Thw work is: " + ans) ;
    }

    static class Solution {

        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> set = new HashSet<>() ;

            for(Integer i : nums) {
                if (set.contains(i)) return true ;
                set.add(i) ;
            }
            return false ;
        }
    }
}
