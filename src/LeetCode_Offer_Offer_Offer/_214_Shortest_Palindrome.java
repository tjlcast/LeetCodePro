package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2018/1/22.
 */
public class _214_Shortest_Palindrome {
    /**
     * Given a string S, you are allowed to convert it to a
     * palindrome by adding characters in front of it.
     * Find and return the shortest palindrome you can find by performing this transformation.

     For example:

     Given "aacecaaa", return "aaacecaaa".

     Given "abcd", return "dcbabcd".
     * @param args
     */

    public static void main(String[] args) {
        String s = "dcbabcd" ;

        Solution sol = new Solution() ;
        String ans = sol.shortestPalindrome(s) ;

        System.out.println("The work is: " + ans) ;
    }

    static class Solution {
        public String shortestPalindrome(String s) {
            if (s.equals("")) return s ;

            char[] str = s.toCharArray() ;
            for(int i=str.length-1; i>=0; i--) {
                if (isP(str, 0, i)) {
                    StringBuilder sb = new StringBuilder(s.substring(i+1)) ;
                    StringBuilder reversed = sb.reverse();
                    return reversed.toString()+s ;
                }
            }
            return null ;
        }

        public boolean isP(char[] str, int begin, int end) {
            while(begin <= end) {
                if (str[begin] != str[end]) return false ;
                begin++ ;
                end-- ;
            }
            return true ;
        }
    }
}
