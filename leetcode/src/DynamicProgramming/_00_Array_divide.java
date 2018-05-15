package DynamicProgramming;

/**
 * Created by tangjialiang on 2018/3/27.
 */
public class _00_Array_divide {

    static public class Solution {
        public int getHalfSum(int[] arr) {
            int arrLen = arr.length ;
            int n = arr.length / 2 ;
            int sum = 0 ;

            for(Integer i : arr) {
                sum += i ;
            }

            int[][][] dp = new int[arrLen][n+1][sum/2+2] ;

            for(int i=1; i<=arrLen; i++) {
                for(int j=1; j<=Math.min(i, n); j--) {
                    for(int s=sum/2+1; s>=arr[i]; s--) {
                        dp[i][j][s] = Math.max(dp[i-1][j][s], dp[i-1][j-1][s-arr[i-1]] + arr[i-1]) ;
                    }
                }
            }

            return -1 ;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8} ;

        Solution sol = new Solution() ;
        int sum = sol.getHalfSum(arr);

        System.out.println("the half is: " + sum) ;
    }
}
