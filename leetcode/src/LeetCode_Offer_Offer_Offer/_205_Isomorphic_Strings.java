package LeetCode_Offer_Offer_Offer;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2018/1/18.
 */
public class _205_Isomorphic_Strings {
    /**
     * Given two strings s and t, determine if they are isomorphic.

     Two strings are isomorphic if the characters in s can be replaced to get t.

     All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

     For example,
     Given "egg", "add", return true.

     Given "foo", "bar", return false.

     Given "paper", "title", return true.
     */

    public static void main(String[] args) {
        String s = "foo" ;
        String t = "wad" ;

        Solution solution = new Solution();
        boolean isomorphic = solution.isIsomorphic(s, t);

        System.out.println("The work is: " + isomorphic) ;
    }

    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            // todo
            String s1 = str2Num(s);
            String s2 = str2Num(t);

            return s1.equals(s2) ;
        }

        private String str2Num(String str) {
            StringBuilder sb = new StringBuilder() ;
            int num = 0 ;
            HashMap<Character, Integer> mapper = new HashMap<>() ;

            for(int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                Integer integer = mapper.getOrDefault(c, num++);
                mapper.put(c, integer) ;
                sb.append(integer) ;
            }
            return sb.toString() ;
        }
    }
}
