package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;

/**
 * Created by tangjialiang on 2017/12/13.
 */
public class _150_Evaluate_Reverse_Polish_Notation {

    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

     Valid operators are +, -, *, /. Each operand may be an integer or another expression.

     Some examples:
     ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     */

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"} ;

        Solution solution = new Solution();
        int i = solution.evalRPN(tokens);

        System.out.println("work is: " + i) ;
    }

    static class Solution {
        public int evalRPN(String[] tokens) {
            LinkedList<Integer> nums = new LinkedList<>() ;

            for(String token : tokens) {
                int num = -1 ;
                if(isNum(token)) {
                    num = Integer.parseInt(token) ;
                } else {
                    Integer integer2 = nums.removeLast();
                    Integer integer1 = nums.removeLast();
                    if (token.equals("+")) {
                        num = integer1 + integer2 ;
                    } else if (token.equals("-")) {
                        num = integer1 - integer2 ;
                    } else if (token.equals("*")) {
                        num = integer1 * integer2 ;
                    } else if (token.equals("/")) {
                        num = integer1 / integer2 ;
                    } else {
                        System.out.println("Unknown error.") ;
                    }
                }
                nums.addLast(num);
            }

            Integer integer = nums.removeLast();
            return integer ;
        }

        private boolean isNum(String token) {
            try {
                Integer.parseInt(token) ;
                return true ;
            } catch (Exception e) {

            }
            return false ;
        }
    }
}
