package LeetCode_Offer_Offer_Offer;

import Utils.LinkedListUtils;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by tangjialiang on 2017/9/13.
 */
public class _76_Minimum_Window_Substring {
    /**
     * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

     For example,
     S = "ADOBECODEBANC"
     T = "ABC"
     Minimum window is "BANC".

     Note:
     If there is no such window in S that covers all characters in T, return the empty string "".

     If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
     */

    public static void main(String[] args) {
        String s = "bba" ;
        String t = "ab" ;

        _76_Minimum_Window_Substring minimum_window_substring = new _76_Minimum_Window_Substring();
        String work = minimum_window_substring.work(s, t);

        System.out.println("work is: " + work) ;
    }

    public String work(String s, String t) {
        Solution solution = new Solution();
        String s1 = solution.minWindow(s, t);

        return s1 ;
    }

    class Solution {
        /**
         * 和Longest Substring Without Repeating Characters及Substring with Concatenation of All Words类似的思路，使用l和r两个指针维护子串，用Hash表记录T字串中出现的字符。S中，每次循环r右移1位，然后判断r右移之后所指向的字符是否在Hash表中出现过：如果出现过，则表示在T中。此时通过计数器cnt判断T中字符是否都出现过，如果是，则记录l和r之间子串长度，并与最短长度比较。然后逐步右移l并在Hash表中删除l指向的字符直到计数器cnt小于T中字符数量。

         注意一下，由于T中同一字符的数量可能减到负值，因此需要2重判断：先判断是否出现此字符，在判断此字符出现的具体数量。

         时间复杂度：O(l1+l2)（l1和l2分别为字符串S和T的长度）

         空间复杂度：O(l2)
         */

        private HashMap<Character, Integer> charTime = new HashMap<>() ;
        private int minLen = Integer.MAX_VALUE ;
        private int minL = -1 ;
        private int minR = -1 ;

        public String minWindow(String s, String t) {
            // 每次添加最右元素后，把l压缩。
            // filter不合法字符，把多余的合法字符删除(出现的数量大于标准数量)，
            // 直达出现一个与标准数量相同的合法字符。
            preWork(t);

            int l = -1 ;
            int r = 0 ;
            HashMap<Character, Integer> curTime = new HashMap<>() ;

            while(r < s.length()) {
                char word = s.charAt(r) ;

                if (charTime.keySet().contains(word)) {
                    if (l==-1) l = r ;

                    Integer orDefault = curTime.getOrDefault(word, 0);
                    curTime.put(word, orDefault+1) ;

                    if (isSameTime(curTime)) {
                        while(l < r) {

                            char leftWord = s.charAt(l) ;
                            if (curTime.keySet().contains(leftWord)) {
                                // 把多余字符从范围内去除。
                                if (curTime.get(leftWord) - charTime.get(leftWord) > 0) {
                                    curTime.put(leftWord, curTime.get(leftWord)-1) ;
                                }

                                // 循环退出条件
                                else //(curTime.get(leftWord) - charTime.get(leftWord) == 0)
                                {
                                    break ;
                                }
                            }
                            l++ ;
                        }

                        if (curTime.get(word) - charTime.get(word) == 0) {
                            if (r - l + 1< minLen) {
                                minR = r+1 ;
                                minL = l ;
                                minLen = r - l + 1;
                            }
                        }
                    }
                }

                r += 1 ;
            }

            if (minL!=-1 && minR!=-1) return s.substring(minL, minR) ;
            return "" ;
        }

        private void preWork(String t) {
            for(int i=0; i<t.length(); i++) {
                Integer orDefault = charTime.getOrDefault(t.charAt(i), 0);
                charTime.put(t.charAt(i), orDefault+1) ;
            }
            return ;
        }

        private boolean isSameTime(HashMap<Character, Integer> curRecorder) {
            for(Character key : charTime.keySet()) {
                if ( curRecorder.getOrDefault(key, 0) - charTime.get(key) < 0) return false ;
            }
            return true ;
        }
    }
}
