package zz_to_to_offer.page;

import java.util.Stack;

/**
 * Created by tangjialiang on 2018/2/26.
 */
public class Page59 {
    /*
    * 使用两个栈实现一个队列
    * */

    static class MyQueue<T> {
        Stack<T> stack1 = new Stack<>() ;
        Stack<T> stack2 = new Stack<>() ; // 为最早元素的出列顺序

        public void appendTail(T node) {
            stack1.push(node) ;
        }

        public T removeHead() {
            if (stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop()) ;
                }
            }

            return stack2.pop() ;
        }

        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty() ;
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>() ;
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);

        System.out.println(queue.removeHead()) ;
        queue.appendTail(4);
        System.out.println(queue.removeHead()) ;
        queue.appendTail(5);
        System.out.println(queue.removeHead()) ;

        while(!queue.isEmpty()) {
            System.out.println(queue.removeHead()) ;
        }
    }
}
