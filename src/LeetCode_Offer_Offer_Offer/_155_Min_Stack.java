package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;

/**
 * Created by tangjialiang on 2017/12/17.
 */
public class _155_Min_Stack {
    /**
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

     push(x) -- Push element x onto stack.
     pop() -- Removes the element on top of the stack.
     top() -- Get the top element.
     getMin() -- Retrieve the minimum element in the stack.
     Example:
     MinStack minStack = new MinStack();
     minStack.push(-2);
     minStack.push(0);
     minStack.push(-3);
     minStack.getMin();   --> Returns -3.
     minStack.pop();
     minStack.top();      --> Returns 0.
     minStack.getMin();   --> Returns -2.
     */

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();// --> Returns -3.
        minStack.pop();
        int top = minStack.top();// --> Returns 0.
        int min1 = minStack.getMin();// --> Returns -2.
    }

    static class MinStack {

        private LinkedList<Integer> data = new LinkedList<>();
        private LinkedList<Integer> minData = new LinkedList<>() ;

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            data.addLast(x);

            int lastNum = (minData.isEmpty()) ? (Integer.MAX_VALUE) : (minData.getLast());
            minData.addLast(Math.min(x, lastNum));
        }

        public void pop() {
            data.removeLast() ;
            minData.removeLast() ;
        }

        public int top() {
            return data.getLast() ;
        }

        public int getMin() {
            return minData.getLast() ;
        }
    }
}
