package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/8/31.
 */
public class _5_Longest_Palindromic_Substring {
    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

     Example:

     Input: "babad"

     Output: "bab"

     Note: "aba" is also a valid answer.
     Example:

     Input: "cbbd"

     Output: "bb"
     */

    public static void main(String[] args) {
        String str = "a" ;

        _5_Longest_Palindromic_Substring longest_palindromic_substring = new _5_Longest_Palindromic_Substring() ;
        String work = longest_palindromic_substring.work(str);

        System.out.println("work is: " + work) ;
    }

    public String work(String s) {
        Solution solution = new Solution();
        String s1 = solution.longestPalindrome(s);
        return s1 ;
    }



    class Solution {
        /**
         * 动态规划： 时间复杂度为n*log(n)具象化。n*n的矩阵对角线的一半遍历。
         */
        private int[][] dp = null ;
        private int maxLen = 1 ;
        private int start = 0 ;
        private int end = 0 ;

        public String longestPalindrome(String s) {
            String ans = null  ;
            if (s==null || s.length()==0) return ans ;
            initial(s);

            for(int k=2; k<s.length(); k++) {
                for(int j=k; j<s.length(); j++) {
                    int i = j - k ;
                    if (dp[i+1][j-1]==1 && s.charAt(i)==s.charAt(j)) {
                        dp[i][j] = 1 ;
                        maxLen = Math.max(j-i+1, maxLen) ;
                        start = i ;
                        end = j ;
                    }
                }
            }

            ans = s.substring(start, end+1) ;
            return ans ;
        }

        private void initial(String s) {
            int len = s.length() ;
            if (len <= 0) throw new IllegalArgumentException() ;

            dp = new int[len][len] ;

            for(int i=0; i<len; i++) {
                dp[i][i] = 1 ;
                if (i<len-1 && s.charAt(i)==s.charAt(i+1)) {
                    dp[i][i+1]=1 ;
                    maxLen = 2 ;
                    start = i ;
                    end = i+1 ;
                }
            }
        }

    }
}
