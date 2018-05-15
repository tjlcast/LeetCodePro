package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/2.
 */
public class _18_4Sum {
    /**
     * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

     Note: The solution set must not contain duplicate quadruplets.

     For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

     A solution set is:
     [
     [-1,  0, 0, 1],
     [-2, -1, 1, 2],
     [-2,  0, 0, 2]
     ]
     */

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2} ;
        int target = 0 ;

        _18_4Sum sum = new _18_4Sum();
        List<List<Integer>> work = sum.work(nums, target);

        System.out.println("work is: ") ;
        for(List<Integer> line : work) {
            for(Integer num: line) {
                System.out.print(num + " ") ;
            }
            System.out.println() ;
        }
    }

    public List<List<Integer>> work(int[] nums, int target) {
        Solution solution = new Solution();
        List<List<Integer>> listList = solution.fourSum(nums, target);
        return listList ;
    }

    class Solution {
        private List<List<Integer>> ans = new LinkedList<>() ;

        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);

            for(int i=0; i<nums.length-3; i++) {
                if (i>0 && nums[i]==nums[i-1]) continue;

                for(int j=i+1; j<nums.length-2; j++) {
                    if (j>i+1 && nums[j]==nums[j-1]) continue;

                    int l = j+1 ;
                    int r = nums.length-1 ;
                    int reminder = target - nums[i] - nums[j] ;

                    while(l < r) {
                        if (reminder == nums[l] + nums[r]) {
                            LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                            ans.add(integers) ;
                            l++ ; r-- ;
                            while(l < r && nums[l]==nums[l-1]) l++ ;
                            while(l < r && nums[r]==nums[r+1]) r-- ;
                        } else if (reminder < nums[l] + nums[r]) {
                            r -= 1 ;
                        } else {
                            l += 1 ;
                        }
                    }
                }
            }

            return ans ;
        }
    }
}
