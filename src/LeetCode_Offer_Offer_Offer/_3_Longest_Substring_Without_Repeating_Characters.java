package LeetCode_Offer_Offer_Offer;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2017/8/31.
 *
 */
public class _3_Longest_Substring_Without_Repeating_Characters {
    /**
     * Given a string, find the length of the longest substring without repeating characters.

     Examples:

     Given "abcabcbb", the answer is "abc", which the length is 3.

     Given "bbbbb", the answer is "b", with the length of 1.

     Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    public static void main(String[] args) {
        String s = "abba" ;
        _3_Longest_Substring_Without_Repeating_Characters longest_substring_without_repeating_characters = new _3_Longest_Substring_Without_Repeating_Characters();
        int work = longest_substring_without_repeating_characters.work(s);
        System.out.println("work: " + work) ;
    }

    public int work(String s) {
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring(s);
        return i ;
    }

    class Solution {
        /**
         * 维护一个出现一次的数据窗口。
         * 在遍历数字的时候，把数字和数字的位置保存到HashMap中。
         */

        private HashMap<Character, Integer> appearPosition = new HashMap<>() ;
        // Character, integer, 记录上次字符加入时的位置。
        int line = 0 ;

        public int lengthOfLongestSubstring(String str) {
            int s = 0 ;
            int e = 0 ;

            for(e=0; e<str.length(); e++) {
                char c = str.charAt(e);
                Integer integer = appearPosition.get(c);
                if (integer != null && integer>=s) {
                    s = integer + 1 ;
                }
                appearPosition.put(c, e) ;
                line = Math.max(line, e - s + 1) ;
            }

            return line ;
        }
    }
}
