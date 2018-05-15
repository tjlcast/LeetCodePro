package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/11/28.
 */
public class _131_Palindrome_Partitioning {
    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.

     Return all possible palindrome partitioning of s.

     For example, given s = "aab",
     Return

     [
     ["aa","b"],
     ["a","a","b"]
     ]
     */

    public static void main(String[] args) {
        String s = "aab" ;

        List<List<String>> partition = new Solution().partition(s);

        for(List<String> line : partition) {
            for(String splice : line) {
                System.out.print(splice + " ") ;
            }
            System.out.println() ;
        }
    }

    static class Solution {
        LinkedList<List<String>> ans = new LinkedList<>() ;
        int[][] dp ;

        public List<List<String>> partition(String s) {
            dp = new int[s.length()][s.length()] ;

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

            bs(0, new LinkedList<String>(), s) ;

            return ans ;
        }

        private void bs(int b, LinkedList<String> list, String s) {
            if (b == s.length()) {
                ans.add((List<String>)list.clone()) ;
            }

            for(int e=b; e<s.length(); e++) {
                if (dp[b][e]==1) {
                    String splice = s.substring(b, e+1) ;
                    list.addLast(splice); ;
                    bs(e+1, list, s) ;
                    list.removeLast() ;
                }
            }
        }
    }
}
