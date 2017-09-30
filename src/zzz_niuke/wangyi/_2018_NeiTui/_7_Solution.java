package zzz_niuke.wangyi._2018_NeiTui;

import java.io.* ;
import java.util.* ;

public class _7_Solution {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/d996665fbd5e41f89c8d280f84968ee1
     来源：牛客网

     小易老师是非常严厉的,它会要求所有学生在进入教室前都排成一列,并且他要求学生按照身高不递减的顺序排列。有一次,n个学生在列队的时候,小易老师正好去卫生间了。学生们终于有机会反击了,于是学生们决定来一次疯狂的队列,他们定义一个队列的疯狂值为每对相邻排列学生身高差的绝对值总和。由于按照身高顺序排列的队列的疯狂值是最小的,他们当然决定按照疯狂值最大的顺序来进行列队。现在给出n个学生的身高,请计算出这些学生列队的最大可能的疯狂值。小易老师回来一定会气得半死。
     输入描述:

     输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),表示学生的人数
     第二行为n个整数h[i](1 ≤ h[i] ≤ 1000),表示每个学生的身高


     输出描述:

     输出一个整数,表示n个学生列队可以获得的最大的疯狂值。

     如样例所示:
     当队列排列顺序是: 25-10-40-5-25, 身高差绝对值的总和为15+30+35+20=100。
     这是最大的疯狂值了。
     示例1
     输入

     5
     5 10 25 40 25
     输出

     100
     */

    public static void main(String[] args) throws Exception {
        String i1 = null ;
        String i2 = null ;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        i1 = br.readLine() ;
        i2 = br.readLine() ;
        // convert
        int num = Integer.parseInt(i1) ;
        int[] heights = new int[num] ;
        String[] i2_ = i2.split(" ") ;
        for(int i=0; i<num; i++) heights[i] = Integer.parseInt(i2_[i]) ;

        _7_Solution sol = new _7_Solution() ;
        String res = sol.work(num, heights) ;

        System.out.println(res) ;
    }

    private LinkedList<Integer> sortedHeights = new LinkedList<>() ;
    private LinkedList<Integer> resHeights = new LinkedList<>() ;

    public String work(int num, int[] heights) {
        for(Integer i : heights) sortedHeights.add(i) ;
        Collections.sort(sortedHeights) ;

        int step = 0 ; // 0 or 1 ;
        while(!sortedHeights.isEmpty()) {
            if (sortedHeights.size() >= 2) {
                // get two heights ;
                int bigger = sortedHeights.removeLast() ;
                int lesser = sortedHeights.removeFirst() ;
                if (step == 0) {
                    resHeights.addFirst(bigger);
                    resHeights.addLast(lesser);
                } else {
                    resHeights.addFirst(lesser);
                    resHeights.addLast(bigger);
                }
            } else {
                int lastOne = sortedHeights.removeFirst() ;
                if (step == 0) {
                    resHeights.addFirst(lastOne);
                } else {
                    resHeights.addLast(lastOne);
                }
            }
            step = (step + 1) % 2 ;
        }

        int diff = 0 ;
        for(int i=0; i<num-1; i++) {
            diff += Math.abs(resHeights.get(i) - resHeights.get(i+1)) ;
        }

        return diff + "" ;
    }


}
