package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/5.
 */
public class _50_Pow {
    /**
     * Implement pow(x, n).


     */

    public static void main(String[] args) {
        double x = 10 ;
        int n = 12 ;

        _50_Pow pow = new _50_Pow();
        double work = pow.work(x, n);

        System.out.println("work is: " + work) ;
    }

    public double work(double x, int n) {
        Solution solution = new Solution();
        double v = solution.myPow(x, n);
        return v ;
    }

    class Solution {
        double myPow(double x, int n) {
            if(n<0) return 1/x * myPow(1/x, -(n+1));
            if(n==0) return 1;
            if(n==2) return x*x;
            if(n%2==0) return myPow( myPow(x, n/2), 2);
            else return x*myPow( myPow(x, n/2), 2);
        }
    }

    class Solution1 {

        public double myPow(double x, int n) {
            return pow(x, n) ;
        }

        private double pow(double x, int n) {
            if (n == 0)
                return 1 ;
            if (n < 0) {
                n = -n ;
                x = 1/x ;
            }

            return (n%2==0) ? pow(x*x, n/2) : x*pow(x*x, n/2) ;
        }
    }
}
