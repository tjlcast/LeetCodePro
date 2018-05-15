package ArrayAndString;

import java.util.*;

/**
 * Created by tangjialiang on 17/5/10.
 */
public class _30_Substring_with_Concatenation_of_All_Words {

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword" ;
        String[] words = {"word","good","best","good"} ;
        List<Integer> work = new _30_Substring_with_Concatenation_of_All_Words().work(s, words);
        for (Integer i : work) System.out.println(i);
    }

    private List<Integer> work(String s, String[] words) {
        List<Integer> substring = new Solution().findSubstring(s, words);
        return substring ;
    }

    public class Solution {
        ArrayList<Integer> ans = new ArrayList<Integer>() ;

        List<Integer> findSubstring(String s, String[] words) {
            StringBuilder sb = new StringBuilder(s) ;
            int wordLen = words[0].length() ;

            HashMap<String, Integer> counts = new HashMap<>() ;
            for (String word : words) {
                counts.put(word, (counts.containsKey(word))?(counts.get(word) + 1):(1)) ;
            }

            for(int i=0; i<s.length(); i++) {
                HashMap<String, Integer> copy = new HashMap<>() ;
                boolean is = true ;
                int j = i + wordLen*words.length ;
                if (j > s.length()) continue ;
                for (int k = i; k+wordLen <= j; k+=wordLen) {
                    // System.out.println("i: "+i+""+" j: "+j+" k: "+k) ;
                    String key = sb.substring(k, k+wordLen) ;
                    if (counts.get(key)==null || counts.get(key).equals(copy.get(key))) {
                        // not exits or not enough
                        is = false ;
                        break ;
                    } else {
                        // can
                        copy.put(key, (copy.get(key)!=null)?(copy.get(key)+1):(1)) ;
                    }
                }

                if (is) {
                    ans.add(i) ;
                }
            }

            return ans ;
        }
    }
}
