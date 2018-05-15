package _test;

import static java.lang.Math.min ;
import static java.lang.Math.max ;

/**
 * Created by tangjialiang on 2018/4/9.
 */
public class FindSumsHeap {

    public static void solution(int[] arr) {
        int sum = 0 ;
        for (Integer i : arr) {
            sum += i ;
        }

        int n = arr.length / 2 ;

        int[][][] dp = new int[2*n+1][n+1][sum/2+2] ;

        for(int i=1; i<=arr.length; i++) {
            for(int j=1; j<=min(j, n); j++) {
                for(int s=sum/2; s>=arr[i-1]; s--) {
                    dp[i][j][s] = max(dp[i-1][j-1][s-arr[i-1]]+arr[i-1], dp[i-1][j][s]) ;
                }
            }
        }

        int i=2*n ;
        int j=n ;
        int s=sum/2 ;
        System.out.println("sum1: " + dp[i][j][s] + " sum2: " + (sum-dp[i][j][s])) ;

        while(i-1>0 && j-1>=0 && s-arr[i-1]>=0) {
            if (dp[i][j][s] == dp[i-1][j-1][s-arr[i-1]]+arr[i-1]) {
                System.out.println(arr[i-1]) ;
                j-- ;
                s-=arr[i-1] ;
            } else {

            }
            i-- ;
        }

        return ;
    }

    public static void main(String[] args) {
//        int[] nums = {0,1,5,7,8,9,6,3,11,20,17} ;
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8} ;
        solution(nums);
    }
}
