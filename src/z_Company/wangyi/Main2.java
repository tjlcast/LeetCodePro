package z_Company.wangyi;

/**
 * Created by tangjialiang on 2018/3/27.
 */

import java.util.* ;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n ;
        int k ;

        n = in.nextInt();
        k = in.nextInt();

        int ans = 0 ;
        for(int x=n; x>=1; x--) {
            for(int y=n; y>=1; y--) {
                if (x % y >= k) ans++ ;
            }
        }

        System.out.println(ans) ;
    }
}