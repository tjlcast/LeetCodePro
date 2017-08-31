package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;

/**
 * Created by tangjialiang on 2017/8/31.
 */
public class _4_Median_of_Two_Sorted_Arrays {
    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.

     Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

     Example 1:
     nums1 = [1, 3]
     nums2 = [2]

     The median is 2.0
     Example 2:
     nums1 = [1, 2]
     nums2 = [3, 4]

     The median is (2 + 3)/2 = 2.5
     */

    public static void main(String[] args) {
        int[] nums1 = {1, 2} ;
        int[] nums2 = {1, 2} ;

        double work = new _4_Median_of_Two_Sorted_Arrays().work(nums1, nums2);
        System.out.println("work is: " + work) ;
    }

    public double work(int[] nums1, int[] nums2) {
        Solution solution = new Solution();
        double medianSortedArrays = solution.findMedianSortedArrays(nums1, nums2);

        int kInSortedArrays = solution.findKInSortedArrays(nums1, nums2, 3);
        System.out.println("kInSortedArrays: " + kInSortedArrays) ;


        return medianSortedArrays ;
    }

    class Solution {
        /**
         * 利用重要结论： 如果A[k/2-1]<B[k/2-1]，那么A[0]~A[k/2-1]一定在第k小的数的序列当中。
         * 那么在下一轮查找中可以排除A[0]~A[k/2-1]，同时缩小K值。
         */

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            double mid = 0 ;

            int len = nums1.length + nums2.length ;
            if (len % 2 == 1) {
                mid = findKInSortedArrays(nums1, nums2, len/2+1) ;
            } else {
                int mid1 = findKInSortedArrays(nums1, nums2, len/2);
                int mid2 = findKInSortedArrays(nums1, nums2, len/2+1) ;
                mid = (double) (mid1 + mid2) / (double) 2 ;
            }
            return mid ;
        }

        public int findKInSortedArrays(int[] nums1, int[] nums2, int k) {
            int ans = -1 ;

            if (k == 1) {
                if (nums1.length!=0 && nums2.length!=0) return Math.min(nums1[0], nums2[0]) ;
                if (nums1.length!=0) return nums1[0] ;
                return nums2[0] ;
            }

            int mid1 = (nums1.length==0) ? (Integer.MAX_VALUE) : (nums1[(k/2-1) % (nums1.length)]) ;
            int mid2 = (nums2.length==0) ? (Integer.MAX_VALUE) : (nums2[(k/2-1) % (nums2.length)]) ;


            if (mid1 > mid2) {
                int[] newNums2 = Arrays.copyOfRange(nums2, (k / 2 - 1) % (nums2.length) + 1, nums2.length);
                ans = findKInSortedArrays(nums1, newNums2, k-((k / 2 - 1) % (nums2.length))-1) ;
            } else {//if (mid1 < mid2) {
                int[] newNums1 = Arrays.copyOfRange(nums1, (k / 2 - 1) % (nums1.length) + 1, nums1.length);
                ans = findKInSortedArrays(newNums1, nums2, k-((k / 2 - 1) % (nums1.length))-1) ;
            }

            return ans ;
        }
    }
}
