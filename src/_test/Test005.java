package _test;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by tangjialiang on 2018/4/10.
 */
public class Test005 {
    public static String nextNum(String s) {
        int num = 0 ;
        for (int i = 0; i < s.length(); i++) {
            int i1 = s.charAt(i) - '0';
            num += (i1 * i1) ;
        }
        return num+"" ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        int n = sc.nextInt() ;
        String s = "" + n;

        int[] arr = new int[s.length()] ;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i) - '0' ;
        }

        HashSet<String> hasDo = new HashSet<>() ;
        while(true) {
            if (hasDo.contains(s)) {
                System.out.println("false") ;
                break ;
            } else {
                if (s.equals("1")) {
                    System.out.println("true") ;
                    break ;
                }
            }
            hasDo.add(s) ;
            s = nextNum(s) ;
        }

        return ;
    }
}
