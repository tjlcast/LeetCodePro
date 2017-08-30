package zz_to_offer;

/**
 * Created by tangjialiang on 2017/8/22.
 */
public class Page_90 {
    public static void main(String[] args) {

    }

    class MySolution {
        public double power(double base, int exponent) {
            // should seperate the exponent to  decimal and int
            if (exponent > 0) {
                return powerBig(base, exponent) ;
            }

            if (exponent < 0) {
                return powerLow(base, exponent) ;
            }

            return powerEqu(base, exponent) ;
        }

        private double powerBig(double base, int exponent) {
            double ans = 1 ;
            for(int i=0; i<exponent; i++) {
                ans = base * ans ;
            }
            return ans ;
        }

        private double powerEqu(double base, int exponent) {
            return 1 ;
        }

        private double powerLow(double base, int exponent) {
            return powerLow((1/base), exponent*(-1)) ;
        }
    }
}
