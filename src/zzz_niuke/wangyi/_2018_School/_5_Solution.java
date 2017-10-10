package zzz_niuke.wangyi._2018_School;

import java.io.* ;
import java.util.* ;

public class _5_Solution {
    /**
     * 小易有一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。
     牛博士给小易出了一个难题:
     对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数。
     小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
     输入描述:
     输入的第一行为数列的个数t(1 ≤ t ≤ 10),
     接下来每两行描述一个数列A,第一行为数列长度n(1 ≤ n ≤ 10^5)
     第二行为n个正整数A[i](1 ≤ A[i] ≤ 10^9)


     输出描述:
     对于每个数列输出一行表示是否可以满足牛博士要求,如果可以输出Yes,否则输出No。

     输入例子1:
     2
     3
     1 10 100
     4
     1 2 3 4

     输出例子1:
     Yes
     No
     */

    public static void main(String[] args) throws Exception {
        int t ;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        String _1 = br.readLine() ;
        t = Integer.parseInt(_1) ;

        for(int i=0; i<t; i++) {
            int n ;
            String _2, _3 ;

            _2 = br.readLine() ;
            n = Integer.parseInt(_2) ;

            _3 = br.readLine() ;
            String[] _3_l = _3.split(" ") ;
            int[] nums = new int[n] ;
            for(int j=0; j<n; j++) nums[j] = Integer.parseInt(_3_l[j]) ;

            _5_Solution sol = new _5_Solution() ;
            String ans = sol.work(n, nums) ;

            System.out.println(ans) ;
        }
    }

    private String work(int n, int[] nums) {
        int total4 = 0 ;
        int total2 = 0 ;
        for(Integer num : nums) {
            if (num % 4 == 0 && num!=0) {
                total4 += 1 ;
            } else if (num % 2==0 && num!=0) {
                total2 += 1 ;
            }
        }

        if (total2 + total4*2 >= n) return "Yes" ;
        return "No" ;
    }
}
