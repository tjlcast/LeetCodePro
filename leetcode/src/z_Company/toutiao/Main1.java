package z_Company.toutiao;

import java.util.*;
import static java.lang.Math.max ;

/**
 * Created by tangjialiang on 2018/4/15.
 */

/**
 *
 3
 3 1 2 3
 3 2 4 6
 3 3 4 6
 */

public class Main1 {

    public int sol(int n, int[] arr) {
        int window = arr[n-1] - arr[0] ;

        TreeMap<Integer, Integer> map = new TreeMap<>() ;
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i) ;
        }

        for (int i = 0; i < n; i++) {
            int val = arr[i] ;

            int leftDiff = val - arr[0] ;
            int rightDiff = val - arr[n-1] ;
            int localW = max(leftDiff, rightDiff) ;
        }

        return window ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        int N = sc.nextInt() ;
        for (int j=0; j<N; j++) {
            int n = sc.nextInt() ;
            int[] arr = new int[n] ;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt() ;
            }
            Main1 main = new Main1() ;
            int sol = main.sol(n, arr);

            System.out.println(sol);
        }
    }
}
