package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/1.
 */
public class _10_Regular_Expression_Matching {
    /**
     *
     * Implement regular expression matching with support for '.' and '*'.

     '.' Matches any single character.
     '*' Matches zero or more of the preceding element.

     The matching should cover the entire input string (not partial).

     The function prototype should be:
     bool isMatch(const char *s, const char *p)

     Some examples:
     isMatch("aa","a") → false
     isMatch("aa","aa") → true
     isMatch("aaa","aa") → false
     isMatch("aa", "a*") → true
     isMatch("aa", ".*") → true
     isMatch("ab", ".*") → true
     isMatch("aab", "c*a*b") → true
     */

    public static void main(String[] args) {
        String s = "ab" ;
        String p = ".*" ;
        _10_Regular_Expression_Matching regular_expression_matching = new _10_Regular_Expression_Matching();
        boolean work = regular_expression_matching.work(s, p);
        System.out.println("work is: " + work) ;
    }

    public boolean work(String s, String p) {
        Solution solution = new Solution();
        boolean match = solution.isMatch(s, p);
        return match ;
    }

    class Solution {
        /**
         * tips: 首先考虑*的相关操作。使用递归的操作，临界条件为当s与p都为""时返回true。
         *      每轮递归考虑s和p的第一字符。如果p的第一个字符没有*装饰：
         *                              如果p的第一个字符有*装饰，那么考虑 逐个"吃"掉s第一与p第一相同的字符。
         *
         *       有关*的操作结束后，在60行中，修改为"."字符可以替换
         *                       在66行中，修改"."字符可以"吃掉"任何字符
         */
        public boolean isMatch(String s, String p) {

            if (s.equals("") && p.equals("")) return true ;

            // sit1 : 当前判断不带*的规则
            if (!(p.length()>=2 && p.charAt(1)=='*')) {
                String headS = (s.length()==0) ? ("") : (s.substring(0, 1)) ;
                String headP = (p.length()==0) ? ("") : (p.substring(0, 1)) ;
                if (!headS.equals(headP) && !(p.length()>0 && s.length()>0 && p.charAt(0)=='.')) return false ; // border: 当s为空时。其p中匹配不到*时，肯定不能匹配。
                return isMatch(s.substring(1), p.substring(1)) ;
            }

            // sit2 : 当前判断带有*的规则
            boolean b = false ;
            if (s.equals("") || (p.charAt(0)!='.' && s.charAt(0)!=p.charAt(0))) {
                // 通过这个判断删掉pattern中的*号
                b = b || isMatch(s, p.substring(2)) ;
            } else {
                b = b || isMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
            }
            return b ;
        }
    }
}
