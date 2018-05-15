package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/5.
 */
public class _45_Jump_Game_II {
    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.

     Each element in the array represents your maximum jump length at that position.

     Your goal is to reach the last index in the minimum number of jumps.

     For example:
     Given array A = [2,3,1,1,4]

     The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

     Note:
     You can assume that you can always reach the last index.
     */

    public static void main(String[] args) {
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3} ;

        _45_Jump_Game_II jump_game_ii = new _45_Jump_Game_II();
        int work = jump_game_ii.work(nums);

        System.out.println("work is: " + work) ;
    }

    public int work(int[] nums) {
        int jump = new Solution().jump(nums);
        return jump ;
    }

    class Solution {
        // tips: 可以抽象为线段的覆盖
        public int jump(int[] nums) {
            if (nums.length==1) return 0 ;

            int top = -1 ;
            int lastEnd = -1 ;
            int steps = 0 ;

            int pos = 0 ;
            while(pos < nums.length) {
                int dist = nums[pos] ;
                if (top < dist + pos) {
                    if (pos <= lastEnd) {
                        // nothing to do
                    } else {
                        lastEnd = top ;
                        steps++ ;
                    }
                    top = dist + pos ;
                    if (top >= nums.length-1) return steps ;
                }
                pos += 1 ;
            }

            return steps ;
        }
    }
}
