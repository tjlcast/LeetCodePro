package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by tangjialiang on 2017/9/4.
 */
public class _40_Combination_Sum_II {
    /**
     * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

     Each number in C may only be used once in the combination.

     Note:
     All numbers (including target) will be positive integers.
     The solution set must not contain duplicate combinations.
     For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
     A solution set is:
     [
     [1, 7],
     [1, 2, 5],
     [2, 6],
     [1, 1, 6]
     ]
     */

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5} ;
        int target = 8 ;

        _40_Combination_Sum_II combination_sum = new _40_Combination_Sum_II();
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
        List<List<Integer>> lists = solution.combinationSum2(candidates, target);
        return lists ;
    }

    class Solution {
        private List<List<Integer>> ansList = new LinkedList<>() ;
        private Stack<Integer> stack = new Stack<>() ;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            doWork(candidates, 0, target);
            return ansList ;
        }

        private void doWork(int[] candidates, int s,  int rest) {
            if (rest == 0) {
                LinkedList<Integer> objects = new LinkedList<>();
                objects.addAll(stack);
                if(!ansList.contains(objects))
                    ansList.add(objects) ;
            }
            if (s>=candidates.length) return ;

            int num = candidates[s] ;

            stack.add(num) ;
            if (rest-num>=0) doWork(candidates, s+1, rest-num);
            stack.pop() ;

            doWork(candidates, s+1, rest);
        }
    }
}
