package LeetCode_Offer_Offer_Offer;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2017/11/27.
 *
 */
public class _128_Longest_Consecutive_Sequence {
    /**
     Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

     For example,
     Given [100, 4, 200, 1, 3, 2],
     The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

     Your algorithm should run in O(n) complexity.
     */

    public static void main(String[] args) {
        int[] nums = {0, 0, 3, 2, 9} ;
        Solution solution = new Solution();
        int i = solution.longestConsecutive(nums);

        System.out.println("work is : " + i) ;
    }

    static class Solution {
        /**
         * 使用一个HashMap记录出现的数字，遍历数字集合。
         * 对于每一个数字分别进行左右连续扩展（不在map中扩展停止）。
         */
        public int longestConsecutive(int[] nums) {
            int ans = 0 ;
            HashMap<Integer, Integer> recorder = new HashMap<>() ;

            for(int i=0; i<nums.length; i++) {
                Integer orDefault = recorder.getOrDefault(nums[i], 0);
                recorder.put(nums[i], 1) ;
            }

            for(int i=0; i<nums.length; i++) {
                int num = nums[i] ;
                // to right
                int rightNum = num + 1 ;
                while(recorder.containsKey(rightNum)) {
                    recorder.remove(rightNum) ;
                    rightNum += 1 ;
                }

                // to left
                int leftNum = num - 1 ;
                while(recorder.containsKey(leftNum)) {
                    recorder.remove(leftNum) ;
                    leftNum -= 1 ;
                }

                int len = (rightNum - leftNum) - 1 ;
                ans = Math.max(ans, len) ;
            }

            return ans ;
        }
    }
}
