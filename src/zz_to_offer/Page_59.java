package zz_to_offer;

import java.util.Stack;

/**
 * Created by tangjialiang on 2017/8/22.
 */
public class Page_59 {

    /**
     * 用两个栈实现一个队列，队列的申明如下，
     * 请实现他的两个函数appendTail和deleteHead,分别完成在队列尾部插入节点和在队列头部删除节点的功能。
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7} ;
        MySolution sol = new Page_59().getSolution() ;
        for(Integer i: nums) {
            sol.add(i);
        }

        while(!sol.isEmpty()) {
            int pop = sol.pop();
            System.out.println(pop) ;
        }
    }


    public MySolution getSolution() {
        return new MySolution() ;
    }


    public class MySolution{
        /**
         * tips: 数据存储仍然使用栈，"入"操作仍然使用栈的push操作，"出"操作
         * 时使用另一个栈来把栈底数据取出。
         */
        Stack<Integer> stackA = new Stack<>() ; // to store data
        Stack<Integer> stackB = new Stack<>() ; // to modify the seq

        public void add(int num) {
            stackA.add(num) ;
        }

        public boolean isEmpty() {
            return stackA.isEmpty() ;
        }

        public int pop() {
            while(!stackA.isEmpty()) {
                Integer pop = stackA.pop();
                stackB.add(pop) ;
            }

            Integer pop = stackB.pop();

            while(!stackB.isEmpty()) {
                int b = stackB.pop() ;
                stackA.add(b) ;
            }

            return pop ;
        }

    }
}
