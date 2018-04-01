package _test.acm_blogs.yuan_jlj;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by tangjialiang on 2018/4/1.
 */
public class HuiChang {
    /**
     *
     * https://blog.csdn.net/yuan_jlj/article/details/49588523
     *
     * 描述
     学校的小礼堂每天都会有许多活动，有时间这些活动的计划时间会发生冲突，需要选择出一些活动进行举办。
     小刘的工作就是安排学校小礼堂的活动，每个时间最多安排一个活动。现在小刘有一些活动计划的时间表，他想尽可能的安排更多的活动，请问他该如何安排。
     输入
     第一行是一个整型数m(m<100)表示共有m组测试数据。
     每组测试数据的第一行是一个整数n(1<n<10000)表示该测试数据共有n个活动。
     随后的n行，每行有两个正整数Bi,Ei(0<=Bi,Ei<10000),分别表示第i个活动的起始与结束时间（Bi<=Ei)
     输出
     对于每一组输入，输出最多能够安排的活动数量。
     每组的输出占一行
     样例输入
     2
     2
     1 10
     10 11
     3
     1 10
     10 11
     11 20
     样例输出
     1
     2
     提示
     注意：如果上一个活动在t时间结束，下一个活动最早应该在t+1时间开始
     */

    static class Line implements Comparable<Line>{
        int b ;
        int e ;
        public Line(int b, int e) {
            this.b = b ;
            this.e = e ;
        }

        @Override
        public int compareTo(Line o) {
            if (this.e == o.e) return this.b - o.b ;
            return this.e - o.e ;
        }
    }

    static class Solution {

        public int work(Line[] lines) {
            Arrays.sort(lines);

            int ans = 0 ;
            int lastE = -1 ;

            for (Line line :
                    lines) {
                if (line.b > lastE) {
                    ans++ ;
                    lastE = line.e ;
                }
            }

            return ans ;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int m = sc.nextInt() ;

        for (int i = 0; i < m; i++) {
            int n = sc.nextInt() ;
            Line[] lines = new Line[n] ;
            for (int j = 0; j < n; j++) {
                int B = sc.nextInt() ;
                int E = sc.nextInt() ;
                lines[j] = new Line(B, E) ;
            }

            Solution sol = new Solution() ;
            int work = sol.work(lines);

            System.out.println(work) ;
        }
    }
}
