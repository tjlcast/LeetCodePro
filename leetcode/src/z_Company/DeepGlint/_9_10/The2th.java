package z_Company.DeepGlint._9_10;

/**
 * Created by tangjialiang on 2017/9/16.
 */
public class The2th {
    /**
     * 小明是一个爱动脑经的同学，有一天走楼梯的时候，他想到一个问题：刚开始时他在楼梯的第0级，若每次只能跨上一级或二级或三级，
     * 要走上第m级，共有多少中走法？
     *
     * Input Format
     * 输入一个小于等于30的正整数
     *
     * Constraints
     * N/A
     *
     * Output Format
     * 输出一个整数，表示一共有多少种走法。
     *
     * Sample Input 0
     * 1
     * Sample output 0
     * 1
     */

    public static void main(String[] args) {
        int n = 9 ;
        The2th the2th = new The2th();

        int work = the2th.work(n);

        System.out.println("work is " + work) ;
    }

    public int work(int n) {
        Solution solution = new Solution();
        int i = solution.doWork(n);
        return i ;
    }

    class Solution {
        /**
         * tips: 海伦公式 + 最小矩形的面积等于该三角形的2倍。
         */
        public int doWork(int n) {
            if (n <= 1) {
                return 1 ;
            }
            if (n == 2) {
                return 2 ;
            }

            return doWork(n-3) + doWork(n-2) + doWork(n-1) ;
        }
    }
}
