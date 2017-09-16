package z_Company.DeepGlint._9_10;

/**
 * Created by tangjialiang on 2017/9/16.
 */
public class The1th {
    /**
     * 对一种含60张不同牌面的扑克牌进行完美的鸽尾式洗牌，方法为：
     * 1／ 60张牌叠方在一起，从下至上编号为1，2，。。。，60；
     * 2／ 将1，2，。。。，30放至于左边，将31，32，。。。60放至于右边；
     * 3／ 从左边开始，轮流从这两部分牌叠的最底部取出一张放至新牌叠的顶端；
     * 4／ 当左右两部分牌都取完时，新牌叠即为洗好的牌。
     *
     * 请问，最初的第k张牌在洗过n遍后在新牌叠中的位置是第几张？
     *
     * Input Format
     * 输入只有一行，包含k和n两个数字，中间以空格隔开。
     *
     * Constraints
     * 1<= k <= 60
     * 0<= n < 2^31
     *
     * Output Format
     * 输出一个1至60的整数，表示牌叠中由下至上的位置。
     *
     * Sample Input 0
     * 20 1
     * Sample Outpu 0
     * 39
     */
    public static void main(String[] args) {
        int k = 20 ;
        int n = 1 ;

        The1th the1th = new The1th() ;
        int work = the1th.work(k, n);

        System.out.println("work is " + work) ;
    }

    public int work(int k, int n) {
        Solution solution = new Solution() ;
        int work = solution.work(k, n);
        return work ;
    }

    public class Solution {
        public int work(int k, int n) {
            int pos = k ;
            for(int t=0; t<n; t++) {
                if (pos <= 30) {
                    pos = onLeft(pos) ;
                } else {
                    pos = onRight(pos) ;
                }
            }

            return pos ;
        }

        private int onLeft(int pos) {
            return ((pos-1) * 2 + 1) % 60 ;
        }

        private int onRight(int pos) {
            return ((pos) * 2) % 60 ;
        }
    }
}
