package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/12/25.
 */
public class _165_Compare_Version_Numbers {
    /**
     * Compare two version numbers version1 and version2.
     If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

     You may assume that the version strings are non-empty and contain only digits and the . character.
     The . character does not represent a decimal point and is used to separate number sequences.
     For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

     Here is an example of version numbers ordering:

     0.1 < 1.1 < 1.2 < 13.37
     */

    public static void main(String[] args) {
        String version1 = "1" ;
        String version2 = "1.1" ;

        int i = new Solution().compareVersion(version1, version2);
        System.out.println("the work is : " + i) ;
    }

    static class Solution {
        public int compareVersion(String version1, String version2) {
            if (version1 == null) version1 = "" ;
            if (version2 == null) version2 = "" ;

            String[] version1Arr = version1.split("\\.");
            String[] version2Arr = version2.split("\\.");
            int maxLen = Math.max(version1Arr.length, version2Arr.length);

            int count1 = 0 ;
            int count2 = 0 ;
            for(int i=0; i<maxLen; i++) {
                if (i < version1Arr.length) count1 += Integer.parseInt(version1Arr[i]) ;
                if (i < version2Arr.length) count2 += Integer.parseInt(version2Arr[i]) ;

                if (count1 > count2) return 1 ;
                else if (count1 < count2) return -1 ;
            }

            return 0 ;
        }
    }
}
