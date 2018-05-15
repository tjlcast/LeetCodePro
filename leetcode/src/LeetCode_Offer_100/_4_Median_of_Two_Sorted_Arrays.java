package LeetCode_Offer_100;

/**
 * Created by tangjialiang on 2018/2/28.
 */
public class _4_Median_of_Two_Sorted_Arrays {

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length ;
            int len2 = nums2.length ;

            return 0.2 ;
        }
    }

    public static void main(String[] args){
        int[] nums1 = {1, 3} ;
        int[] nums2 = {2} ;

        Solution sol = new Solution() ;
        double medianSortedArrays = sol.findMedianSortedArrays(nums1, nums2) ;

        System.out.println(medianSortedArrays) ;
    }
}
