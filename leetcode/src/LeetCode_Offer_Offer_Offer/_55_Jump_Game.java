package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/8.
 *
 */
public class _55_Jump_Game {
    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.

     Each element in the array represents your maximum jump length at that position.

     Determine if you are able to reach the last index.

     For example:
     A = [2,3,1,1,4], return true.

     A = [3,2,1,0,4], return false.
     */

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4} ;

        _55_Jump_Game jump_game = new _55_Jump_Game();
        boolean work = jump_game.work(nums);

        System.out.println("work is: " + work) ;
    }

    public boolean work(int[] nums) {
        Solution solution = new Solution();
        boolean b = solution.canJump(nums);
        return b ;
    }

    class Solution {
        public boolean canJump(int[] nums) {
            int top = 0 ;
            int lastEnd = -1 ;

            for(int i=0; i<nums.length; i++) {
                int l = i ;
                int r = i+nums[i] ;

                if (top < l) return false ;

                if (r > top) {
                    top = r ;
                }
            }

            return true ;
        }
    }

    class Solution1 {
        private int lastEnd = -1 ;
        private int top = 0 ;
        private int totalStep = 0 ;

        public void jump(int[] nums) {
            for(int i=0; i<nums.length; i++) {
                int l = i ;
                int r = nums[i]+l ;

                if (lastEnd < l) {
                    lastEnd = l ;
                    totalStep += 1 ;
                }

                if (r > top) {
                    top = r ;
                }

                if (top >= nums.length-1) {
                    System.out.println("totalStep: " + totalStep) ;
                }
            }

            System.out.println("totalStep: " + totalStep) ;
        }
    }
}
