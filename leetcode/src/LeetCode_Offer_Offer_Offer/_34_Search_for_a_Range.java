package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/3.
 */
public class _34_Search_for_a_Range {
    /**
     * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

     Your algorithm's runtime complexity must be in the order of O(log n).

     If the target is not found in the array, return [-1, -1].

     For example,
     Given [5, 7, 7, 8, 8, 10] and target value 8,
     return [3, 4].
     */

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10} ;
        int target = 1 ;

        _34_Search_for_a_Range search_for_a_range = new _34_Search_for_a_Range();
        int[] work = search_for_a_range.work(nums, target);

        System.out.println("work is: ") ;
        for(Integer i : work) System.out.print(i+" ") ;
    }

    public int[] work(int[] nums, int target) {
        Solution solution = new Solution();
        int[] ints = solution.searchRange(nums, target);
        return ints ;
    }

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int leftBorder = findLeftBorder(nums, 0, nums.length - 1, target);
            int rightBorder = findRightBorder(nums, 0, nums.length - 1, target);

            int[] ans = {leftBorder, rightBorder} ;
            return ans ;
        }

        private int findRightBorder(int[] nums, int l, int r, int target) {
            if (l>r || l<0 || r>=nums.length || l==r && nums[l]!=target) return -1 ;

            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                while(mid!=nums.length-1 && nums[mid+1]==nums[mid]) mid++ ;
                return mid ;
            } else if(nums[mid] > target) {
                return findRightBorder(nums, l, mid-1, target) ;
            } else {
                return findRightBorder(nums, mid+1, r, target) ;
            }
        }

        private int findLeftBorder(int[] nums, int l, int r, int target) {
            if (l>r || l<0 || r>=nums.length || l==r && nums[l]!=target) return -1 ;

            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                while(mid!=0 && nums[mid-1]==nums[mid]) mid-- ;
                return mid ;
            } else if(nums[mid] > target) {
                return findLeftBorder(nums, l, mid-1, target) ;
            } else {
                return findLeftBorder(nums, mid+1, r, target) ;
            }
        }
    }
}
