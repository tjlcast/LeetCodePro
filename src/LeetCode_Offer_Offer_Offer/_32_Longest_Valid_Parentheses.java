package LeetCode_Offer_Offer_Offer;

import java.util.Stack;

/**
 * Created by tangjialiang on 2017/9/3.
 */
public class _32_Longest_Valid_Parentheses {
    /**
     * Given a string containing just the characters '(' and ')',
     * find the length of the longest valid (well-formed) parentheses substring.

     For "(()", the longest valid parentheses substring is "()", which has length = 2.

     Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
     */

    public static void main(String[] args) {
        String s = "(()" ;
        _32_Longest_Valid_Parentheses longest_valid_parentheses = new _32_Longest_Valid_Parentheses();
        int work = longest_valid_parentheses.work(s);
        System.out.println("work is: " + work) ;
    }

    public int work(String s) {
        Solution solution = new Solution();
        int i = solution.longestValidParentheses(s);
        return i ;
    }

    class Solution {
        /**
         * tips: 使用两个栈，一个记录
         */
        private Stack<Character> opStack = new Stack<>() ;
        private Stack<Integer> posStack = new Stack<>() ;
        private int maxLen = Integer.MIN_VALUE ;

        public int longestValidParentheses(String s) {

            opStack.add('*') ;
            posStack.add(-1) ;

            if (s==null || s.length()==0) return 0 ;

            opStack.add(s.charAt(0)) ;
            posStack.add(0) ;

            for(int i=1; i<s.length(); i++) {
                char c = s.charAt(i);
                if (c=='(') {
                    opStack.add(c) ;
                    posStack.add(i) ;
                } else {
                    Character peek = opStack.peek();
                    if (peek=='(') {
                        opStack.pop() ;
                        posStack.pop() ;
//                        int begin = (posStack.isEmpty()) ? (-1) : (posStack.peek()) ;
//                        maxLen = (i - begin > maxLen) ? (i - begin) : (maxLen) ;
                        maxLen = (i - posStack.peek() > maxLen) ? (i - posStack.peek()) : (maxLen) ;
                    } else {
                        opStack.add(c) ;
                        posStack.add(i) ;
                    }
                }
            }

            return (maxLen==Integer.MIN_VALUE)?(0):(maxLen) ;
        }
    }
}
