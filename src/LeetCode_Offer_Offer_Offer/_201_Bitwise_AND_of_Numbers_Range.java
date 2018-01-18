package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2018/1/17.
 */
public class _201_Bitwise_AND_of_Numbers_Range {
    /**
     * Given a range [m, n] where 0 <= m <= n <= 2147483647,
     * return the bitwise AND of all numbers in this range, inclusive.

     For example, given the range [5, 7], you should return 4.
     */

    public static void main(String[] args) {
        int m = 5 ;
        int n = 7 ;

        Solution solution = new Solution();
        int i = solution.rangeBitwiseAnd(m, n);

        System.out.println("The work is: " + i) ;
    }

    static class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            int mask = 1 ;
            for(int i=0; i<32; i++) {
                mask = ((mask << 1) | 1) ;
            }


            for(int i=0; i<32; i++) {
                if ((m & mask) == (n & mask)) {
                    return (m & mask) ;
                }
                mask = (mask << 1) ;
            }

            return -1 ;
        }
    }
}
