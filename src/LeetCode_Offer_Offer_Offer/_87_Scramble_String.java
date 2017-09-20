package LeetCode_Offer_Offer_Offer;

import java.util.Stack;

/**
 * Created by tangjialiang on 2017/9/19.
 *
 */
public class _87_Scramble_String {
    /**
     * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

     Below is one possible representation of s1 = "great":

     great
     /    \
     gr    eat
     / \    /  \
     g   r  e   at
     / \
     a   t
     To scramble the string, we may choose any non-leaf node and swap its two children.

     For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

     rgeat
     /    \
     rg    eat
     / \    /  \
     r   g  e   at
     / \
     a   t
     We say that "rgeat" is a scrambled string of "great".

     Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

     rgtae
     /    \
     rg    tae
     / \    /  \
     r   g  ta  e
     / \
     t   a
     We say that "rgtae" is a scrambled string of "great".

     Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
     */

    public static void main(String[] args) {
//        String s1 = "great" ; // true
//        String s2 = "rgtae" ;

//        String s1 = "abc" ; // true
//        String s2 = "bca" ;

//        String s1 = "abc" ; // true
//        String s2 = "cab" ;

//        String s1 = "great" ; // false
//        String s2 = "rtage" ;

        String s1 = "cd" ; // false
        String s2 = "ab" ;

        _87_Scramble_String scramble_string = new _87_Scramble_String();
        boolean work = scramble_string.work(s1, s2);

        System.out.println("work is: " + work) ;
    }

    public boolean work(String s1, String s2) {
        Solution solution = new Solution();
        boolean scramble = solution.isScramble(s1, s2);

        return scramble ;
    }

    class Solution {
        /**
         * 如果两个字符串是Scramble String，则其长度必然相等。
         * 而且，在某位置切开s1，则s1左侧与s2左侧相同数量的子串为Scramble String，
         * 并且s1右侧与s2右侧相同数量的子串为Scramble String；
         * 或者s1左侧与s2右侧相同数量的子串为Scramble String，
         * 并且s1右侧与s2左侧相同数量的子串为Scramble String。
         */
        private int len = -1 ;
        private String s1 = null ;
        private String s2 = null ;
        private int[][][] dp = null ;

        public boolean isScramble(String s1, String s2) {
            this.len = s1.length() ;
            this.s1 = s1 ;
            this.s2 = s2 ;
            dp = new int[len][len][len+1] ;

            boolean b = myIsScramble(0, 0, len);
            return b ;
        }


        private boolean myIsScramble(int i, int j, int l) {
            if (l==0) return false ;
            if (l==1) {
                if (s1.charAt(i) == s2.charAt(j)) return true ;
                else return false ;
            }
            if (dp[i][j][l]!=0) return (dp[i][j][l]==1) ? (true) : (false) ;

            boolean res = false ;
            for(int k=1; k<l; k++) {
                res = res || (myIsScramble(i, j, k) && myIsScramble(i+k, j+k, l-k)) ;
                res = res || (myIsScramble(i, j+k, l-k) && myIsScramble(i+l-k, j, k));
                if (res) {
                    dp[i][j][l] = 1 ;
                    return true ;
                }
            }
            dp[i][j][l] = -1 ;
            return false ;
        }
    }
}
