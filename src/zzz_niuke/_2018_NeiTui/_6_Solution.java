package zzz_niuke._2018_NeiTui;

import java.io.* ;
import java.util.* ;

public class _6_Solution {
    // merge find set

    public String work(int len, int[] rows, int[] cols) {
        return "" ;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        String i1 = br.readLine() ;
        String i2 = br.readLine() ;
        String i3 = br.readLine() ;

        int len = Integer.parseInt(i1) ;
        String[] i2_ = i2.split(" ") ;
        int[] rows = new int[len] ; for(int i=0; i<len; i++) rows[i] = Integer.parseInt(i2_[i]) ;
        String[] i3_ = i3.split(" ") ;
        int[] cols = new int[len] ; for(int i=0; i<len; i++) cols[i] = Integer.parseInt(i3_[i]) ;

        _6_Solution main = new _6_Solution() ;
        String res = main.work(len, rows, cols) ;

        System.out.println(res) ;

    }
}