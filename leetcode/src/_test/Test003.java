package _test;

import java.util.LinkedList;

/**
 * Created by tangjialiang on 2018/4/3.
 */
public class Test003 {

    public static int[] work(int[] arr, int window) {
        // todo
        int[] ans = new int[arr.length - window + 1] ;
        int idx = 0 ;
        LinkedList<Integer> list = new LinkedList<>() ;



        return null ;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7} ;
        int window = 3 ;

        int[] work = work(arr, window);

        for (Integer i :
                work) {
            System.out.print(i + " ");
        }
        System.out.println() ;
    }
}
