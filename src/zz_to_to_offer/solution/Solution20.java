package zz_to_to_offer.solution;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/3/28.
 */
public class Solution20 {

    static public class Solution {

        private Stack<Integer> stackData = new Stack<>() ;
        private Stack<Integer> stackMin = new Stack<>() ;

        public void push(int node) {
            stackData.push(node) ;
            if (stackMin.isEmpty()) stackMin.add(node) ;
            else {
                Integer peek = stackMin.peek();
                stackMin.push(Math.min(peek, node)) ;
            }
        }

        public void pop() {
            stackData.pop() ;
            stackMin.pop() ;
        }

        public int top() {
            return stackData.peek() ;
        }

        public int min() {
            return stackMin.peek() ;
        }
    }

    public static void main(String[] args) {

    }
}
