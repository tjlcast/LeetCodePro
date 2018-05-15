package DynamicProgramming;

/**
 * Created by tangjialiang on 2017/8/8.
 */
public class _53_Maximum_Subarray {
    public static void main(String[] args) {
        int[] data = {-2,1,-3,4,-1,2,1,-5,4} ;
        int work = new _53_Maximum_Subarray().work(data);
        System.out.println("ans is: " + work) ;
    }

    public int work(int[] nums) {
        return new Solution().maxSubArray(nums) ;
    }

    public class Solution {
        public int maxSubArray(int[] nums) {
            int ans = Integer.MIN_VALUE ;

            int preSum = 0 ;

            for(int i=0; i<nums.length; i++) {
                int num = nums[i] ;

                if (preSum + num < 0) {
                    preSum = 0 ;
                    ans = Math.max(ans, num) ;
                } else {
                    preSum += num ;
                    ans = Math.max(ans, preSum) ;
                }
            }

            return ans ;
        }
    }
}
