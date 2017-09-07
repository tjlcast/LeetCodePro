package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/2.
 */
public class _28_Implement_strStr {
    /**
     * Implement strStr().

     Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     */

    public static void main(String[] args) {
        String haystack = "adsfasdf" ;
        String needle = "sf" ;

        _28_Implement_strStr implement_strStr = new _28_Implement_strStr();
        int work = implement_strStr.work(haystack, needle);
        System.out.println("work is :" + work) ;
    }

    public int work(String haystack, String needle) {
        Solution solution = new Solution();
        int i = solution.strStr(haystack, needle);
        return i ;
    }

    class Solution {
        public int strStr(String haystack, String needle) {
            return haystack.indexOf(needle) ;
        }
    }
}
