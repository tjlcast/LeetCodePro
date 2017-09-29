package zzz_niuke._2018_NeiTui;

import java.io.* ;
import java.util.* ;

public class _6_Solution {
    // merge find set

    private int[] rows ;
    private int[] cols ;
    private int[] arr ;
    private int len = -1 ;

    public String work(int len, int[] rows, int[] cols) {
        this.len = len ;
        this.rows = rows ;
        this.cols = cols ;
        this.arr = new int[len] ;

        // for every possible position that can be the in-node,
        // and compute every nodes' distance to the in-node.
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                // every possible in-node
                PriorityQueue<Integer> diffs = new PriorityQueue<>() ;

                for (int k=0; k<len; k++) {
                    // every nodes
                    int diff = getDiff(rows[i], rows[k], cols[j], cols[k]);
                    diffs.add(diff) ;
                }

                // the number of diffs must be len
                int total = 0 ;
                for(int step=1; step<=len; step++) {
                    total += diffs.poll() ;
                    arr[step-1] = total ;
                }
            }
        }

        return l2s(arr) ; // ans 2 str
    }

    private int getDiff(int r1, int r2, int c1, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2) ;
    }

    private String l2s(int[] arr) {
        StringBuilder sb = new StringBuilder() ;
        for(Integer i : arr) sb.append(sb + " ") ;
        return sb.toString().trim() ;
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