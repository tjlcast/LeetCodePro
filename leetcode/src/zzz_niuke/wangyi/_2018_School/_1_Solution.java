package zzz_niuke.wangyi._2018_School;

import java.io.* ;
import java.util.* ;

/**
 * Created by tangjialiang on 2017/10/2.
 */
public class _1_Solution {
    /**
     * 小易准备去魔法王国采购魔法神器,购买魔法神器需要使用魔法币,但是小易现在一枚魔法币都没有,但是小易有两台魔法机器可以通过投入x(x可以为0)个魔法币产生更多的魔法币。
     魔法机器1:如果投入x个魔法币,魔法机器会将其变为2x+1个魔法币
     魔法机器2:如果投入x个魔法币,魔法机器会将其变为2x+2个魔法币
     小易采购魔法神器总共需要n个魔法币,所以小易只能通过两台魔法机器产生恰好n个魔法币,小易需要你帮他设计一个投入方案使他最后恰好拥有n个魔法币。

     输入描述:
     输入包括一行,包括一个正整数n(1 ≤ n ≤ 10^9),表示小易需要的魔法币数量。


     输出描述:
     输出一个字符串,每个字符表示该次小易选取投入的魔法机器。其中只包含字符'1'和'2'。

     输入例子1:
     +10

     输出例子1:
     122
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        String i0 = null ;
        i0 = br.readLine() ;

        int n = Integer.parseInt(i0) ;
        _1_Solution sol = new _1_Solution() ;
        String res = sol.work(0, n) ;

        System.out.println(res) ;
    }

    String ans = null ;
    private LinkedList<Integer> nums = new LinkedList<>() ;

    public String work(int x, int n) {
        generateStr(n);
        return (ans==null)?(""):(ans) ;
    }

    private void generateStr(int n) {
        int count = n ;
        while(count > 0) {
            if (count % 2 != 0) {
                // current num is odd, add 1
                nums.add(1) ;
                count = (count - 1) / 2 ;
            } else {
                // current num id even, add 2
                nums.add(2) ;
                count = (count - 2) / 2 ;
            }
        }

        // list 2 string
        StringBuilder sb = new StringBuilder() ;
        for(Integer i : nums) {
            sb.append(i) ;
        }
        sb.reverse() ;
        this.ans = sb.toString() ;
    }

    private void generateStr(int count, int n) {
        // machine 1 can add exp 1 coins
        // machine 2 can add exp 2 coins

        if (count == n) {
            StringBuilder sb = new StringBuilder() ;
            for(Integer i : nums) {
                sb.append(i) ;
            }
            sb.reverse() ;
            this.ans = sb.toString() ;
        }

        if (count < n) {
            int diff = n - count ;
            if (diff >= (count + 2)) {
                nums.addFirst(2);
                generateStr(count + (count + 2), n);
                nums.removeFirst() ;
            }

            // if ans has been found
            if (ans != null) return ;

            if (diff >= (count + 1)) {
                nums.addFirst(1) ;
                generateStr(count + (count + 1), n);
                nums.removeFirst() ;
            }
        }
   }

}
