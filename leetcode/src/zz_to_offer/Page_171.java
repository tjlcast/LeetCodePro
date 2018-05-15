package zz_to_offer;

/**
 * Created by tangjialiang on 2017/8/29.
 */
public class Page_171 {
    /**
     * 输入一个整型数组，数组里有正数也有负数。数组中一个或连续多个整数组成一个子数组。求
     * 所有子数组的和的最大值。要求时间复杂度为O（n）。
     * @param args
     */
    public static void main(String[] args) {
        int[] datas = {1, -2, 3, 10, -4, 7, 2, -5} ;
        int work = new Page_171().work(datas);
        System.out.println(work) ;
    }

    public int work(int[] datas) {
        int greatestSumOfSubArray = new MySolution().findGreatestSumOfSubArray(datas);
        return greatestSumOfSubArray ;
    }

    class MySolution {
        int findGreatestSumOfSubArray(int[] datas) {
            int[] dp = new int[datas.length] ;

            int lastDp = 0 ;
            for(int i=0; i<dp.length; i++) {
                if (lastDp <= 0) {
                    dp[i] = datas[i] ;
                } else {
                    dp[i] = datas[i] + lastDp ;
                }
                lastDp = dp[i] ;
            }

            int ans = Integer.MIN_VALUE ;
            for(int sum : dp) {
                ans = Math.max(ans, sum) ;
            }

            return ans ;
        }
    }
}
