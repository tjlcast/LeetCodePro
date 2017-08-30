package zz_to_offer;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2017/8/22.
 */
public class Page_76 {
    /**
     *
     * 一只青蛙可以跳上1级，也可以跳上2级,....，也可以跳上n级，问上n级有几种方法。
     * @param args
     */
    public static void main(String[] args) {
        int n = 3 ;
        int work = new Page_76().work(n);

        System.out.println("work is: " + work) ;
    }

    public int work(int n) {
        return new MySolution().compute(n) ;
    }

    class MySolution {
        HashMap<Integer, Integer> dp = new HashMap<>() ;

        public int compute(int n) {
            return go(n) ;
        }

        private int go(int n) {
            if (n==0 || n==1) return 1;
            if (n == 2) return 2 ;

            int num = 0 ;
            for(int i=1; i<=n; i++) {
                num += (dp.containsKey(n-i)) ? (dp.get(n-i)) : (go(n - i)) ;
            }

            dp.put(n, num) ;
            return num ;
        }
    }
}
