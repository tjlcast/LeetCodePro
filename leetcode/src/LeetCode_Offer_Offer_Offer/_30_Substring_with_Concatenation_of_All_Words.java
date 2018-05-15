package LeetCode_Offer_Offer_Offer;

import java.util.*;

/**
 * Created by tangjialiang on 2017/9/3.
 */
public class _30_Substring_with_Concatenation_of_All_Words {
    /**
     * You are given a string, s, and a list of words, words, that are all of the same length.
     * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

     For example, given:
     s: "barfoothefoobarman"
     words: ["foo", "bar"]

     You should return the indices: [0,9].
     (order does not matter).
     */

    public static void main(String[] args) {
        String s = "foobarfoobar" ;
        String[] words = {"foo","bar"} ;

        _30_Substring_with_Concatenation_of_All_Words substring_with_concatenation_of_all_words = new _30_Substring_with_Concatenation_of_All_Words();
        List<Integer> work = substring_with_concatenation_of_all_words.work(s, words);

        System.out.println("work is: ") ;
        for(Integer i : work) System.out.println(i) ;
    }

    public List<Integer> work(String s, String[] words) {
        Solution solution = new Solution();
        List<Integer> substring = solution.findSubstring(s, words);
        return substring ;
    }


    class Solution {
        /**
         * tips: 对原输入数据进行统计并保存，之后再对输入数据进行统计与保存结果进行比对。
         */

        private List<Integer> ansList = new LinkedList<>() ;
        private HashMap<String, Integer> countsWords = new HashMap<>() ;

        public List<Integer> findSubstring(String s, String[] words) {
            if (words==null || words.length==0) return ansList ;

            for(String word : words) countsWords.put(word, countsWords.getOrDefault(word, 0)+1) ;

            int wordNum = words.length ;
            int wordLen = words[0].length() ;

            for(int i=0; i+wordLen*wordNum-1<s.length(); i++) {
                HashMap<String, Integer> copyCount = new HashMap<>() ;
                boolean isRight = true ;
                for(int j=0; j<wordNum; j++) {
                    String substring = s.substring(i + j * wordLen, i + j * wordLen + wordLen);
                    if (!countsWords.containsKey(substring) || countsWords.get(substring).equals(copyCount.get(substring))) {
                        isRight = false ;
                        break ;
                    } else {
                        copyCount.put(substring, copyCount.getOrDefault(substring, 0)+1) ;
                    }
                }
                if (isRight) ansList.add(i) ;
            }

            return ansList ;
        }

    }

    /**
     * time out
     */
    class Solution2 {

        private List<Integer> ansList = new LinkedList<>() ;

        public List<Integer> findSubstring(String s, String[] words) {
            if (words==null || words.length==0) return ansList ;
            // sort words ;
            Arrays.sort(words);
            String compWords = "" ;
            for(String word : words) compWords += word ;

            int wordNum = words.length ;
            int wordLen = words[0].length() ;

            for(int i=0; (i + wordLen*wordNum-1)<s.length(); i++) {
                String[] copyStr = new String[wordNum] ;
                for(int j=0; j<copyStr.length; j++) {
                    copyStr[j] = s.substring(i+j*wordLen, i+j*wordLen+wordLen) ;
                }
                Arrays.sort(copyStr);
                String tempWords = "" ;
                for(String word : copyStr) tempWords += word ;
                if (tempWords.equals(compWords)) {
                    ansList.add(i) ;
                }
            }

            return ansList ;
        }

    }


    /**
     * time out
     */
    class Solution1 {
        private List<Integer> ansList = new LinkedList<>() ;

        public List<Integer> findSubstring(String s, String[] words) {

            List<String> strings = allStrs(words);

            for(String str : strings) {
                System.out.println(str) ;
                int i1 = s.indexOf(str, 0);
                while (i1 >= 0 && !ansList.contains(i1)) {
                    ansList.add(i1) ;
                    i1 = s.indexOf(str, i1+1) ;
                }
            }

            return ansList ;
        }

        private List<String> allStrs(String[] words) {
            List<String> allStrs = new LinkedList<>() ;

            generateStr(words, 0, allStrs) ;

            return allStrs ;
        }

        private void generateStr(String[] words, int pos, List<String> allStrs) {
            if (pos == words.length) {
                String aLine = "" ;
                for(String word : words) aLine = aLine + word ;
                allStrs.add(aLine) ;
            }

            for(int i=pos; i<words.length; i++) {
                String swap = words[pos] ;
                words[pos] = words[i] ;
                words[i] = swap ;

                // next
                generateStr(Arrays.copyOfRange(words, 0, words.length), pos+1, allStrs);
            }


        }
    }
}
