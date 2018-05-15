package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2018/1/28.
 */
public class _231_Power_of_Two {

    public static void main(String[] args) {
        int n = 10 ;

        Solution sol = new Solution() ;
        boolean ans = sol.isPowerOfTwo(n) ;

        System.out.println("The work is: " + ans) ;
    }

    static class Solution {
        public boolean isPowerOfTwo(int n) {
            // todo
            int num = 1 ;
            while(num <= n) {
                if (num == n) return true ;
                if ((Integer.MAX_VALUE>>1) <= num) return false ;
                num = num << 1 ;
            }
            return false ;
        }
    }
}
