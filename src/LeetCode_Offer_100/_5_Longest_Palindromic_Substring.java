package LeetCode_Offer_100;

/**
 * Created by tangjialiang on 2018/4/10.
 */
public class _5_Longest_Palindromic_Substring {

    static class Solution {
        public String longestPalindrome(String s) {
            if (s==null || s.length()==0) return "" ;

            int len = s.length() ;
            int maxLen = -1 ;
            int maxL = -1 ;
            int maxR = -1 ;

            /*
            * dp(i, j) = dp(i+1, j-1) if s(i)==s(j)
            * dp(i, j) =   dp(i+1, j) if s(i) != s(j)
            * */
            boolean[][] dp = new boolean[len+1][len+1] ;
            for(int i=1; i<=len; i++) {
                dp[i][i] = true ;
                if (dp[i][i] && maxLen<1) {
                    maxLen = 1 ;
                    maxL = i-1 ;
                    maxR = i-1 ;
                }
                if (i>=2 && s.charAt(i-2)==s.charAt(i-1)) {
                    dp[i-1][i] = true ;
                    if (dp[i-1][i] && maxLen<2) {
                        maxLen = 2 ;
                        maxL = i-2 ;
                        maxR = i-1 ;
                    }
                }
            }

            for(int j=1; j<=len; j++) {
                for (int i = 1; j-i>=2; i++) {
                    if (s.charAt(i-1) == s.charAt(j-1)) dp[i][j] = dp[i+1][j-1] ;
                    if (dp[i][j] && maxLen<j-i+1) {
                        maxLen = j-i+1 ;
                        maxL = i-1 ;
                        maxR = j-1 ;
                    }
                }
            }

            return s.substring(maxL, maxL+maxLen) ;
        }
    }

    public static void main(String[] args) {
        String s = "aaaa" ;

        Solution sol = new Solution() ;
        String s1 = sol.longestPalindrome(s);

        System.out.println(s1) ;
    }
}
