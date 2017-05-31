package Greedy;

/**
 * Created by tangjialiang on 2017/5/28.
 *       -----------
 *       |         |
 *       o o o o o o - - - - - - - - - - - - -
 *         | | | | |     |   |   | |   |
 *         -----------------------------
 */
public class _45_Jump_Game_II {

    public static void main(String[] args) {
//        int[] nums = {2, 3, 0, 1, 4} ;
//        int[] nums = {1, 1, 1, 1, 1, 1, 1} ;
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3} ;
        int work = new _45_Jump_Game_II().work(nums);
        System.out.println(work) ;
    }

    public int work(int[] nums) {
        return new Solution().jump(nums) ;
    }

    public class Solution {
        int jump(int[] nums) {
            if (nums.length <= 1) return 0 ;
            int step = 0 ;
            int curRch = 0 ;

            int maxPos = -1 ;
            for(int i=0; i<nums.length; i++) {
                if (curRch < i) {
                    step++ ;
                    curRch = maxPos ;
                }

                maxPos = Math.max(maxPos, nums[i] + i) ;
            }

            return step ;
        }
    }
}
