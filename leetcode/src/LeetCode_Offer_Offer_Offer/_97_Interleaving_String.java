package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/25.
 */
public class _97_Interleaving_String {
    /**
     * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

     For example,
     Given:
     s1 = "aabcc",
     s2 = "dbbca",

     When s3 = "aadbbcbcac", return true.
     When s3 = "aadbbbaccc", return false.
     */

    public static void main(String[] args) {
        String s1 = "a" ;
        String s2 = "b" ;
        String s3 = "a" ;

        _97_Interleaving_String interleaving_string = new _97_Interleaving_String();
        boolean work = interleaving_string.work(s1, s2, s3);

        System.out.format("the work is: %b\n", work) ;
    }

    public boolean work(String s1, String s2, String s3) {
        Solution solution = new Solution();
        boolean interleave = solution.isInterleave(s1, s2, s3);
        return interleave ;
    }

    class Solution {
        private String s1 = null ;
        private String s2 = null ;
        private String s3 = null ;
        private int[][][] dp = null ;

        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1==null) s1 = "" ; if (s2==null) s2="" ; if (s3==null) s3="" ;
            if (s1.length()==0) return s2.equals(s3) ;
            if (s2.length()==0) return s1.equals(s3) ;
            if (s3.length()==0) {
                return false ;
            }

            this.s1 = s1 ;
            this.s2 = s2 ;
            this.s3 = s3 ;
            this.dp = new int[s1.length()+1][s2.length()+1][s3.length()+1] ;

            boolean b = preWordsSame(0, 0, 0);
            return b ;
        }

        private boolean preWordsSame(int pos1, int pos2, int pos3) {
            if (pos1==s1.length() && pos2==s2.length() && pos3==s3.length()) return true ;

            if (pos1<s1.length() && pos2<s2.length() && pos3<s3.length() && dp[pos1][pos2][pos3]!=0) {
                return (dp[pos1][pos2][pos3]==1) ? (true) : (false) ;
            }

            if (pos1<s1.length() && pos3<s3.length() && s1.charAt(pos1)==s3.charAt(pos3)) {
                boolean localAns = preWordsSame(pos1+1, pos2, pos3+1) ;
                if (localAns) {
                    dp[pos1][pos2][pos3] = 1 ;
                    return true ;
                }
            }

            if (pos2<s2.length() && pos3<s3.length() && s2.charAt(pos2)==s3.charAt(pos3)) {
                boolean localAns = preWordsSame(pos1, pos2+1, pos3+1) ;
                if(localAns) {
                    dp[pos1][pos2][pos3] = 1 ;
                    return true ;
                }
            }

            if (pos1<s1.length() && pos2<s2.length() && pos3<s3.length()) {
                dp[pos1][pos2][pos3] = -1 ;
            }

            return false ;
        }
    }
}
