package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/20.
 */
public class _90_Subsets_II {
    /**
     * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

     Note: The solution set must not contain duplicate subsets.

     For example,
     If nums = [1,2,2], a solution is:

     [
     [2],
     [1],
     [1,2,2],
     [2,2],
     [1,2],
     []
     ]
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 2} ;

        _90_Subsets_II subsets_ii = new _90_Subsets_II();
        List<List<Integer>> work = subsets_ii.work(nums);

        System.out.println("work is: ") ;
        for(List<Integer> line : work) {
            for(Integer i : line) System.out.print(i + " ") ;
            System.out.println() ;
        }
    }

    public List<List<Integer>> work(int[] nums) {
        Solution solution = new Solution();

        List<List<Integer>> lists = solution.subsetsWithDup(nums);
        return lists ;
    }

    class Solution {
        private HashSet<List<Integer>> set = new HashSet<>() ;
        private int len = -1 ;
        private int[] nums = null ;

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            this.len = nums.length ;
            this.nums = nums ;

            genrateSet(0, new LinkedList<>());

            LinkedList<List<Integer>> ans = new LinkedList<>();
            for(List<Integer> line : set) { ans.add(line); }

            return ans ;
        }

        private void genrateSet(int pos, LinkedList<Integer> arr) {
            if (pos == len) {
                set.add(new LinkedList<>(arr)) ;
                return ;
            }

            arr.add(nums[pos]) ;
            genrateSet(pos+1, arr);
            arr.removeLast() ;

            genrateSet(pos+1, arr);

            return ;
        }
    }
}
