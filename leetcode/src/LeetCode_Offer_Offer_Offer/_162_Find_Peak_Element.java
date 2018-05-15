package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/12/19.
 */
public class _162_Find_Peak_Element {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1} ;

        Solution solution = new Solution();
        int peakElement = solution.findPeakElement(nums);

        System.out.println("work is: " + peakElement) ;
    }

    static class Solution {
        public int findPeakElement(int[] nums) {

            int last = Integer.MIN_VALUE ;
            int next = Integer.MIN_VALUE ;

            for(int i=0; i<nums.length; i++) {
                int num = nums[i] ;
                last = (i-1>=0) ? (nums[i-1]) : (Integer.MIN_VALUE) ;
                next = (i+1<nums.length) ? (nums[i+1]) : (Integer.MIN_VALUE) ;

                if((num > last && num > next) || (num==Integer.MIN_VALUE && last==Integer.MIN_VALUE &&next==Integer.MIN_VALUE)) return i ;
            }

            return -1 ;
        }
    }
}
