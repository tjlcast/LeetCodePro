package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/4.
 */
public class _43_Multiply_Strings {
    /**
     * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

     Note:

     The length of both num1 and num2 is < 110.
     Both num1 and num2 contains only digits 0-9.
     Both num1 and num2 does not contain any leading zero.
     You must not use any built-in BigInteger library or convert the inputs to integer directly.
     */

    public static void main(String[] args) {
        String num1 = "9" ;
        String num2 = "9" ;

        _43_Multiply_Strings multiply_strings = new _43_Multiply_Strings();
        String work = multiply_strings.work(num1, num2);

        System.out.println("work is: " + work) ;
    }

    public String work(String num1, String num2) {
        Solution solution = new Solution();
        String multiply = solution.multiply(num1, num2);
        return multiply ;
    }

    class Solution {

        int[] nums = new int[220] ;

        public String multiply(String num1, String num2) {
            num1 = new StringBuilder(num1).reverse().toString() ;
            num2 = new StringBuilder(num2).reverse().toString() ;

            // num2 逐个数
            for(int bit2=0; bit2<num2.length(); bit2++) {
                // num1 逐个数
                int bit2Num = num2.charAt(bit2) - '0' ;
                for(int bit1=0; bit1<num1.length(); bit1++) {
                    int bit1Num = num1.charAt(bit1) - '0' ;
                    nums[bit1+bit2] += bit1Num * bit2Num ;
                }
            }

            // add
            int carr = 0 ;
            for(int i=0; i<nums.length; i++) {
                int val = (carr + nums[i]) ;
                carr = val / 10 ;
                nums[i] = val % 10;
            }

            // to String
            StringBuilder sb = new StringBuilder() ;
            boolean isZero = true ;
            for(int i=nums.length-1; i>=0; i--) {
                if (isZero && nums[i]==0) continue;
                if (nums[i]!=0) isZero=false ;
                sb.append(nums[i] + "") ;
            }
            String s = sb.toString();
            return (s.length()==0)?("0"):(s) ;
        }
    }
}
