package zz_to_to_offer.solution;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/4/26.
 */
public class Solution34 {
    static public class Solution {
        public int FirstNotRepeatingChar(String str) {
            char[] chars = str.toCharArray() ;
            HashMap<Character, Integer> recorder = new HashMap<>() ;

            for (int i=0; i<str.length(); i++) {
                char c = str.charAt(i) ;
                int count = recorder.getOrDefault(c, 0) ;
                recorder.put(c, count+1) ;
            }

            for (int i=0; i<str.length(); i++) {
                char c = str.charAt(i) ;
                if (recorder.containsKey(c) && recorder.get(c)==1) {
                    return i ;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        String str = "google" ;

        Solution sol = new Solution() ;
        int i = sol.FirstNotRepeatingChar(str);

        System.out.println(i) ;
    }
}
