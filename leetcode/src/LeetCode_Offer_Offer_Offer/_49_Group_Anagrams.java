package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/5.
 */
public class _49_Group_Anagrams {
    /**
     * Given an array of strings, group anagrams together.

     For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
     Return:

     [
     ["ate", "eat","tea"],
     ["nat","tan"],
     ["bat"]
     ]
     Note: All inputs will be in lower-case.
     */

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"} ;

        _49_Group_Anagrams group_anagrams = new _49_Group_Anagrams();
        List<List<String>> work = group_anagrams.work(strs);

        System.out.println("work is: ") ;
        for(List<String> line : work) {
            for(String str : line)
                System.out.print(str + " ") ;
            System.out.println() ;
        }
    }

    public List<List<String>> work(String[] strs) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.groupAnagrams(strs);

        return lists ;
    }

    class Solution {
        private HashMap<String, List<String>> recorders = new HashMap<>() ;

        public List<List<String>> groupAnagrams(String[] strs) {
            for(String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars) ;
                String key = new String(chars);
                List<String> orDefault = recorders.getOrDefault(key, new LinkedList<String>());
                orDefault.add(str);
                recorders.put(key, orDefault) ;
            }

            LinkedList<List<String>> lists = new LinkedList<>();
            lists.addAll(recorders.values()) ;

            return lists ;
        }
    }
}
