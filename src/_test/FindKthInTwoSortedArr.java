package _test;

import java.util.Arrays;

import static java.lang.Math.min ;

/**
 * Created by tangjialiang on 2018/4/11.
 */
public class FindKthInTwoSortedArr {

    public static int findKInSortedArrays(int[] nums1, int[] nums2, int k) {
        int ans = -1 ;

        if (k == 1) {
            if (nums1.length!=0 && nums2.length!=0) return min(nums1[0], nums2[0]) ;
            if (nums1.length!=0) return nums1[0] ;
            if (nums2.length!=0) return nums2[0] ;
        }

        int val1 = (nums1.length==0) ? (Integer.MAX_VALUE) : (nums1[(k/2-1) % (nums1.length)]) ;
        int val2 = (nums2.length==0) ? (Integer.MAX_VALUE) : (nums2[(k/2-1) % (nums2.length)]) ;

        if (val1 > val2) {
            int[] newNums2 = Arrays.copyOfRange(nums2, (k / 2 - 1) % (nums2.length) + 1, nums2.length);
            ans = findKInSortedArrays(nums1, newNums2, k-((k / 2 - 1) % (nums2.length))-1) ;
        } else {
            int[] newNums1 = Arrays.copyOfRange(nums1, (k / 2 - 1) % (nums1.length) + 1, nums1.length);
            ans = findKInSortedArrays(newNums1, nums2, k-((k / 2 - 1) % (nums1.length))-1) ;
        }

        return ans ;
    }
}
