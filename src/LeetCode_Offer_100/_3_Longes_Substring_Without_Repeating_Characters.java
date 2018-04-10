package LeetCode_Offer_100;

import java.util.*;
import static java.lang.Math.min ;
import static java.lang.Math.max ;

/**
 * Created by tangjialiang on 2018/2/28.
 */
public class _3_Longes_Substring_Without_Repeating_Characters {

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int ans = 0 ;

            int l=0 ;
            int r=0 ;
            LinkedHashMap<Character, Integer> set = new LinkedHashMap<>() ;

            while(r < s.length()) {
                char c = s.charAt(r) ;
                Iterator<Map.Entry<Character, Integer>> iterator = set.entrySet().iterator();
                while (set.containsKey(c)) {
                    if (iterator.hasNext()) iterator.next() ;
                    iterator.remove();
                    l++ ;
                }
                set.put(c, 1) ;
                ans = max(r-l+1, ans) ;
                r++ ;
            }

            return ans ;
        }
    }

    public static void main(String[] args){
        String str = "dvdf" ;

        Solution sol = new Solution() ;
        int i = sol.lengthOfLongestSubstring(str);

        System.out.println("The ans is: " + i) ;
    }
}
