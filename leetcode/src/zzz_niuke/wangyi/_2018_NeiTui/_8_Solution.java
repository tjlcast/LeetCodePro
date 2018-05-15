package zzz_niuke.wangyi._2018_NeiTui;

import java.io.* ;
import java.util.* ;

public class _8_Solution {
    /**
     * 小易非常喜欢拥有以下性质的数列:
     1、数列的长度为n
     2、数列中的每个数都在1到k之间(包括1和k)
     3、对于位置相邻的两个数A和B(A在B前),都满足(A <= B)或(A mod B != 0)(满足其一即可)
     例如,当n = 4, k = 7
     那么{1,7,7,2},它的长度是4,所有数字也在1到7范围内,并且满足第三条性质,所以小易是喜欢这个数列的
     但是小易不喜欢{4,4,4,2}这个数列。小易给出n和k,希望你能帮他求出有多少个是他会喜欢的数列。
     */

    public static void main(String[] args) throws Exception {
        String l1 = null ;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        l1 = br.readLine() ;

        int n, k ;
        String[] l1_ = l1.split(" ") ;
        n = Integer.parseInt(l1_[0]) ;
        k = Integer.parseInt(l1_[1]) ;

        _8_Solution sol = new _8_Solution() ;
        String res = sol.work(n, k) ;

        System.out.println(res) ;
    }

    private int n = -1 ;
    private int k = -1 ;

    private String work(int n, int k) {
        this.n = n ;
        this.k = k ;

        return count(-1,1)+"" ;
    }

    private int count(int lastVal, int pos) {
        if (pos>n) { return 1;}

        if (pos == 1) {
            int total = 0 ;
            for(int i=1; i<=k; i++) {
                total += count(i, pos+1) ;
            }
            return total ;
        }


        int total = 0 ;
        // bigger or equal to lastVal
        for(int i=1; i<=k; i++) {
            if (i >= lastVal || lastVal % i != 0) {
                total += count(i, pos+1) ;
            }
        }
        // a mod b != 0
        return total ;
    }
}
