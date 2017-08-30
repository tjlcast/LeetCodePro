package zz_to_offer;

/**
 * Created by tangjialiang on 2017/8/22.
 */
public class Page_78 {
    /**
     * 实现一个函数，输入一个整数，输出该数的二进制表示中1的个数。
     * 例如把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
     */
    public static void main(String[] args) {
        int n = 15 ;
        int work = new Page_78().work(n);
        System.out.println("work is: " + work) ;
    }

    public int work(int n) {
        return new MySolution().countOnes(n) ;
    }

    class MySolution {
        /**
         * 如果数字是一个无符号数值，则用0填补最左边的n位。
         * 如果数字是一个有符号数值，则用数字的符号填补最左变的n位。
         * 也就是说如果数字原先是一个正数，则右移之后在最左边补n个0；如果数字原先是负数，则右移之后在最左边补n个1。
         */

        public int countOnes(int n) {
            return moveToRight(n) ;
        }

        private int moveToRight(int n) {
            int times = 0 ;

            while(n != 0) {
                if ((n & 1) == 1) {
                    times += 1 ;
                }
                n = n >> 1 ;
            }
            return times ;
        }
    }
}
