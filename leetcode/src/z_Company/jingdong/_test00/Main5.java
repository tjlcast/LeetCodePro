package z_Company.jingdong._test00;

import java.util.Scanner;

/**
 * Created by tangjialiang on 2018/5/12.
 */
public class Main5 {

    public static void main(String[] args) {
        int max = 0 ;
        Scanner sc = new Scanner(System.in) ;
        int rows = sc.nextInt() ;
        int cols = sc.nextInt() ;

        int[][] matrix = new int[rows][cols] ;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt() ;
            }
        }

        int[][][] dp = new int[rows][cols][2] ;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] >= 0) {
                dp[i][0][0] = matrix[i][0] ;
            } else {
                dp[i][0][1] = (-1)*matrix[i][0] ;
                dp[i][0][0] = matrix[i][0] ;
            }
        }

        for (int i = 1; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (matrix[i][j] < 0) {
                    dp[i][j][0] = 0 ;
                }
            }
        }
    }
}
