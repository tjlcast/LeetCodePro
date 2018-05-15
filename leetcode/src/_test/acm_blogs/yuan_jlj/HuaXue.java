package _test.acm_blogs.yuan_jlj;

import java.util.Scanner;

/**
 * Created by tangjialiang on 2018/4/1.
 */
public class HuaXue {
    /**
     * https://blog.csdn.net/yuan_jlj/article/details/49586543
     *
     * 描述
     Michael喜欢滑雪百这并不奇怪， 因为滑雪的确很刺激。可是为了获得速度，滑的区域必须向下倾斜，而且当你滑到坡底，你不得不再次走上坡或者等待升降机来载你。
     Michael想知道载一个区域中最长底滑坡。区域由一个二维数组给出。数组的每个数字代表点的高度。下面是一个例子
     1 2 3 4 5

     16 17 18 19 6

     15 24 25 20 7

     14 23 22 21 8

     13 12 11 10 9

     一个人可以从某个点滑向上下左右相邻四个点之一，当且仅当高度减小。在上面的例子中，一条可滑行的滑坡为24-17-16-1。当然25-24-23-...-3-2-1更长。事实上，这是最长的一条。
     输入
     第一行表示有几组测试数据，输入的第二行表示区域的行数R和列数C(1 <= R,C <= 100)。下面是R行，每行有C个整数，代表高度h，0<=h<=10000。
     后面是下一组数据；
     输出
     输出最长区域的长度。
     样例输入
     1
     5 5
     1 2 3 4 5
     16 17 18 19 6
     15 24 25 20 7
     14 23 22 21 8
     13 12 11 10 9
     样例输出
     25
     */

    static class Solution {

        int[][] dp ;
        int r ;
        int c ;

        public int work(int[][] matrix, int r, int c) {
            int ans = 0 ;
            dp = new int[r][c] ;
            this.r = r ;
            this.c = c ;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    ans = Math.max(ans, travel(matrix, i, j, Integer.MAX_VALUE)) ;
                }
            }
            return ans ;
        }

        public int travel(int[][] matrix, int row, int col, int lastHight) {
            if (row<0 || col<0) { return 0; }
            if (row>=r || col>=c) { return 0; }
            if (dp[row][col] != 0) return dp[row][col] ;
            if (matrix[row][col] >= lastHight) return 0 ;

            int a = Math.max(travel(matrix, row+1, col, matrix[row][col])
                    , travel(matrix, row,col+1, matrix[row][col]) ) ;
            int b = Math.max(travel(matrix, row-1, col, matrix[row][col])
                    , travel(matrix, row, col-1, matrix[row][col]) ) ;
            int maxSteps = Math.max(a, b) ;
            dp[row][col] = maxSteps + 1 ;

            return dp[row][col] ;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int cases = sc.nextInt() ;

        for (int i = 0; i < cases; i++) {
            int r = sc.nextInt() ;
            int c = sc.nextInt() ;
            int[][] matrix = new int[r][c] ;
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    matrix[j][k] = sc.nextInt() ;
                }
            }
            Solution sol = new Solution() ;
            int work = sol.work(matrix, r, c);
            System.out.println(work) ;
        }
    }
}
