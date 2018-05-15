package zzz_niuke.wangyi._2018_NeiTui;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by tangjialiang on 2017/9/28.
 */

public class _5_Solution {

    public long work(long x, long f, long d, long p) {
        long button = p + x ;

        long fp = f * p ;
        double fp_button = (double)fp / (double)button ;
        double d_button = (double)d / (double)button ;

        long t = (long)(fp_button + d_button) ;

        while (d < t*x) {
            t = t -1 ;
        }

        return t ;
    }

    public static void main(String[] args) throws Exception {
        int x = -1 ;
        int f = -1 ;
        int d = -1 ;
        int p = -1 ;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        String i1 = br.readLine() ;
        String[] i1_ = i1.split(" ") ;

        x = Integer.parseInt(i1_[0]) ;
        f = Integer.parseInt(i1_[1]) ;
        d = Integer.parseInt(i1_[2]) ;
        p = Integer.parseInt(i1_[3]) ;

        _5_Solution main = new _5_Solution() ;
        long res = main.work(x, f, d, p) ;

        System.out.println(res) ;
    }
}