package zzz_niuke.wangyi;

import java.io.* ;
import java.util.* ;

/**
 * Created by tangjialiang on 2017/10/11.
 */

public class _2_TreeHeight {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        String _i1 = br.readLine() ;
        int n = Integer.parseInt(_i1) ;

        int[] parents = new int[n] ;
        parents[0] = -1 ;

        for(int i=0; i<n-1; i++) {
            String _i2 = br.readLine() ;
            String[] _i2l = _i2.split(" ") ;
            int r = Integer.parseInt(_i2l[0]) ;
            int c = Integer.parseInt(_i2l[1]) ;

            parents[c] = r ;
        }

        _2_TreeHeight sol = new _2_TreeHeight() ;
        String ans = sol.work(parents, n);

        System.out.println(ans) ;
    }

    public String work(int[] parents, int n) {
        if (n<=0) return 0+"" ;

        LinkedList<Integer> l = new LinkedList<>() ;

        int maxLen = 1 ;
        int[] dists = new int[n] ;

        for(int i=1; i<n; i++) {
            int dist = 0 ;
            int p = i ;
            boolean y = (i==282)?(true):(false) ;
            while(p != -1) {
                if(y)l.add(p) ;
                if (dists[p] != 0) {
                    dist = dists[p] + dist ;
                    break ;
                }
                dist += 1;
                p = parents[p] ;
            }
            dists[i] = dist ;
            maxLen = Math.max(maxLen, dist) ;
        }

        return maxLen+"" ;
    }
}
