package zzz_niuke.wangyi._2018_School;

import java.io.* ;
import java.util.* ;

public class _2_Solution {
    /**
     * 为了得到一个数的"相反数",我们将这个数的数字顺序颠倒,然后再加上原先的数得到"相反数"。例如,为了得到1325的"相反数",首先我们将该数的数字顺序颠倒,我们得到5231,之后再加上原先的数,我们得到5231+1325=6556.如果颠倒之后的数字有前缀零,前缀零将会被忽略。例如n = 100, 颠倒之后是1.
     输入描述:
     输入包括一个整数n,(1 ≤ n ≤ 10^5)


     输出描述:
     输出一个整数,表示n的相反数

     输入例子1:
     1325

     输出例子1:
     6556
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        String _1_i = null ;
        _1_i = br.readLine() ;

        _2_Solution sol = new _2_Solution() ;
        String res = sol.work(_1_i) ;
        System.out.println(res) ;
    }


    private int[] num = null ;

    private String work(String n) {
        num = new int[n.length()+1] ;

        for(int pos=n.length()-1; pos>=0; pos--) {
            int posA = pos ;
            int posB = n.length()-1-pos ;

            int count = Integer.parseInt(n.substring(posA, posA+1)) + Integer.parseInt(n.substring(posB, posB+1)) ;
            num[pos+1] = count ;
        }

        int carr = 0 ;
        for(int pos=num.length-1; pos>=0; pos--) {
            int count = (carr + num[pos]) ;
            num[pos] = count % 10 ;
            carr = count / 10 ;
        }

        StringBuilder sb = new StringBuilder() ;
        Boolean isBegin = true ;
        for(int i=0; i<num.length; i++) {
            if (num[i]==0) {
                if (isBegin) continue;
                sb.append(num[i]) ;
            } else {
                isBegin = false ;
                sb.append(num[i]) ;
            }
        }
        return sb.toString() ;
    }
}
