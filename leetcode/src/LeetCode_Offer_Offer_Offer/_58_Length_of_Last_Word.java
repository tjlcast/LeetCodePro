package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/8.
 */
public class _58_Length_of_Last_Word {
    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

     If the last word does not exist, return 0.

     Note: A word is defined as a character sequence consists of non-space characters only.

     For example,
     Given s = "Hello World",
     return 5.
     */

    public static void main(String[] args) {
        String s = " " ;

        _58_Length_of_Last_Word length_of_last_word = new _58_Length_of_Last_Word();
        int work = length_of_last_word.work(s);

        System.out.println("work is: " + work) ;
    }

    public int work(String s) {
        Solution solution = new Solution();
        int i = solution.lengthOfLastWord(s);
        return i ;
    }

    class Solution {
        public int lengthOfLastWord(String s) {
            if (s==null || s.length()==0) return 0 ;

            String[] split = s.split(" ");
            if (split==null || split.length==0) return 0 ;
            int length = split[split.length - 1].length();

            return length ;
        }
    }
}
