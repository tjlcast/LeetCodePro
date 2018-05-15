package zz_to_to_offer.solution;

import java.util.Stack;     

/**
 * Created by tangjialiang on 2018/4/23.
 */
public class Solution21 {

    static public class Solution {
        public boolean IsPopOrder(int [] pushA,int [] popA) {
            Stack<Integer> stack = new Stack<>() ;

            int j = 0 ;
            for (int i = 0; i < popA.length ; i++) {
                int val = popA[i] ;

                while(j<pushA.length) {
                    stack.add(pushA[j++]) ;
                    if (stack.peek() == val) break ;
                }
                if (stack.isEmpty() || val!=stack.pop()) return false ;

            }

            if (j>=pushA.length && stack.size()==0) return true ;
            return false ;
        }
    }

    public static void main(String[] args) {
        int[] stackIn = {1,2,3,4,5} ;
        int[] stackOu = {4,5,3,2,1} ;

        Solution sol = new Solution() ;
        boolean b = sol.IsPopOrder(stackIn, stackOu);

        System.out.println(b) ;
    }
}
