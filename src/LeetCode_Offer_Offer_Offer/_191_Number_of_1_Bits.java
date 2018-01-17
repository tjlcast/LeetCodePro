package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2018/1/17.
 */
public class _191_Number_of_1_Bits {

    /**
     * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

     For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
     */

    public static void main(String[] args) {
        int n = -1 ;

        Solution solution = new Solution();
        int i = solution.hammingWeight(n);

        System.out.println("the work is: " + i) ;
    }

    static class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0 ;
            for(int i=0; i<32; i++) {
                if ((n & 1) == 1) {
                    count++ ;
                }
                n = (n >> 1) ;
            }
            return count ;
        }
    }
}
