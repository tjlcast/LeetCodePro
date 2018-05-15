package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/12/5.
 */
public class _139_Word_Break {
    /**
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

     For example, given
     s = "leetcode",
     dict = ["leet", "code"].

     Return true because "leetcode" can be segmented as "leet code".
     */

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab" ;
        String[] words = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"} ;
        LinkedList<String> wordDict = new LinkedList<>() ;
        for(String word : words) {
            wordDict.addLast(word);
        }

        Solution solution = new Solution();
        boolean b = solution.wordBreak(s, wordDict);

        System.out.println("work is : " + b) ;
    }

    static class Solution {
        private List<String> wordDict = new LinkedList<>() ;
        private int[] dp = null ;

        public boolean wordBreak(String s, List<String> wordDict) {
            this.wordDict = wordDict ;
            dp = new int[s.length() + 1] ;
            return canSplit(s, 0) ;
        }

        private boolean canSplit(String s, int begin) {
            if (begin >= s.length()) return true ;
            if (dp[begin] != 0) return dp[begin]==1 ;

            int index = begin ;
            while(index <= s.length()) {
                String subStr = s.substring(begin, index) ;
                if (wordDict.contains(subStr)) {
                    if (canSplit(s, index)) {
                        dp[begin] = 1 ;
                        return true ;
                    }
                }
                index += 1 ;
            }
            dp[begin] = -1 ;
            return false ;
        }
    }
}
