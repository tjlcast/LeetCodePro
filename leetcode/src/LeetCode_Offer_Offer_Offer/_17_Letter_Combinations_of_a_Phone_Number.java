package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/2.
 */
public class _17_Letter_Combinations_of_a_Phone_Number {
    /**
     * Given a digit string, return all possible letter combinations that the number could represent.

     A mapping of digit to letters (just like on the telephone buttons) is given below.



     Input:Digit string "23"
     Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     Note:
     Although the above answer is in lexicographical order, your answer could be in any order you want.
     */
    public static void main(String[] args) {
        String digits = "" ;
        _17_Letter_Combinations_of_a_Phone_Number letter_combinations_of_a_phone_number = new _17_Letter_Combinations_of_a_Phone_Number();
        List<String> work = letter_combinations_of_a_phone_number.work(digits);
        System.out.println("work is: " + work) ;
    }

    public List<String> work(String digits) {
        Solution solution = new Solution();
        List<String> strings = solution.letterCombinations(digits);
        return strings ;
    }

    class Solution {
        private String[][] mapper = {
                {""},
                {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"},
                {"j", "k", "l"},
                {"m", "n", "o"},
                {"p", "q", "r", "s"},
                {"t", "u", "v"},
                {"w", "x", "y", "z"},
        } ;
        private LinkedList<String> prefixStrs = new LinkedList<>() ;
        private String digits = null ;

        public List<String> letterCombinations(String digits) {
            if (digits==null || digits.length()==0) return prefixStrs ;
            this.digits = digits ;
            addChar2PrefixString("", 0);
            return prefixStrs ;
        }

        private void addChar2PrefixString(String prefixString, int pos) {
            if (pos==digits.length()) {
                prefixStrs.add(prefixString) ;
                return ;
            }

            int i = Integer.parseInt(digits.charAt(pos) + "");
            List<String> integerChar = getIntegerChar(i);

            for(String word : integerChar) {
                addChar2PrefixString(prefixString+word, pos+1);
            }

            return ;
        }

        private List<String> getIntegerChar(int num) {
            List<String> line = new LinkedList<>() ;
            for(String c : mapper[num-1]){
                line.add(c) ;
            }
            return line ;
        }
    }
 }