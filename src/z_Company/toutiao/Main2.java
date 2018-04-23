package z_Company.toutiao;

import java.util.Scanner;

public class Main2 {

    public int solution() {
        Scanner sc = new Scanner(System.in) ;
        int n1 = sc.nextInt() ;
        int n2 = sc.nextInt() ;
        int m = sc.nextInt() ;
        int[] a = new int[n1] ;
        int[] b = new int[n2] ;

        // input
        for (int i = 0; i < n1; i++) {
            a[i] = sc.nextInt() ;
        }
        for (int i = 0; i < n2; i++) {
            b[i] = sc.nextInt() ;
        }

        // init
        int[][] dp1 = new int[n1][m+1] ; // 完全背包 dp1: 方法数，i：第i种币种， j: 目标值
        int[][] dp2 = new int[n2][m+1] ; // 01背包 dp2:

        for (int i = 0; i < n1; i++) {
            dp1[i][0] = 1 ;
        }
        for (int i = 0; a[0]*i <= m; i++) {
            dp1[0][a[0]*i] = 1 ;
        }

        for (int i = 0; i < n2; i++) {
            dp2[i][0] = 1 ;
        }
        dp2[0][b[0]] = 1 ;

        // dp
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j*a[i]<=m; j++) {
                dp1[i][j] += dp1[i-1][j-j*a[i]] ;
            }
        }

        for (int i = 0; i < n2; i++) {
            for (int j = 0; j <= m; j++) {
                dp2[i][j] += dp2[i-1][j-b[i]] ;
            }
        }

        // output
        int ans = 0 ;
        for (int i = 0; i <= m; i++) {
            int j = m - i ;
            ans += (dp1[n1-1][i]) * (dp2[n2-1][j]) ;
        }
        return ans ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n1 = sc.nextInt(),n2=sc.nextInt(),m=sc.nextInt();

        int[] a = new int[n1];
        int[] b = new int[n2];
        sc.nextLine();

        String line = sc.nextLine();
        String line1 = sc.nextLine();

        int k=0;
        for(String str:line.split(" ")){
            a[k] = Integer.parseInt(str);
            k++;
        }
        k=0;
        for(String str:line1.split(" ")){
            b[k] = Integer.parseInt(str);
            k++;
        }

        int[][] dp1 = new int[n1][m+1];
        int[][] dp2 = new int[n2][m+1];

        for(int j=0;j<n1;j++){
            dp1[j][0] = 1;
        }
        for(int j=0;a[0]*j<=m;j++){
            dp1[0][a[0]*j] = 1;
        }

        for(int i=1;i<n1;i++){
            for(int j=1;j<=m;j++){
                dp1[i][j] = dp1[i-1][j];
                dp1[i][j] += j-a[i]>=0?dp1[i][j-a[i]]:0;
            }
        }

        for(int j=0;j<n2;j++){
            dp2[j][0] = 1;
        }
        dp2[0][b[0]] = 1;

        for(int i=1;i<n2;i++){
            for(int j=1;j<=m;j++){
                dp2[i][j] = dp2[i-1][j];
                dp2[i][j] += j-a[i]>=0?dp2[i-1][j-a[i]]:0;
            }
        }

        long sum = 0;

        for(int i=1;i<m;i++){
            sum += dp1[n1-1][i]*dp2[n2-1][m-i];
            if(sum>1000000007)sum %= 1000000007;
        }
        sum += dp1[n1-1][m]+dp2[n2-1][m];

        if(sum>1000000007)sum %= 1000000007;
        System.out.println(sum);
    }

}