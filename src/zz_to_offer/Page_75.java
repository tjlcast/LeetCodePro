package zz_to_offer;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2017/8/22.
 */
public class Page_75
{
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。问跳上n级台阶有几种方法。
     * @param args
     */
    public static void main(String[] args) {
        int work = new Page_75().work(3) ;
        System.out.println("work is: " + work) ;
    }

    public int work(int n) {
        return new MySolution().comuteNWays(n) ;
    }

    class MySolution {
        HashMap<Integer, Integer> dp = new HashMap<>() ;

        public int comuteNWays(int n) {
            if (n == 0) return 1 ;
            return go(n) ;
        }

        private int go(int n) {
            if (n == 1) return 1 ;
            if (n == 2) return 2 ;
            if (dp.containsKey(n)) return dp.get(n) ;

            int num = go(n-1) + go(n-2) ;
            dp.put(n, num) ;
            return num ;
        }
    }
}
