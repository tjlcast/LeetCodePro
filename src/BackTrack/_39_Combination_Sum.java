package BackTrack;

import java.util.*;

/**
 * Created by tangjialiang on 2017/5/24.
 *
 */
public class _39_Combination_Sum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7} ;
        int target = 7 ;

        List<List<Integer>> work = new _39_Combination_Sum().work(candidates, target);
        System.out.print(work.toString());
    }

    public List<List<Integer>> work(int[] candidates, int target) {
        return new Solution().combinationSum(candidates, target) ;
    }

    public class Solution {
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>() ;

        List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            for(int i=0; i<candidates.length; i++) {
                LinkedList<Integer> l = new LinkedList<>() ;
                l.add(candidates[i]) ;
                dfs(candidates, target-candidates[i], l, i);
            }
            return ans ;
        }

        private void dfs(int[] candidates, int target, LinkedList<Integer> item, int begin) {
            if (target < 0) return ;
            if (target == 0 && !ans.contains(item)) {
                    ans.add(new LinkedList<>(item)) ;
            }

            for(int i=begin; i<candidates.length; i++) {
                item.add(candidates[i]) ;
                dfs(candidates, target-candidates[i], item, i) ;
                item.removeLast() ;
            }
        }
    }
}
