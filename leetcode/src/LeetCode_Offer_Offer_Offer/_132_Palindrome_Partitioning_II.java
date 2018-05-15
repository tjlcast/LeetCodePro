package LeetCode_Offer_Offer_Offer;

import java.util.List;

/**
 * Created by tangjialiang on 2017/11/28.
 */
public class _132_Palindrome_Partitioning_II {
    /**
     *
     * Given a string s, partition s such that every substring of the partition is a palindrome.

     Return the minimum cuts needed for a palindrome partitioning of s.

     For example, given s = "aab",
     Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
     */

    public static void main(String[] args) {
        String s = "aaabaa" ;

        int i = new Solution().minCut(s);

        System.out.println("the work is: " + i) ;
    }

    static class Solution {
        int[][] dp ;
        int[] count ;

        public int minCut(String s) {
            dp = new int[s.length()][s.length()] ;
            count = new int[s.length()+1] ; for(int i=0; i<count.length; i++) count[i] = Integer.MAX_VALUE ;

            for(int i=0; i<s.length(); i++) {
                dp[i][i] = 1 ;
                if (i+1<s.length() && s.charAt(i)==s.charAt(i+1)) {
                    dp[i][i+1] = 1;
                }
            }

            for(int l=2; l<s.length(); l++ ) {
                for(int i=0; i+l<s.length(); i++) {
                    int j = i+l ;
                    if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]==1) {
                        dp[i][j] = 1 ;
                    }
                }
            }

            count[s.length()] = 0 ;
            for(int i=s.length()-1; i>=0; i--) {
                for(int j=i; j<s.length(); j++) {
                    if (dp[i][j] == 1) {
                        count[i] = Math.min(count[i], count[j+1]+1) ;
                    }
                }
            }

            return count[0] - 1;
        }
    }
}
