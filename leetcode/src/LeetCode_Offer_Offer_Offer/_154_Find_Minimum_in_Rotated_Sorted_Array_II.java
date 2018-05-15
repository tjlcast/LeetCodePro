package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/12/17.
 */
public class _154_Find_Minimum_in_Rotated_Sorted_Array_II {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

     (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

     Find the minimum element.

     The array may contain duplicates.
     */

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2} ;

        Solution solution = new Solution();
        int min = solution.findMin(nums);

        System.out.println("the work is: " + min) ;
    }

    static class Solution {
        public int findMin(int[] nums) {
            return binarySearch(nums, 0, nums.length-1) ;
        }

        private int binarySearch(int[] nums, int begin, int end) {
            //System.out.format("begin %d end %d\n", begin, end) ;
            if (begin == end) return nums[begin] ;

            int mid = (begin + end) / 2 ;
            int midNum = nums[mid] ;

            int beginNum = nums[begin] ;
            int endNum = nums[end] ;

            if (beginNum > endNum) {
                if (midNum >= beginNum) {
                    return binarySearch(nums, mid+1, end) ;
                } else if (midNum < beginNum) {
                    return binarySearch(nums, begin, mid) ;
                }
            } else if (beginNum < endNum) {
                return beginNum ;
            } else {
                int borderNum = beginNum ;
                if (midNum > borderNum) {
                    return binarySearch(nums, mid+1, end) ;
                } else if (midNum < borderNum) {
                    return binarySearch(nums, begin, mid) ;
                } else {
                    // todo ;
                    while(begin+1 <= end && nums[begin]==nums[begin+1]) {begin++; }
                    while(end-1 >= begin && nums[end]==nums[end-1]) {end--; }
                    return binarySearch(nums, begin, end) ;
                }
            }
            return -1 ;
        }
    }
}
