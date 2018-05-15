package ArrayAndString;

/**
 * Created by tangjialiang on 2017/5/18.
 */
public class _35_Search_Insert_Position {

    public static void main(String[] args) {

    }

    public int work(int[] nums, int target) {
        return new Solution().searchInsert(nums, target) ;
    }

    class Solution {
        int searchInsert(int[] nums, int target) {
            int pos = -1;

            for(int i=0; i<nums.length; i++) {
                if (target <= nums[i]) {
                    pos = i ;
                    break ;
                }
            }

            return (pos==-1)?(nums.length):(pos) ;
        }
    }
}
