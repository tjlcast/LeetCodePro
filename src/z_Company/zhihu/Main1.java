package z_Company.zhihu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by tangjialiang on 2018/4/10.
 */

public class Main1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        while(sc.hasNext()) {
            int n = sc.nextInt() ;
            int count = count(n);
            System.out.println(count);
        }
    }

    public static int count(int n) {
        int count = 0 ;
        int[] num = new int[n] ;
        Arrays.fill(num, 9) ;

        while(hasNextNum(num)) {

            if (isRight(num))
                count++ ;
            nextNum(num) ;
        }

        return count ;
    }

    private static boolean isRight(int[] num, int a) {
        HashMap<Integer, Integer> recoder = new HashMap<>() ;

        for(Integer i : num) {
            if (i%2==0) recoder.put(2, recoder.getOrDefault(2, 0)+i/2) ;
            if (i%3==0) recoder.put(3, recoder.getOrDefault(3, 0)+i/3) ;
            if (i%5==0) recoder.put(5, recoder.getOrDefault(5, 0)+i/5) ;
            if (i%7==0) recoder.put(7, recoder.getOrDefault(7, 0)+i/7) ;
        }

        return false ;
    }

    private static boolean isRight(int[] num) {
        int even = 1 ;
        int odd = 1 ;
        for(int i=1; i<=num.length; i++) {
            if (i%2 == 0) {
                even *= num[i-1] ;
            } else {
                odd *= num[i-1] ;
            }
        }

        if (even == odd) {
            return true ;
        }
        return false ;
    }

    private static void nextNum(int[] num) {
        int carr = -1 ;
        for(int i=num.length-1; i>=0; i--) {
            if (num[i] == 0) {
                num[i] = 9;
                carr = -1;
            } else {
                num[i] += carr ;
                break ;
            }
        }
    }

    private static boolean hasNextNum(int[] num) {
        if (num[0] == 0) return false ;
        return true ;
    }

}