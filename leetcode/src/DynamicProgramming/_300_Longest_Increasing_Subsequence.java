package DynamicProgramming;

/**
 * Created by tangjialiang on 2018/4/15.
 */
public class _300_Longest_Increasing_Subsequence {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18} ;

        Solution solution = new Solution();
        int i = solution.lengthOfLIS(nums);

        System.out.println(i);
    }

    static class Solution1 {
        public int lengthOfLIS(int[] nums) {
            int[] tails = new int[nums.length] ;
            int size = 0 ;

            for (int x :
                    nums) {
                int i = 0, j = size;
                while(i != j) {
                    int m = (i + j) / 2 ;
                    if (tails[m] < x) {
                        i = m + 1 ;
                    } else {
                        j = m ;
                    }
                    tails[i] = x ;
                    if (i == size) size++ ;
                }
            }
            return size ;
        }
    }

    static class Solution {
            public int lengthOfLIS(int[] nums) {
                if (nums==null || nums.length==0) return 0 ;

                int[] dp = new int[nums.length] ;
                dp[0] = 1 ;

                for (int i = 1; i < nums.length; i++) {
                    int curV = nums[i] ;
                    int maxLen = 1 ;
                    for (int j = 0; j < i; j++) {
                        if (nums[j] >= curV) continue;
                        maxLen = Math.max(maxLen, dp[j]+1) ;
                    }
                    dp[i] = maxLen ;
                }

                int ans = 0 ;
                for (Integer i :
                        dp) {
                    ans = Math.max(ans, i) ;
                }

                return ans ;
            }
    }
}
