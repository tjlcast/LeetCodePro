package LeetCode_Offer_Offer_Offer;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2017/12/27.
 */
public class _172_Factorial_Trailing_Zeroes {
    /**
     * Given an integer n, return the number of trailing zeroes in n!.
     Note: Your solution should be in logarithmic time complexity.
     */

    public static void main(String[] args) {
        int n = 1808548329 ;

        Solution solution = new Solution();
        int i = solution.trailingZeroes(n);

        System.out.println(i) ;
    }

    static class Solution {
        private HashMap<Integer, Integer> recorder = new HashMap<>() ;

        public int trailingZeroes(int n) {
            return n / 5 == 0 ? 0 : n /5 + trailingZeroes(n / 5);
        }
    }
}
