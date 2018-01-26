package LeetCode_Offer_Offer_Offer;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/1/26.
 */
public class _229_Majority_Element_II {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 3, 2} ;

        Solution sol = new Solution() ;
        List<Integer> ans = sol.majorityElement(nums) ;

        System.out.println("The work is: ") ;
        for(Integer i : ans) System.out.print(i + " ") ;
    }

    static class Solution {
        /**
         * Boyer-Moore majority vote algorithm(摩尔投票算法)

         简介

         Boyer-Moore majority vote algorithm(摩尔投票算法)是一种在线性时间O(n)和空间复杂度的情况下，在一个元素序列中查找包含最多的元素。它是以Robert S.Boyer和J Strother Moore命名的，1981年发明的，是一种典型的流算法(streaming algorithm)。

         在它最简单的形式就是，查找最多的元素，也就是在输入中重复出现超过一半以上(n/2)的元素。如果序列中没有最多的元素，算法不能检测到正确结果，将输出其中的一个元素之一。

         当元素重复的次数比较小的时候，对于流算法不能在小于线性空间的情况下查找频率最高的元素。

         算法描述

         算法在局部变量中定义一个序列元素(m)和一个计数器(i)，初始化的情况下计数器为0. 算法依次扫描序列中的元素，当处理元素x的时候，如果计数器为0，那么将x赋值给m，然后将计数器(i)设置为1，如果计数器不为0，那么将序列元素m和x比较，如果相等，那么计数器加1，如果不等，那么计数器减1。处理之后，最后存储的序列元素(m)，就是这个序列中最多的元素。

         如果不确定是否存储的元素m是最多的元素，还可以进行第二遍扫描判断是否为最多的元素。
         * @param nums
         * @return
         */
        public List<Integer> majorityElement(int[] nums) {
            List<Integer> ans = new LinkedList<>() ;
            if (nums.length <= 0) return ans ;

            int num1 = -1;
            int num1Time = 0;
            int num2 = -1;
            int num2Time = 0;

            for(int i=0; i<nums.length; i++) {
                int num = nums[i] ;
                if (num == num1) {
                    num1Time += 1 ;
                } else if (num == num2) {
                    num2Time += 1 ;
                } else if (num1Time == 0) {
                    num1 = num ;
                    num1Time = 1 ;
                } else if (num2Time == 0) {
                    num2 = num ;
                    num2Time = 1 ;
                } else {
                    num1Time -= 1 ;
                    num2Time -= 1 ;
                }
            }

            // judge which satisfy conditions.
            // System.out.format("num1:%d time: %d num2:%d time: %d\n", num1, num1Time, num2, num2Time) ;
            num1Time = 0 ;
            num2Time = 0 ;
            for(Integer num : nums) {
                if (num == num1) num1Time+=1 ;
                if (num == num2) num2Time+=1 ;
            }
            if (num1Time > (nums.length/3)) ans.add(num1) ;
            if (num2Time > (nums.length/3)) ans.add(num2) ;

            return ans ;
        }
    }
}
