package zz_to_offer;

import java.util.Stack;

/**
 * Created by tangjialiang on 2017/8/24.
 */
public class Page_132 {
    /**
     * 定义栈的数据结构，该类型中实现一个能够得到栈的最小元素的min函数，min/push/pop时间复杂度为O（1）
     * @param args
     */
    public static void main(String[] args) {
        new Page_132().work();
    }

    public void work() {
        StackWithMin stackWithMin = new StackWithMin();
        System.out.println("top: " + stackWithMin.peek() + " min: " + stackWithMin.min()) ;
        stackWithMin.push(3) ;
        System.out.println("top: " + stackWithMin.peek() + " min: " + stackWithMin.min()) ;
        stackWithMin.push(4) ;
        System.out.println("top: " + stackWithMin.peek() + " min: " + stackWithMin.min()) ;
        stackWithMin.push(2) ;
        System.out.println("top: " + stackWithMin.peek() + " min: " + stackWithMin.min()) ;
        stackWithMin.push(1) ;
        System.out.println("top: " + stackWithMin.peek() + " min: " + stackWithMin.min()) ;
        stackWithMin.pop() ;
        System.out.println("top: " + stackWithMin.peek() + " min: " + stackWithMin.min()) ;
        stackWithMin.pop() ;
        System.out.println("top: " + stackWithMin.peek() + " min: " + stackWithMin.min()) ;
        stackWithMin.push(0) ;
        System.out.println("top: " + stackWithMin.peek() + " min: " + stackWithMin.min()) ;
    }

    class StackWithMin {
        /**
         * 根据栈的性质，使用另一个栈记录当前push操作后，stack中的最小值。
         */

        private Stack<Integer> stack = new Stack<Integer>() ;
        private Stack<Integer> pushStackMin = new Stack<Integer>() ;

        public void push(int i) {
            stack.add(i) ;
            if (!pushStackMin.isEmpty()) {
                int top = pushStackMin.peek();
                pushStackMin.add(Math.min(top, i));
            } else
                pushStackMin.add(i) ;

            return;
        }

        public int min() {
            if (pushStackMin.isEmpty()) return Integer.MIN_VALUE ;
            return pushStackMin.peek() ;
        }

        public int pop() {
            Integer pop = stack.pop();
            pushStackMin.pop() ;
            return pop ;
        }

        public int peek() {
            if (stack.isEmpty()) return Integer.MIN_VALUE ;
            return stack.peek() ;
        }
    }
}
