package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/12/15.
 */
public class _151_Reverse_Words_in_a_String {
    /**
     * Given an input string, reverse the string word by word.

     For example,
     Given s = "the sky is blue",
     return "blue is sky the".

     Update (2015-02-12):
     For C programmers: Try to solve it in-place in O(1) space.
     */

    public static void main(String[] args) {
        String s = "   " ;

        Solution solution = new Solution();
        String s1 = solution.reverseWords(s);

        System.out.println("the work is: " + s1) ;
    }

    static public class Solution {
        public String reverseWords(String s) {
            if(s==null || s.equals("")) return s ;

            StringBuilder ans = new StringBuilder();
            StringBuilder sb = new StringBuilder(s) ;
            String s1 = sb.reverse().toString();

            String[] split = s1.split(" ");
            if(split.length == 0) return "" ;
            for(String substr : split) {
                if(substr.equals("")) continue;
                StringBuilder stringBuilder = new StringBuilder(substr);
                ans.append(stringBuilder.reverse() + " ") ;
            }

            return ans.toString().substring(0, ans.length()-1) ;
        }
    }
}
