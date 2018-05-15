package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/2.
 */
public class _15_3Sum {
    /**
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

     Note: The solution set must not contain duplicate triplets.

     For example, given array S = [-1, 0, 1, 2, -1, -4],

     A solution set is:
     [
     [-1, 0, 1],
     [-1, -1, 2]
     ]
     */

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4} ;
        _15_3Sum sum = new _15_3Sum();
        List<List<Integer>> work = sum.work(nums);
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
        List<List<Integer>> lists = solution.threeSum(nums);
        return lists ;
    }

    class Solution1 {
        private List<List<Integer>> ans = new LinkedList<>() ;

        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);

            for(int i=0; i<nums.length-2; i++) {
                int reminder = 0 - nums[i] ;
                for(int j=i+1; j<nums.length-1; j++) {
                    int lastNum = reminder - nums[j] ;
                    int[] ints = Arrays.copyOfRange(nums, j + 1, nums.length);
                    int i1 = Arrays.binarySearch(ints, lastNum);
                    if (i1 >= 0) {
                        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(nums[i], nums[j], ints[i1]));
                        if(!ans.contains(integers))ans.add(integers) ;
                    }
                }
            }
            return ans ;
        }
    }

    class Solution {
        /**
         * 在对循环的递归变量进行额外操作时，一定要确定变量的下一次的变化。
         */
        private List<List<Integer>> ans = new LinkedList<>() ;

        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);

            for(int i=0; i<nums.length-2; i++) {
                int reminder = 0 - nums[i] ;
                int l = i + 1 ;
                int r = nums.length - 1 ;

                if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                    continue;
                }

                while(l < r) {
                    if (reminder == nums[l] + nums[r]) {
                        List<Integer> line = new LinkedList<>(Arrays.asList(nums[i], nums[l], nums[r])) ;
                        ans.add(line) ;
                        l += 1 ;
                        r -= 1 ;
                        while(l < r && nums[l]==nums[l-1])l += 1 ;
                        while(l < r && nums[r]==nums[r+1])r -= 1 ;
                    } else if (reminder < nums[l] + nums[r]) {
                        r -= 1 ;
                    } else {
                        l += 1 ;
                    }
                }
            }

            return ans ;
        }
    }
}
