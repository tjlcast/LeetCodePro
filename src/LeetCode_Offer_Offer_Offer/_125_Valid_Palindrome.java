package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/11/27.
 */
public class _125_Valid_Palindrome {
    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

     For example,
     "A man, a plan, a canal: Panama" is a palindrome.
     "race a car" is not a palindrome.

     Note:
     Have you consider that the string might be empty? This is a good question to ask during an interview.

     For the purpose of this problem, we define empty string as valid palindrome.
     */


    class Solution {
        public boolean isPalindrome(String s) {
            int l = 0 ;
            int r = s.length()-1 ;

            while(l < r) {
                // to move l to be char
                while(l < r && !isChar(s.charAt(l))) {l++; }
                // to move r to be char
                while(l < r && !isChar(s.charAt(r))) {r--; }

                System.out.println(s.charAt(l) + " " + s.charAt(r)) ;
                if (!s.substring(l,l+1).toLowerCase().equals(s.substring(r,r+1).toLowerCase())) return false ;

                l++ ;
                r-- ;
            }

            return true ;
        }

        private boolean isChar(char c) {
            if ('0'<=c && c<='9') return true ;
            if ('a'<=c && c<='z') return true ;
            if ('A'<=c && c<='Z') return true ;
            return false ;
        }
    }
}
