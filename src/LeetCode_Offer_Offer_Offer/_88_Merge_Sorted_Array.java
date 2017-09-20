package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/20.
 */
public class _88_Merge_Sorted_Array {
    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

     Note:
     You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
     The number of elements initialized in nums1 and nums2 are m and n respectively.
     */

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 0, 0, 0} ;
        int[] nums2 = {1, 2, 3} ;

        _88_Merge_Sorted_Array merge_sorted_array = new _88_Merge_Sorted_Array();
        merge_sorted_array.work(nums1, 4, nums2, 3);

        System.out.println("work is: ") ;
        for(Integer i : nums1) {
            System.out.print(i + " ") ;
        }
    }

    public void work(int[] nums1, int m, int[] nums2, int n) {
        Solution solution = new Solution();
        solution.merge(nums1, m, nums2, n);
    }

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            swapArr(nums1, 0, m);
            swapArr(nums1, 0, nums1.length);

            int pos = 0 ;

            int posM = nums1.length-m ;
            int posN = 0 ;

            while(posM<nums1.length || posN<n) {
                int valM = (posM==nums1.length) ? (Integer.MAX_VALUE) : (nums1[posM]) ;
                int valN = (posN==n) ? (Integer.MAX_VALUE) : (nums2[posN]) ;
                int valMin = -1 ;

                if (valM < valN) {
                    posM++ ;
                    valMin = valM ;
                } else {
                    posN++ ;
                    valMin = valN ;
                }

                nums1[pos++] = valMin ;
            }
        }

        private void swapArr(int[] arr, int begin, int len) {
            int l = begin ;
            int r = begin+len-1 ;

            while(l < r) {
                int temp = arr[l] ;
                arr[l] = arr[r] ;
                arr[r] = temp ;
                l++; r--;
            }
            return ;
        }
    }
}
