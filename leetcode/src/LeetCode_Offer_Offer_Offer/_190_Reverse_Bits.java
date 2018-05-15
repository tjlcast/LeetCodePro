package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2018/1/16.
 */
public class _190_Reverse_Bits {

    /**
     * Reverse bits of a given 32 bits unsigned integer.

     For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
     return 964176192 (represented in binary as 00111001011110000010100101000000).
     * @param args
     */

    public static void main(String[] args) {
        int n = 43261596 ;

        Solution solution = new Solution();
        int i = solution.reverseBits(n);

        System.out.println("The work is: " + i);
    }

    static class Solution {
        // you need treat n as an unsigned value.
        public int reverseBits(int n) {

            int ans = 0 ;
            for(int i=1; i<=32; i++) {
                ans = ans << 1;
                if((n&1)==1) {
                    ans = (ans | 1) ;
                }
                n = (n >> 1) ;
            }

            return ans ;
        }
    }
}
