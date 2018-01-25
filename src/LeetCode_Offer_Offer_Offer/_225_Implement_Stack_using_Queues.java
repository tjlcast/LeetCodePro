package LeetCode_Offer_Offer_Offer;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/1/25.
 */
public class _225_Implement_Stack_using_Queues {

    public static void main(String[] args) {
        int x = 1 ;
        MyStack obj = new MyStack();
        obj.push(x);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
    }

    static class MyStack {

        private LinkedList<Integer> queue = new LinkedList<>() ;
        private LinkedList<Integer> tmpQueue = new LinkedList<>() ;

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.addLast(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {

            while(!queue.isEmpty()) {
                tmpQueue.addLast(queue.pop()) ;
            }

            while(tmpQueue.size() > 1) {
                queue.addLast(tmpQueue.pop()) ;
            }

            if (!tmpQueue.isEmpty()) {
                return tmpQueue.pop() ;
            }

            return  -1 ;
        }

        /** Get the top element. */
        public int top() {
            int ans = -1 ;
            while(!queue.isEmpty()) {
                tmpQueue.addLast(queue.pop()) ;
            }

            while(tmpQueue.size() > 1) {
                queue.addLast(tmpQueue.pop()) ;
            }

            if (!tmpQueue.isEmpty()) {
                 ans = tmpQueue.pop() ;
                 queue.addLast(ans);
            }
            return ans ;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty() ;
        }
    }


}
