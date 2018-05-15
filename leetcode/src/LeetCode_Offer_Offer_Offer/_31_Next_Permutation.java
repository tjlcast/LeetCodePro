package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;

/**
 * Created by tangjialiang on 2017/9/3.
 */
public class _31_Next_Permutation {
    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

     If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

     The replacement must be in-place, do not allocate extra memory.

     Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     1,2,3 → 1,3,2
     3,2,1 → 1,2,3
     1,1,5 → 1,5,1
     */

    public static void main(String[] args) {
        int[] nums = {1, 3, 2} ;

        _31_Next_Permutation next_permutation = new _31_Next_Permutation();
        next_permutation.work(nums);

        System.out.println("work is: ") ;
        for(Integer i : nums) {System.out.println(i+" ") ;}
    }

    public void work(int[] nums) {
        Solution solution = new Solution();
        solution.nextPermutation(nums);
    }

    class Solution {
        public void nextPermutation(int[] nums) {
            // from right to left finding the ascending num
            int nodePos = -1 ;
            for(int index=nums.length-2; index>=0; index--) {
                if (nums[index]<nums[index+1]) {
                    nodePos=index ;
                    break ;
                }
            }

            // to do something
            if (nodePos<0) {
                int l=0; int r=nums.length-1 ;
                while(l<r) {
                    int swap = nums[l] ;
                    nums[l] = nums[r] ;
                    nums[r] = swap ;
                    l++; r--;
                }
                return ;
            }

            int minVal=Integer.MAX_VALUE; int minPos=-1 ;
            for(int i=nodePos; i<nums.length; i++) {
                if (nums[i] > nums[nodePos] && minVal > nums[i]) {
                    minPos = i ;
                    minVal = nums[i] ;
                }
            }

            nums[minPos] = nums[nodePos] ;
            nums[nodePos] = minVal ;

            Arrays.sort(nums, nodePos+1, nums.length);

            return ;
        }
    }
}
