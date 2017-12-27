package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/12/27.
 */
public class _171_Excel_Sheet_Column_Number {
    /**
     * Given a column title as appear in an Excel sheet, return its corresponding column number.

     For example:

     A -> 1
     B -> 2
     C -> 3
     ...
     Z -> 26
     AA -> 27
     AB -> 28
     */

    public static void main(String[] args) {
        String s = "Z" ;

        Solution solution = new Solution();
        int i = solution.titleToNumber(s);

        System.out.println("the work is: " + i) ;
    }

    static class Solution {
        public int titleToNumber(String s) {
            int total = 0 ;

            for(int i=0; i<s.length(); i++) {
                total *= 26 ;
                int num = (s.charAt(i) - 'A' + 1) ;
                total += num ;
            }

            return total ;
        }
    }
}
