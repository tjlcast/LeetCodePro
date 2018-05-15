package LeetCode_Offer_Offer_Offer;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/1/28.
 */
public class _232_Implement_Queue_using_Stacks {

    public static void main(String[] args) {
        int x = 10 ;

        MyQueue obj = new MyQueue();
        obj.push(x);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
    }

    static class MyQueue {

        Stack<Integer> stack = new Stack<>() ;
        Stack<Integer> tmpStack = new Stack<>() ;

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack.add(x) ;
        }

        private int getStackButton(boolean removeButton) {
            int button = -1 ;
            while(stack.size() > 1) {
                tmpStack.push(stack.pop()) ;
            }

            if (stack.size()==1) {
                if (removeButton) button = stack.pop() ;
                else button = stack.peek() ;
            }

            while(!tmpStack.isEmpty()) {
                stack.push(tmpStack.pop()) ;
            }

            return button ;
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return getStackButton(true) ;
        }

        /** Get the front element. */
        public int peek() {
            return getStackButton(false) ;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.isEmpty() ;
        }
    }
}
