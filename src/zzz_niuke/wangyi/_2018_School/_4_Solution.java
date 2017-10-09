package zzz_niuke.wangyi._2018_School;

import java.io.* ;
import java.util.* ;

public class _4_Solution {
    /**
     * 魔法王国一共有n个城市,编号为0~n-1号,n个城市之间的道路连接起来恰好构成一棵树。
     小易现在在0号城市,每次行动小易会从当前所在的城市走到与其相邻的一个城市,小易最多能行动L次。
     如果小易到达过某个城市就视为小易游历过这个城市了,小易现在要制定好的旅游计划使他能游历最多的城市,请你帮他计算一下他最多能游历过多少个城市(注意0号城市已经游历了,游历过的城市不重复计算)。
     输入描述:
     输入包括两行,第一行包括两个正整数n(2 ≤ n ≤ 50)和L(1 ≤ L ≤ 100),表示城市个数和小易能行动的次数。
     第二行包括n-1个整数parent[i](0 ≤ parent[i] ≤ i), 对于每个合法的i(0 ≤ i ≤ n - 2),在(i+1)号城市和parent[i]间有一条道路连接。


     输出描述:
     输出一个整数,表示小易最多能游历的城市数量。

     输入例子1:
     5 2
     0 1 2 3

     输出例子1:
     3
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        String _1i = null ;
        _1i = br.readLine() ;

        int n, L ;
        String[] _1i_ = _1i.split(" ") ;
        n = Integer.parseInt(_1i_[0]) ;
        L = Integer.parseInt(_1i_[1]) ;

        String _2i = null ;
        _2i = br.readLine() ;
        int[] parents = new int[n-1] ;
        String[] _2i_ = _2i.split(" ") ;
        for(int i=0; i<parents.length; i++) {
            parents[i] = Integer.parseInt(_2i_[i]) ;
        }

        _4_Solution sol = new _4_Solution() ;
        String res = sol.work(n, L, parents) ;
        System.out.println(res) ;
    }

    public String work(int n, int L, int[] parents) {
        LinkedList<Integer> queue = new LinkedList<Integer>() ;

        int step = 1 ;

        return "" ;
    }
}
