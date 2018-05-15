package zzz_niuke.wangyi._2018_School;

import java.io.* ;
import java.util.* ;

/**
 * Created by tangjialiang on 2017/10/10.
 */
public class _7_Solution {
    /**
     * 小Q和牛博士合唱一首歌曲,这首歌曲由n个音调组成,每个音调由一个正整数表示。
     对于每个音调要么由小Q演唱要么由牛博士演唱,对于一系列音调演唱的难度等于所有相邻音调变化幅度之和, 例如一个音调序列是8, 8, 13, 12, 那么它的难度等于|8 - 8| + |13 - 8| + |12 - 13| = 6(其中||表示绝对值)。
     现在要对把这n个音调分配给小Q或牛博士,让他们演唱的难度之和最小,请你算算最小的难度和是多少。
     如样例所示: 小Q选择演唱{5, 6}难度为1, 牛博士选择演唱{1, 2, 1}难度为2,难度之和为3,这一个是最小难度和的方案了。
     输入描述:
     输入包括两行,第一行一个正整数n(1 ≤ n ≤ 2000) 第二行n个整数v[i](1 ≤ v[i] ≤ 10^6), 表示每个音调。


     输出描述:
     输出一个整数,表示小Q和牛博士演唱最小的难度和是多少。

     输入例子1:
     5
     1 5 6 2 1

     输出例子1:
     3
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        String _1l = br.readLine();
        int n = Integer.parseInt(_1l) ;

        String _2l = br.readLine() ;
        String[] _2ll = _2l.split(" ") ;
        int[] nums = new int[n] ;
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(_2ll[i]) ;
        }

        _7_Solution sol = new _7_Solution() ;
        String ans = sol.work(n, nums) ;

        System.out.println(ans) ;
    }

    private int[][] dp = new int[2000][2000] ;

    private String work(int n, int[] nums) {
        dp[0][1] = 0 ;
        dp[1][0] = 0 ;

        for(int i=1; i<n; i++) {
            for(int j=1; j<n; j++) {
                int minV = Math.min(i, j) ;
                int min_i_k = Integer.MAX_VALUE ;
                int min_k_j = Integer.MAX_VALUE ;
                for(int k=0; k<minV; k++) {
                    if (min_i_k > dp[i][k] + Math.abs(nums[k] - nums[j])) {
                        min_i_k = dp[i][k] + Math.abs(nums[k] - nums[j]) ;
                    }
                    if (min_k_j > dp[k][j] + Math.abs(nums[k] - nums[j])) {
                        min_k_j = dp[k][j] + Math.abs(nums[k] - nums[j]) ;
                    }
                }
                dp[i][j] = Math.min(min_i_k, min_k_j) ;
            }
        }

        return dp[n-1][n-1] + "" ;
    }

}
