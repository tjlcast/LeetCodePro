package LeetCode_Offer_Offer_Offer;

import Utils.LinkedListUtils;

import java.io.ObjectStreamClass;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by tangjialiang on 2017/12/29.
 */
public class _189_Rotate_Array {
    /**
     * Rotate an array of n elements to the right by k steps.

     For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3} ;
        int k = 1 ;

        Solution solution = new Solution();
        solution.rotate(nums, k);

        for(Integer num : nums) {
            System.out.print(num + " ") ;
        }
        System.out.println() ;
    }

    /**
     * 三段反转法(AC)
     */
    static class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length ;
            if (n == 0) return ;

            k = (k % n) ;

            reverse(nums, 0, n-k-1);
            reverse(nums, n-k, n-1);
            reverse(nums, 0, n-1);
        }

        private void reverse(int[] nums, int start, int end) {
            while(start < end) {
                int tmp = nums[start] ;
                nums[start] = nums[end] ;
                nums[end] = tmp ;

                start++ ;
                end-- ;
            }
        }
    }


    /**
     * 流处理（暴力）
     */
    static class Solution_1 {
        public void rotate(int[] nums, int k) {
            LinkedList<Integer> queue = new LinkedList<>() ;

            LinkedList<Integer> integerLinkedList = new LinkedList<Integer>(IntStream.of(nums).boxed().collect(Collectors.toList()));
            for(int i=1; i<=k; i++) {
                step(integerLinkedList);
            }

            for(int i=0; i<nums.length; i++) {
                nums[i] = integerLinkedList.get(i) ;
            }
        }

        private void step(LinkedList<Integer> list) {
            if (list.size() == 0) return ;

            Integer integer = list.removeLast();
            list.addFirst(integer);
        }
    }
}
