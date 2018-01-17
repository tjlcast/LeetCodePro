package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2018/1/17.
 */
public class _198_House_Robber {
    /**
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed,
     * the only constraint stopping you from robbing each of them is that adjacent houses
     * have security system connected and it will automatically contact the police
     * if two adjacent houses were broken into on the same night.

     Given a list of non-negative integers representing the amount of money of each house,
     determine the maximum amount of money you can rob tonight without alerting the police.
     * @param args
     */

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2} ;

        Solution solution = new Solution();
        int rob = solution.rob(nums);

        System.out.println("The work is; " + rob) ;
    }

    static class Solution {

        public int rob(int[] nums) {
            int ans = 0 ;
            int n = nums.length;
            if (n==0) return 0 ;
            if (n==1) return nums[0] ;
            if (n==2) return Math.max(nums[0], nums[1]) ;
            int[] local = new int[n] ;

            // init
            local[0] = nums[0] ;
            local[1] = Math.max(nums[0], nums[1]) ;

            for(int i=2; i<n; i++) {
                local[i] = Math.max(local[i-1], local[i-2]+nums[i]) ;
            }
            return local[n-1] ;
        }
    }
}
