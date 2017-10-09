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
     10

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
        generateStr(x, n);
        return (ans==null)?(""):(ans) ;
    }

    private void generateStr(int x, int n) {
        System.out.format("x: %d n: %d\n", x, n) ;

        int count = x ;

        while(count < n) {
            if (count>=2 && count+2+2<=n) {
                count = count + 4 ;
                nums.addFirst(2);
            }
            else if (count>=2 && count+2+1<=n) {
                count = count + 3 ;
                nums.addFirst(2);
            }
            else if (count>=1 && count+1+2<=n) {
                count = count + 3 ;
                nums.addFirst(1);
            }
            else if (count>=1 && count+1+1<=n) {
                count = count + 2 ;
                nums.addFirst(1);
            }
            else if (count>=0 && count+0+2<=n) {
                count = count + 2 ;
                nums.addFirst(0);
            }
            else if (count>=0 && count+0+1<=n) {
                count = count + 1 ;
                nums.addFirst(0);
            }
        }

        if (count == n) {
            StringBuilder sb = new StringBuilder() ;
            for(Integer i : nums) {
                if (i==0) {
                    sb.append(" ") ;
                } else {
                    sb.append(i+"") ;
                }
            }
            ans = sb.toString().trim() ;
        }


        return ;
    }

}
