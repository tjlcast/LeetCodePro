package z_Company.tencent;

import java.util.Scanner;

/**
 * Created by tangjialiang on 2018/4/5.
 */

public class Main001 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        long[][] dp = new long[105][105] ;


        int c = sc.nextInt() ;
        int k ;

        for(int i=1; i<105; i++) {
            dp[i][0] = 1 ;
            dp[i][1] = i ;
        }

        for(int i=0; i<105; i++) {
            for(int j=2; j<=i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 1000000007;
            }
        }

        k = sc.nextInt() ;
        int len1,count1,len2,count2;
        len1 = sc.nextInt() ;
        count1 = sc.nextInt() ;
        len2 = sc.nextInt() ;
        count2 = sc.nextInt() ;
        long sum = 0;
        for (int i = 0; i * len1 <= k && i <= count1; ++i) {
            int tmp = k - i * len1;
            if (tmp % len2 != 0) {
                continue;
            }
            if (tmp / len2 > count2) {
                continue;
            }
            tmp /= len2;
            sum = (sum + (dp[count1][i] * dp[count2][tmp]) % 1000000007) % 1000000007;
        }

        System.out.println(sum) ;

    }
}