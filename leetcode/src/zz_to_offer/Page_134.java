package zz_to_offer;

import java.util.Stack;

/**
 * Created by tangjialiang on 2017/8/24.
 */
public class Page_134 {
    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，判断第二个序列是否为该栈的弹出顺序。
     */

    public static void main(String[] args) {
        int[] inputNums = {1, 2, 3, 4, 5} ;
        // int[] ouputNums = {4, 5, 3, 2, 1} ;
        int[] ouputNums = {4, 3, 5, 1, 2} ;

        boolean work = new Page_134().work(inputNums, ouputNums);
        System.out.println("work is: " + work) ;
    }

    public boolean work(int[] inputNums, int[] outputNUms) {
        return new MySolution().isInOut(inputNums, outputNUms) ;
    }

    class MySolution {
        /**
         * 如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。如果下一个弹出的数字不在栈顶，我们把压栈序列中还没有入栈的数字压入辅助
         * 栈，直到把下一个需要弹出的数字压入栈为止。如果所有的数字都压入栈了仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。
         */
        private Stack<Integer> stack = new Stack<>() ;

        public boolean isInOut(int[] inputNums, int[] outputNums) {
            int posI = 0 ;
            int posO = 0 ;

            while(posO<outputNums.length) {
                int stackTopElse = getStackTopElse(-1);
                if (stackTopElse == outputNums[posO]) {
                    stack.pop() ;
                    posO++ ;
                } else {
                    while(posI<inputNums.length && inputNums[posI]!=outputNums[posO]) {
                        stack.add(inputNums[posI]) ;
                        posI++ ;
                    }
                    if (posI >= inputNums.length) return false ;
                    stack.add(inputNums[posI++]) ;
                }
            }

            if (posI==inputNums.length && stack.isEmpty()) return true ;
            return false ;
        }

        private int getStackTopElse(int defaultNum) {
            if (stack.isEmpty()) return defaultNum ;
            return stack.peek() ;
        }
    }
}
