package zz_to_to_offer.solution;

/**
 * Created by tangjialiang on 2018/3/26.
 */

import java.util.* ;

public class Solution04 {

    public static void main(String[] args) {

    }

    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            // push to stack1
            stack1.push(node) ;
        }

        public int pop() {
            // pop from stack2 (if stack2 is not empty or stack1 --> stack2)
            if (stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop()) ;
                }
            }
            return stack2.pop() ;
        }
    }
}
