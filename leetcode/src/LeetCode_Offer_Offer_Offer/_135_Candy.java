package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/12/4.
 */

public class _135_Candy {

    public static void main(String[] args) {
        int[] rating = {4,2,3,4,1} ;

        int candy = new Solution().candy(rating);

        System.out.println("work is: " + candy) ;
    }

    public static class Solution {
        public int candy(int[] ratings) {
            int total = 0 ;

            int[] nums1 = new int[ratings.length] ;
            int[] nums2 = new int[ratings.length] ;

            for(int i=0; i<ratings.length; i++) {
                nums1[i] = 1 ;
                nums2[i] = 1 ;
            }

            for(int i=1; i<nums1.length; i++) {
                if (ratings[i] > ratings[i-1]) {
                    nums1[i] = nums1[i-1] + 1 ;
                }
            }

            for(int i=nums2.length-2; i>=0; i--) {
                if (ratings[i] > ratings[i+1]) {
                    nums2[i] = (nums2[i+1] + 1) ;
                }
            }

            for(int i=0; i<ratings.length; i++) {
                //System.out.format("nums1 %d nums2 %d\n", nums1[i], nums2[i]) ;
                total += Math.max(nums1[i], nums2[i]) ;
            }

            return total ;
        }
    }
}
