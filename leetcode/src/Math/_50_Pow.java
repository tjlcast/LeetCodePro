package Math;

/**
 * Created by tangjialiang on 2017/8/7.
 */
public class _50_Pow {
    public static void main(String[] args) {
        _50_Pow pow = new _50_Pow();

        double x = 2 ;
        int n = -3 ;
        double v = pow.work(x, n);
        System.out.println("ans is v: " + v) ;
    }

    public double work(double x, int n) {
        return new Solution().myPow(x, n) ;
    }

    public class Solution {
        public double myPow(double x, int n) {
           if (n == 0)
               return 1.0 ;
           if (n < 0) {
               if (n == Integer.MIN_VALUE)
                   return 1.0 / (myPow(x, Integer.MAX_VALUE) * x) ;
               else
                   return 1.0 / myPow(x, -n) ;
           }
           return x * myPow(x, n-1) ;
        }
    }
}
