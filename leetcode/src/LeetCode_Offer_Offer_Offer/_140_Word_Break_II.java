package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/12/7.
 */
public class _140_Word_Break_II {
    /**
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

     Return all such possible sentences.

     For example, given
     s = "catsanddog",
     dict = ["cat", "cats", "and", "sand", "dog"].

     A solution is ["cats and dog", "cat sand dog"].
     */

    public static void main(String[] args) {
        String s = "aaaaaaa" ;
        String[] words = {"aaaa","aa","a"} ;

        LinkedList<String> strings = new LinkedList<>();
        for(String word : words) {
            strings.add(word) ;
        }

        Solution solution = new Solution();
        List<String> strings1 = solution.wordBreak(s, strings);

        System.out.println("work is: ") ;
        for(String line : strings1) {
            System.out.println(line) ;
        }
    }

    static class Solution {
        private List<String> wordDict ;
        private int[] dp ;
        private List<String> ans = new LinkedList<>() ;

        public List<String> wordBreak(String s, List<String> wordDict) {
            this.wordDict = wordDict ;
            dp = new int[s.length() + 1] ;

            canSplit(s, 0, new LinkedList<String>()) ;

            return ans ;
        }

        private boolean canSplit(String s, int begin, LinkedList<String> recorder) {
            if (begin >= s.length()) {
                addAns(recorder) ;
                return true ;
            }
            if (dp[begin] == -1) return false ;

            int index = begin ;
            while(index <= s.length()) {
                String subStr = s.substring(begin, index) ;
                if (wordDict.contains(subStr)) {
                    recorder.addLast(subStr);
                    if (canSplit(s, index, recorder)) {
                        dp[begin] = 1 ;
                    }
                    recorder.removeLast() ;
                }
                index += 1;
            }

            if (dp[begin] == 0)dp[begin] = -1 ;
            return dp[begin] == 1 ;
        }

        private void addAns(LinkedList<String> recorder) {
            StringBuilder sb = new StringBuilder() ;
            for(String str : recorder) {
                sb.append(str + " ") ;
            }
            sb.deleteCharAt(sb.length()-1) ;
            ans.add(sb.toString()) ;
        }
    }
}
