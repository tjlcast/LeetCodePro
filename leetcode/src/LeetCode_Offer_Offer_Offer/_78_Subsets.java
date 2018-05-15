package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/14.
 */
public class _78_Subsets {
    /**
     * Given a set of distinct integers, nums, return all possible subsets.

     Note: The solution set must not contain duplicate subsets.

     For example,
     If nums = [1,2,3], a solution is:

     [
     [3],
     [1],
     [2],
     [1,2,3],
     [1,3],
     [2,3],
     [1,2],
     []
     ]
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3} ;

        _78_Subsets subsets = new _78_Subsets();
        List<List<Integer>> work = subsets.work(nums);

        System.out.println("work is: ") ;
        for(List<Integer> line : work) {
            for(Integer i : line) {
                System.out.print(i + " ") ;
            }
            System.out.println() ;
        }
    }

    public List<List<Integer>> work(int[] nums) {
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(nums);

        return subsets ;
    }

    class Solution {
        private List<List<Integer>> ans = new LinkedList<>() ;
        private int[] nums = null ;

        public List<List<Integer>> subsets(int[] nums) {
            if (nums==null || nums.length==0) return ans ;

            Arrays.sort(nums) ;
            this.nums = nums ;

            generate(0, new LinkedList<Integer>());

            return ans ;
        }

        private void generate(int pos, LinkedList<Integer> list) {
            if (pos == nums.length) {
                LinkedList<Integer> integers = new LinkedList<>(list);
                ans.add(integers) ;
                return ;
            }

            list.add(nums[pos]) ;
            generate(pos+1, list);
            list.removeLast() ;
            generate(pos+1, list);
        }
    }
}
