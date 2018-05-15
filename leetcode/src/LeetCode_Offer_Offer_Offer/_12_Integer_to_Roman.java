package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/1.
 */
public class _12_Integer_to_Roman {
    /**
     * Given an integer, convert it to a roman numeral.

     Input is guaranteed to be within the range from 1 to 3999.
     */

    public static void main(String[] args) {
        int num = 400 ;
        _12_Integer_to_Roman integer_to_roman = new _12_Integer_to_Roman();
        String work = integer_to_roman.work(num);
        System.out.println("work is: " + work) ;
    }

    public String work(int num) {
        Solution solution = new Solution();
        String s = solution.intToRoman(num);
        return s ;
    }

    class Solution {

        /**
         * tips: 取num第i位的数字计算公式： num / Math.pow(10, i) % 10 ;
         */

        private String[][] c = {{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM"}
        } ;

        public String intToRoman(int num) {
            StringBuilder sb = new StringBuilder() ;
            sb.append(c[3][num / 1000 % 10]) ;
            sb.append(c[2][num / 100 % 10]) ;
            sb.append(c[1][num / 10 % 10]) ;
            sb.append(c[0][num % 10]) ;

            return sb.toString() ;
        }
    }
}
