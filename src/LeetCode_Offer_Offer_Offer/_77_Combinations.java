package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/14.
 */
public class _77_Combinations {
    /**
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

     For example,
     If n = 4 and k = 2, a solution is:

     [
     [2,4],
     [3,4],
     [2,3],
     [1,2],
     [1,3],
     [1,4],
     ]

     */

    public static void main(String[] args) {
        int n = 4 ;
        int k = 2 ;

        _77_Combinations combinations = new _77_Combinations();
        List<List<Integer>> work = combinations.work(n, k);

        System.out.println("work is: ") ;

        for(List<Integer> line : work) {
            for(Integer i : line) {
                System.out.print(i + " ") ;
            }
            System.out.println() ;
        }
    }


    public List<List<Integer>> work(int n, int k) {
        Solution solution = new Solution();
        List<List<Integer>> combine = solution.combine(n, k);

        return combine ;
    }


    class Solution {
        private List<List<Integer>> ans = new LinkedList<>() ;

        public List<List<Integer>> combine(int n, int k) {
            int[] nums = new int[k] ;
            generate(n, 1, 0, nums);

            return ans ;
        }

        private void generate(int n, int num, int pos, int[] nums) {
            if (pos == nums.length) {
                List<Integer> line = new LinkedList<>() ;
                for(Integer i : nums) line.add(i) ;
                ans.add(line) ;
                return ;
            }
            if (pos > nums.length || num > n) return ;

            generate(n, num+1, pos, Arrays.copyOf(nums, nums.length));
            nums[pos] = num ;
            generate(n, num+1, pos+1, Arrays.copyOf(nums, nums.length));
        }
    }
}
