package zz_to_to_offer.page;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tangjialiang on 2018/2/27.
 */
public class Page61 {
    /*
    * 使用两个队列实现栈
    * */

    static class MyStack<T> {
        private Queue<T> queue1 = new LinkedList<>() ;
        private Queue<T> queue2 = new LinkedList<>() ;

        public void appendHead(T node) {
            if (!queue2.isEmpty()) {
                queue2.add(node) ;
            } else {
                queue1.add(node) ;
            }
        }

        public T removeHead() {
            if (!queue2.isEmpty()) {
                while(queue2.size() > 1) {
                    queue1.add(queue2.remove()) ;
                }
                if (queue2.size() == 1) return queue2.remove() ;
            } else {
                while(queue1.size() > 1) {
                    queue2.add(queue1.remove()) ;
                }
                if (queue1.size() == 1) return queue1.remove() ;
            }
            return null ;
        }

        public boolean isEmpty() {
            return queue1.isEmpty() && queue2.isEmpty() ;
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> queue = new MyStack<>() ;
        queue.appendHead(1);
        queue.appendHead(2);
        queue.appendHead(3);

        System.out.println(queue.removeHead()) ;
        queue.appendHead(4);
        System.out.println(queue.removeHead()) ;
        queue.appendHead(5);
        System.out.println(queue.removeHead()) ;

        while(!queue.isEmpty()) {
            System.out.println(queue.removeHead()) ;
        }
    }
}
