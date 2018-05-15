package ArrayAndString;

/**
 * Created by tangjialiang on 17/5/10.
 */
public class _28_Implement_strStr {
    public static void main(String[] args) {

    }

    int work(String haystack, String needle) {
        return new Solution().strStr(haystack, needle) ;
    }

    class Solution {
        int strStr(String haystack, String needle) {
            return haystack.indexOf(needle) ;
        }
    }
}
