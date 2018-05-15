package LeetCode_Offer_Offer_Offer;

import java.util.Stack;

/**
 * Created by tangjialiang on 2017/9/2.
 */
public class _20_Valid_Parentheses {
    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

     The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     */

    public static void main(String[] args){
        String s = "}" ;
        _20_Valid_Parentheses valid_parentheses = new _20_Valid_Parentheses();
        boolean work = valid_parentheses.work(s);
        System.out.println("work is: " + work) ;
    }

    public boolean work(String s) {
        Solution solution = new Solution();
        boolean valid = solution.isValid(s);
        return valid ;
    }

    class Solution {
        private Stack<Character> stack = new Stack<>() ;

        public boolean isValid(String s) {
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if (c=='(' || c=='{' || c=='[') {
                    stack.add(c) ;
                } else {
                    if (stack.size()==0) return false ;
                    if (c==')' && stack.peek()!='(') return false ;
                    if (c==']' && stack.peek()!='[') return false ;
                    if (c=='}' && stack.peek()!='{') return false ;
                    stack.pop() ;
                }
            }

            if (stack.size()!=0) return false ;
            return true ;
        }
    }
}
