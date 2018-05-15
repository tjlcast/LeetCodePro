package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/2.
 */
public class _14_Longest_Common_Prefix {
    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     */

    public static void main(String[] args) {
        String[] strs = {"apple", "application", "app"} ;

        _14_Longest_Common_Prefix longest_common_prefix = new _14_Longest_Common_Prefix();
        String work = longest_common_prefix.work(strs);

        System.out.println("work is: " + work) ;
    }

    public String work(String[] strs) {
        Solution solution = new Solution();
        String s = solution.longestCommonPrefix(strs);
        return s ;
    }

    class Solution {
        String preifxStr = "" ;

        public String longestCommonPrefix(String[] strs) {
            if (strs==null || strs.length==0) return preifxStr ;

            int pos = 0 ;
            while(true) {
                if(isSameChar(strs, pos)==false) break ;
                preifxStr = strs[0].substring(0, pos + 1);

                pos += 1 ;
            }
            return preifxStr ;
        }

        private boolean isSameChar(String[] strs, int pos) {
            Character lastChar = null ;
            for(String str: strs) {
                if (pos >= str.length()) return false ;
                if(lastChar==null) lastChar = str.charAt(pos) ;
                if (str.charAt(pos) != lastChar) return false ;
            }

            return true ;
        }
    }
}
