package zz_to_offer;

import java.util.Arrays;

/**
 * Created by tangjialiang on 2017/8/22.
 */
public class Page_94 {

    /**
     * 输入数字n, 按顺序打印从1最大的n位十进制数。考虑输入是位数，可能超过Integer的范围，使用数组进行模拟。
     * @param args
     */

    public static void main(String[] args) {
        int n = 4 ;
        new Page_94().work(n);
    }

    public void work(int n) {
        new MySolution().print1ToMaxOfNDigits(n);
    }

    class MySolution {
        /**
         * 对数组进行加法：考虑整数相加，对每一位的操作是 aNum[i] + bNum[i] + carry。故可以使用递归进行处理。
         */
        int[] num = null ;

        public void print1ToMaxOfNDigits(int n) {
            num = new int[n+1] ;

            while(addNum() != 1) {
                printNum();
            }
        }

        private void printNum() {

            StringBuilder sb = new StringBuilder() ;
            boolean isZeros = true ;

            for(int i=num.length-1; i>=0; i--) {  // 这段消去前端0，可记
                if (num[i]==0 && isZeros) { continue; }
                if (num[i]!=0) isZeros=false ;

                sb.append(num[i]) ;
            }

            System.out.println(sb.toString()) ;
        }

        private int addNum() {
            int carr = 1 ;
            int pos = 0 ;

            while(carr != 0) {  // 这段进行进位操作，可记
                if (pos == num.length-1) return 1 ;
                int v = (num[pos] + 1) % 10 ;
                carr = (num[pos] + 1) / 10 ;

                num[pos] = v;
                pos += 1 ;
            }
            return 0 ;
        }
    }
}
