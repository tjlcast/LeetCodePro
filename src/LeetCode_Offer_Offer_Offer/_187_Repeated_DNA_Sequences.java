package LeetCode_Offer_Offer_Offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/12/28.
 */
public class _187_Repeated_DNA_Sequences {
    /**
     * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

     Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

     For example,

     Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

     Return:
     ["AAAAACCCCC", "CCCCCAAAAA"].
     */

    public static void main(String[] args) {
        String s = "AAAAAAAAAAAA" ;

        Solution solution = new Solution();
        List<String> repeatedDnaSequences = solution.findRepeatedDnaSequences(s);

        for(String word : repeatedDnaSequences) {
            System.out.println(word) ;
        }
    }

    static class Solution {
        private HashSet<String> ans = new HashSet<String>() ;
        private HashSet<String> recorder = new HashSet<String>() ;

        public List<String> findRepeatedDnaSequences(String s) {

            for(int i=0; i+10-1<s.length(); i++) {
                String subStr = s.substring(i, i+10) ;
                if (recorder.contains(subStr)) {
                    ans.add(subStr) ;
                } else {
                    recorder.add(subStr) ;
                }
            }

            List<String> list = new LinkedList<>();
            list.addAll(ans) ;

            return list ;
        }
    }
}
