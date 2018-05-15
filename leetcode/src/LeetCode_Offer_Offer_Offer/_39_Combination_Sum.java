package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by tangjialiang on 2017/9/4.
 *
 */
public class _39_Combination_Sum {
    /**
     * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

     The same repeated number may be chosen from C unlimited number of times.

     Note:
     All numbers (including target) will be positive integers.
     The solution set must not contain duplicate combinations.
     For example, given candidate set [2, 3, 6, 7] and target 7,
     A solution set is:
     [
     [7],
     [2, 2, 3]
     ]
     */

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7} ;
        int target = 7 ;

        _39_Combination_Sum combination_sum = new _39_Combination_Sum();
        List<List<Integer>> work = combination_sum.work(candidates, target);

        System.out.println("work is: ") ;
        for(List<Integer> line : work) {
            for(Integer i : line) {
                System.out.print(i + " ") ;
            }
            System.out.println() ;
        }
    }

    public List<List<Integer>> work(int[] candidates, int target) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum(candidates, target);
        return lists ;
    }

    class Solution {
        private List<List<Integer>> ansList = new LinkedList<>() ;
        private Stack<Integer> stack = new Stack<>() ;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            doWork(candidates, 0, target);
            return ansList ;
        }

        private void doWork(int[] candidates, int s,  int rest) {
            if (rest == 0) {
                LinkedList<Integer> objects = new LinkedList<>();
                objects.addAll(stack);
                ansList.add(objects) ;
            }

            for(int i=s; i<candidates.length; i++) { // give i , is very nice !!!
                int num = candidates[i] ;
                stack.add(num) ;
                if (rest - num >= 0)
                    doWork(candidates, i, rest-num);
                stack.pop() ;
            }
        }
    }
}
