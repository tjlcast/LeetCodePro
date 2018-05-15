package zz_to_to_offer.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by tangjialiang on 2018/4/25.
 */
public class Solution27 {
    static public class Solution {
        HashSet<String> set = new HashSet<>() ;

        public ArrayList<String> Permutation(String str) {
            generateSubStr(str.toCharArray(), 0) ;

            ArrayList<String> list = new ArrayList<>(set) ;
            Collections.sort(list);
            return list ;
        }

        private void generateSubStr(char[] chars, int pos) {
            for(int i=pos; i<chars.length; i++) {
                swap(chars, pos, i) ;
                if (pos+1<chars.length) generateSubStr(chars, pos+1);
                else {
                    set.add(new String(chars)) ;
                }
                swap(chars, pos, i) ;
            }
        }

        private void swap(char[] chars, int pos, int i) {
            char tmp = chars[pos] ;
            chars[pos] = chars[i] ;
            chars[i] = tmp ;
        }
    }

    public static void main(String[] args) {
        String str = "abc" ;

        Solution sol = new Solution() ;
        ArrayList<String> permutation = sol.Permutation(str);

        for (String s :
                permutation) {
            System.out.println(s) ;
        }
    }
}
