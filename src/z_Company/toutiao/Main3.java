package z_Company.toutiao;

import java.util.Scanner;

/**
 * Created by tangjialiang on 2018/4/15.
 *
uuurrdddddl
 3
 5 6 3 3
 5 6 4 2
 6 6 4 2
 */
public class Main3 {

    public static long sol(char[] directs, long N, long M, long X, long Y) {
        int ans = 0 ;
        long x = X, y=Y ;
        for (int i = 0; i < directs.length; i++) {
            char d = directs[i] ;

            if (d == 'l') {
                y-- ;
            } else if (d == 'r') {
                y++ ;
            } else if (d == 'u') {
                x-- ;
            } else if (d == 'd') {
                x++ ;
            }

            ans++ ;
            if (x<0||y<0||x>N-1||y>M-1) return ans ;
        }
        return ans ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        String steps = sc.nextLine() ;
        int Q = sc.nextInt() ;

        for (int i = 0; i < Q; i++) {
            int N = sc.nextInt() ;
            int M = sc.nextInt() ;
            int X = sc.nextInt() ;
            int Y = sc.nextInt() ;
            long sol = Main3.sol(steps.toCharArray(), N, M, X - 1, Y - 1);

            System.out.println(sol);
        }
    }
}
