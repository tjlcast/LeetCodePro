package zz_to_offer;

import java.util.LinkedList;

/**
 * Created by tangjialiang on 2017/8/22.
 */
public class Page_61 {
    /**
     * 使用两个队列实现一个栈。
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7} ;
        MySolution solution = new Page_61().getSolution();
        for(int num: nums) {
            solution.add(num);
        }
        
        while(!solution.isEmpty()) {
            int pop = solution.pop();
            System.out.println(pop) ;
        }
    }

    public MySolution getSolution() {
        return new MySolution() ;
    }


    public class MySolution {
        /**
         * tips: 使用一个队列存储数据，另一作为额外操作队列。
         * 在"add"操作时，把新数据先加入到额外队列中，在把存储队列中的数据全部存入额外队列中。
         * 最后在全部导入存储队列中。
         */
        private LinkedList<Integer> queueA = new LinkedList<>() ; // to store datas
        private LinkedList<Integer> queueB = new LinkedList<>() ; // to change the sequeue

        public void add(int num) {
            queueB.add(num) ;
            while(!queueA.isEmpty()) {
                queueB.add(queueA.pop()) ;
            }

            while(!queueB.isEmpty()) {
                queueA.add(queueB.pop()) ;
            }
        }

        public int pop() {
            return queueA.removeFirst() ;
        }

        public boolean isEmpty() {
            return queueA.isEmpty() ;
        }
    }
}
