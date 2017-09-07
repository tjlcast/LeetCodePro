package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/4.
 *
 */
public class _44_Wildcard_Matching {
    /**
     * Implement wildcard pattern matching with support for '?' and '*'.

     '?' Matches any single character.
     '*' Matches any sequence of characters (including the empty sequence).

     The matching should cover the entire input string (not partial).

     The function prototype should be:
     bool isMatch(const char *s, const char *p)

     Some examples:
     isMatch("aa","a") → false
     isMatch("aa","aa") → true
     isMatch("aaa","aa") → false
     isMatch("aa", "*") → true
     isMatch("aa", "a*") → true
     isMatch("ab", "?*") → true
     isMatch("aab", "c*a*b") → false
     */

    public static void main(String[] args) {
        String s= "babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb" ;

        String p = "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a" ;

        _44_Wildcard_Matching wildcard_matching = new _44_Wildcard_Matching();
        boolean work = wildcard_matching.work(s, p);

        System.out.println("work is: " + work) ;
    }

    public boolean work(String s, String p) {
        Solution solution = new Solution();
        boolean match = solution.isMatch(s, p);
        return match ;
    }

    class Solution {
        boolean[][] dp = null ;

        public boolean isMatch(String s, String p) {
            dp = new boolean[s.length()+1][p.length()+1] ;

            // border condition
            for(int iS=0; iS<s.length(); iS++) {
                dp[iS][0] = false ;
            }
            dp[0][0] = true ;

            //
            for(int lp=1; lp<=p.length(); lp++) {
                dp[0][lp] = dp[0][lp-1] && p.charAt(lp-1)=='*' ;
                for(int ls=1; ls<=s.length(); ls++){
                    if (p.charAt(lp-1)=='?' || s.charAt(ls-1)==p.charAt(lp-1)) {
                        dp[ls][lp] = dp[ls-1][lp-1] ;
                    }
                    if (p.charAt(lp-1)=='*') {
                        dp[ls][lp] = dp[ls-1][lp] || dp[ls][lp-1] ;
                    }
                }
            }

            return dp[s.length()][p.length()] ;
        }
    }

    class Solution1 {
        // flag: time out

        private boolean myMatch (String s, String p) {

            if (s.equals("") && p.equals("")) return true ;
            if (!s.equals("") && p.equals("")) return false ;

            // by the p str's head character
            char head = p.charAt(0);
            if (head != '*') {
                // not *
                if (s.equals("")) return false ;
                if (s.charAt(0) != head && p.charAt(0)!='?') return false ;
                return myMatch(s.substring(1), p.substring(1)) ;
            } else {
                // is *
                boolean flag = false ;
                flag = flag || myMatch(s, p.substring(1)) ;
                if (!s.equals(""))flag = flag || myMatch(s.substring(1), p) ;
                return flag ;
            }
        }

        public boolean isMatch(String s, String p) {

            // pre work
            StringBuilder sb = new StringBuilder() ;
            char lastChar = '.' ;
            for(int i=0; i<p.length(); i++) {
                if (lastChar=='*' && p.charAt(i)=='*') {
                    lastChar = p.charAt(i) ;
                    continue;
                }
                sb.append(p.charAt(i)) ;
                lastChar = p.charAt(i) ;
            }
            p = sb.toString() ;
            System.out.println("p is: " + p) ;

            return myMatch(s, p) ;
        }
    }
}
