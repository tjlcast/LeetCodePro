package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;

/**
 * Created by tangjialiang on 2018/1/29.
 */
public class _238_Product_of_Array_Except_Self {

    /**Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

     Solve it without division and in O(n).

     For example, given [1,2,3,4], return [24,12,8,6].
     */
    public static void main(String[] args) {
        int[] nums = {1, 0} ;

        Solution sol = new Solution() ;
        int[] ints = sol.productExceptSelf(nums);

        System.out.println("The work is: ") ;
        Arrays.stream(ints).forEach(System.out::println);
    }

    static class Solution {
        /**
         * 《编程之美》上的一道原题。创建两个辅助数组，一个保存所有左边元素乘积的结果。一个保存所有右边元素乘积的结果。借助这两个数组，一次遍历就可以得到结果。
         * @param nums
         * @return
         */
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length ;
            int[] ans = new int[len] ;
            int[] leftProducts = new int[len] ;
            int[] rightProducts = new int[len] ;

            int leftProduct = 1 ;
            int rightProduct = 1 ;
            for(int i=0; i<len; i++) {
                int leftIdx = i ;
                int rightIdx = (len-1)-i ;
                leftProducts[leftIdx] = leftProduct ;
                rightProducts[rightIdx] = rightProduct ;

                leftProduct *= nums[leftIdx] ;
                rightProduct *= nums[rightIdx] ;
            }

            for(int i=0; i<len; i++) {
                int leftP = leftProducts[i] ;
                int rightP = rightProducts[i] ;

                ans[i] = leftP * rightP ;
            }
            return ans ;
        }
    }
}
