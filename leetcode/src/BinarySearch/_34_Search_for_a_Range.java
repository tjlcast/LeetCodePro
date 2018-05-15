package BinarySearch;

/**
 * Created by tangjialiang on 2017/5/15.
 */
public class _34_Search_for_a_Range {
    public static void main(String[] args) {
        int[] nums = { 2, 2} ;
        int target = 3 ;
        int[] range = new _34_Search_for_a_Range().work(nums, target) ;
        System.out.println("leRange: " + range);
    }

    public int[] work(int[] nums, int target) {
        return new Solution().searchRange(nums, target) ;
    }

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] ans = {-1, -1} ;
            if (nums.length != 0) ans[0] = findLeftRange(nums, target) ;
            if (nums.length != 0) ans[1] = findRightRange(nums, target) ;
            return ans ;
        }

        int findRightRange(int[] nums, int target) {
            int left = 0 ;
            int right = nums.length - 1;

            while(left < right) {
                int mid = (left + right) / 2 ;
                if ((left + right) % 2!=0) mid++ ;

                if (nums[mid] == target) {
                    if (left != mid) {left = mid ;}
                    else {right = mid ;}
                } else if (nums[mid] < target) {
                    left = mid + 1 ;
                } else { // > target
                    right = mid - 1 ;
                }
            }
            int ans = -1 ;
            try {
                ans = (nums[left] == target) ? (left) : (-1);
            }catch (Exception e){

            }
            return ans ;
        }

        int findLeftRange(int[] nums, int target) {
            int left = 0 ;
            int right = nums.length-1 ;

            while(left < right) {
                int mid = (left + right) / 2 ;

                if (nums[mid] == target) {
                    if (right != mid) {right = mid ;}
                    else {left = mid ;}
                } else if (nums[mid] < target) {
                    left = mid + 1 ;
                } else { // > target
                    right = mid - 1 ;
                }
            }

            int ans = -1 ;
            try {
                ans = (nums[left] == target) ? (left) : (-1);
            } catch (Exception e){

            }
            return ans ;
        }
    }
}
