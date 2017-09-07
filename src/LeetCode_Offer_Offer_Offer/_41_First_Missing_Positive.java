package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/4.
 */
public class _41_First_Missing_Positive {
    /**
     * Given an unsorted integer array, find the first missing positive integer.

     For example,
     Given [1,2,0] return 3,
     and [3,4,-1,1] return 2.
     [1000, 1] return 2

     Your algorithm should run in O(n) time and uses constant space.
     */

    public static void main(String[] args) {
        int[] nums = {2, 1} ;

        _41_First_Missing_Positive first_missing_positive = new _41_First_Missing_Positive();
        int work = first_missing_positive.work(nums);

        System.out.println("work is: " + work) ;
    }

    public int work(int[] nums) {
        Solution solution = new Solution();
        int i = solution.firstMissingPositive(nums);
        return i ;
    }

    class Solution {
        int firstMissingPositive(int[] nums) {

            for(int i=0; i<nums.length; i++) {
                // let current number to be the position where is should be.
                while(nums[i]>0 && nums[i]-1<nums.length && nums[i]-1!=i) {
                    int val = nums[i] ;
                    if (nums[i]==nums[val-1]) break ;
                    nums[i] = nums[val-1] ;
                    nums[val-1] = val ;
                }
            }

            for(int i=0; i<nums.length; i++) {
                if (nums[i]!=i+1) {
                    return i+1 ;
                }
            }

            return nums.length+1 ;
        }
    }

    class Solution1 {
        private int[] flags = new int[9999] ;

        public int firstMissingPositive(int[] nums) {
            for(Integer i : nums) {
                if (i > 0) {
                    flags[i] = 1 ;
                }
            }


            for(int i=1; i<Integer.MAX_VALUE; i++) {
                if (flags[i]==0) return i ;
            }

            return -1 ;
        }
    }
}
