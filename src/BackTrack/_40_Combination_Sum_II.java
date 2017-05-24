package BackTrack;

import java.util.*;

/**
 * Created by tangjialiang on 2017/5/24.
 *
 *
 */
public class _40_Combination_Sum_II {

    public static void main(String[] args) {
        int[] candidates = {1} ;
        int target = 1 ;
        List<List<Integer>> work = new _40_Combination_Sum_II().work(candidates, target);
        System.out.println(work.toString()) ;
    }

    public List<List<Integer>> work(int[] candidates, int target) {
        return new Solution().combinationSum2(candidates, target) ;
    }

    public class Solution {
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>() ;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            LinkedList<Integer> l = new LinkedList<>() ;
            dfs(candidates, target, l, candidates.length-1);

            return ans ;
        }

        private void dfs(int[] candidates, int target, LinkedList<Integer> item, int end) {
            if (target < 0) return ;
            if (target == 0 && !ans.contains(item)) {
                ans.add(new LinkedList<>(item)) ;
            }
            if (end < 0) return ;


            item.add(candidates[end]) ;
            dfs(candidates, target-candidates[end], item, end-1) ;
            item.removeLast() ;

            dfs(candidates, target, item, end-1) ;

            return ;
        }
    }
}
