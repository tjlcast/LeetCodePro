package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/2.
 */
public class _22_Generate_Parentheses {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

     For example, given n = 3, a solution set is:

     [
     "((()))",
     "(()())",
     "(())()",
     "()(())",
     "()()()"
     ]
     */

    public static void main(String[] args) {
        int n = 3 ;

        List<String> work = new _22_Generate_Parentheses().work(n);

        System.out.println("work is: ") ;
        for(String str: work) {
            System.out.println(str) ;
        }
    }

    public List<String> work(int n) {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(n);
        return strings ;
    }

    class Solution {
        private List<String> ans = new LinkedList<>() ;
        private int n = -1 ;

        public List<String> generateParenthesis(int n) {
            this.n = n ;
            goNext("", n, n);
            return ans ;
        }

        private void goNext(String prefix, int total, int rest) {
            if (rest == 0 && total==0) {
                ans.add(prefix) ;
            }

            if (total > 0)goNext(prefix+"(", total-1, rest);
            if (total < rest)goNext(prefix+")", total, rest-1);
        }
    }
}
