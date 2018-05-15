package LeetCode_Offer_Offer_Offer;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2018/1/31.
 */
public class _242_Valid_Anagram {

    public static void main(String[] args) {
        String s = " " ;
        String t = "" ;

        Solution sol = new Solution() ;
        boolean res = sol.isAnagram(s, t) ;

        System.out.println("The work is: " + res) ;
    }

    static class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false ;

            HashMap<Character, Integer> mapper = new HashMap<>() ;

            for(char c : s.toCharArray()) {
                int count = mapper.getOrDefault(c, 0) ;
                mapper.put(c, count+1) ;
            }

            for(char c : t.toCharArray()) {
                int count = mapper.getOrDefault(c, 0) ;
                if (count == 0) return false ;
                mapper.put(c, count-1) ;
            }

            return true ;
        }
    }
}
