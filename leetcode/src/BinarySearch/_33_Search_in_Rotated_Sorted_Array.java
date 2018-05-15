package BinarySearch;

/**
 * Created by tangjialiang on 17/5/13.
 *
 *  1/  最后查找的是一个点，故while条件设置为包含'＝'
 *
 *  2/  如下图，如果mid在右半段，那么target在mid的左侧，可以递归查找左侧这段（排除右侧一半）；target在mid右侧，可以递归查找右侧这段（排除左侧一半）
 *                      1
 *                  1
 *              1
 *          1
 *       *
 *       *                          1
 *       *                      1
 *       *                  1
 *       *                  *
 *       *                  *
 *       *                  *
 */
public class _33_Search_in_Rotated_Sorted_Array {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,1,2,3} ;
        int target = 8 ;
        int work = new _33_Search_in_Rotated_Sorted_Array().work(nums, target);
        System.out.println("work: " + work) ;
    }

    public int work(int[] nums, int target) {
        return new Solution().search(nums, target) ;
    }

    public class Solution {
        public int search(int[] nums, int target) {
            return proSearch(nums, 0, nums.length-1, target) ;
        }

        private int proSearch(int[] nums, int left, int right , int target) {
            while(left <= right) {
                int mid = (left + right) / 2 ;
                if (nums[mid] == target) {
                    return mid ;
                }
                else if (nums[mid] < nums[left]) {
                    if (target>nums[mid] && target<=nums[right]) {
                        left = mid + 1 ;
                    } else {
                        right = mid - 1 ;
                    }
                } else {
                    if (target<nums[mid] && target>=nums[left]) {
                        right = mid - 1 ;
                    } else {
                        left = mid + 1 ;
                    }
                }
            }

            return -1 ;
        }
    }
}
