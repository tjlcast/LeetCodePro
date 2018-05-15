package z_Company.zhihu;

import java.util.Scanner;
import static java.lang.Math.max ;
import static java.lang.Math.min ;

/**
 * Created by tangjialiang on 2018/4/10.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        int X = sc.nextInt() ;
        int Y = sc.nextInt() ;
        int count = 0 ;

        for(int i=min(X, Y); i<=max(X, Y); i++) {
            if (isRight(i)) count++ ;
        }

        System.out.println(count);
    }

    private static boolean isRight(int n) {
        for(int i=2; i<n/2+1; i++) {
            if (n%i == 0) return false ;
        }
        return true ;
    }
}
