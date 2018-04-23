package z_Company.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tangjialiang on 2018/4/19.
 */
public class Main02 {
    public static void main(String[] args) {
        int[][] d = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 1, 1},
                {2, 0, 0},
                {0, 2, 0},
                {0, 0, 2}
        } ;

        Scanner sc = new Scanner(System.in) ;
        int A = sc.nextInt() ;
        int B = sc.nextInt() ;
        int C = sc.nextInt() ;

        // init
        int[][][] dp = new int[101][101][101] ;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dp[i][j].length; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE ;
                }
            }
            dp[i][i][i] = 0 ;
        }

        // dp[i][j][k] = min(dp[i-1][j][k],)
        for (int i = 100; i >= A; i--) {
            for (int j = 100; j >= B; j--) {
                for (int k = 100; k >= C; k--) {
                    for (int l = 0; l < d.length; l++) {
                        int newA = i + d[l][0] ;
                        int newB = j + d[l][1] ;
                        int newC = k + d[l][2] ;
                        if (newA<0 || newA>A) continue;
                        if (newB<0 || newB>B) continue;
                        if (newC<0 || newC>C) continue;
                        if (dp[i][j][k] == Integer.MAX_VALUE) continue;

                        dp[i][j][k] = Math.min(dp[i][j][k], dp[newA][newB][newC]+1) ;
                    }
                }
            }
        }

        System.out.println(dp[A][B][C]) ;
    }
}
