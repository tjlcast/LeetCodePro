package LeetCode_Offer_Offer_Offer;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2017/8/31.
 */
public class _1_Two_Sum {
    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

     You may assume that each input would have exactly one solution, and you may not use the same element twice.

     Example:
     Given nums = [2, 7, 11, 15], target = 9,

     Because nums[0] + nums[1] = 2 + 7 = 9,
     return [0, 1].
     */

    public static void main(String[] args) {
        int[] nums = {3, 2, 4} ;
        int target = 6 ;

        int[] work = new _1_Two_Sum().work(nums, target);

        for(int i : work) {
            System.out.println(i) ;
        }
    }

    public int[] work(int[] nums, int target) {
        Solution solution = new Solution();
        int[] ints = solution.twoSum(nums, target);
        return ints ;
    }


    class Solution {
        /**
         * 相加的两个数分别选取：
         *  第一个数通过数字遍历得到，并保存到HashMap(存取时间为O(1))
         *  第二个数通过在已遍历的数中选取
         */
        HashMap<Integer, Integer> map = new HashMap<>() ;

        public int[] twoSum(int[] nums, int target) {
            for(int i=0; i<nums.length; i++) {
                int num = nums[i] ;
                int reminder = target - num ;
                Integer index = map.get(reminder);
                if (index != null) {
                    int[] ans = {index, i} ;
                    return ans ;
                }
                map.put(num, i) ;
            }

            return null ;
        }
    }

    class MySolution {

        public int[] twoSum(int[] nums, int target) {
            for(int i=0; i<nums.length; i++) {
                for(int j=i+1; j<nums.length; j++) {
                    if (nums[i]+nums[j] == target) {
                        int[] ans = {i, j} ;
                        return ans ;
                    }
                }
            }

            return null ;
        }
    }
}
