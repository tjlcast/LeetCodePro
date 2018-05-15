package zzz_niuke.wangyi._2018_NeiTui;

import java.io.* ;
import java.util.* ;

public class _6_Solution {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/27f3672f17f94a289f3de86b69f8a25b
     来源：牛客网

     小易将n个棋子摆放在一张无限大的棋盘上。第i个棋子放在第x[i]行y[i]列。同一个格子允许放置多个棋子。每一次操作小易可以把一个棋子拿起并将其移动到原格子的上、下、左、右的任意一个格子中。小易想知道要让棋盘上出现有一个格子中至少有i(1 ≤ i ≤ n)个棋子所需要的最少操作次数.

     输入描述:

     输入包括三行,第一行一个整数n(1 ≤ n ≤ 50),表示棋子的个数
     第二行为n个棋子的横坐标x[i](1 ≤ x[i] ≤ 10^9)
     第三行为n个棋子的纵坐标y[i](1 ≤ y[i] ≤ 10^9)


     输出描述:

     输出n个整数,第i个表示棋盘上有一个格子至少有i个棋子所需要的操作数,以空格分割。行末无空格

     如样例所示:
     对于1个棋子: 不需要操作
     对于2个棋子: 将前两个棋子放在(1, 1)中
     对于3个棋子: 将前三个棋子放在(2, 1)中
     对于4个棋子: 将所有棋子都放在(3, 1)中
     示例1
     输入

     4
     1 2 4 9
     1 1 1 1
     输出

     0 1 3 10
     */


    /**
     * the possible positions must the nodes input or two nodes input combine a matrix.
     */

    private int[] rows ;
    private int[] cols ;
    private int[] arr ;
    private int len = -1 ;

    public String work(int len, int[] rows, int[] cols) {
        this.len = len ;
        this.rows = rows ;
        this.cols = cols ;
        this.arr = new int[len] ; for(int i=0; i<len; i++) arr[i] = Integer.MAX_VALUE ;

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
                    arr[step-1] = Math.min(total, arr[step-1]) ;
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
        for(Integer i : arr) sb.append(i + " ") ;
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