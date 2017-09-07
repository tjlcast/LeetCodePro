package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/3.
 */
public class _29_Divide_Two_Integers {
    /**
     * Divide two integers without using multiplication, division and mod operator.

     If it is overflow, return MAX_INT.
     */

    public static void main(String[] args) {
        int dividend = 7 ;
        int divisor = 3 ;

        _29_Divide_Two_Integers divide_two_integers = new _29_Divide_Two_Integers();
        int work = divide_two_integers.work(dividend, divisor);
        System.out.println("work is: " + work) ;

    }

    public int work(int dividend, int divisor) {
        Solution solution = new Solution();
        int divide = solution.divide(dividend, divisor);
        return divide ;
    }

    class Solution {
        public int divide(int dividend, int divisor) {
            long m = dividend;
            long n = divisor;
            long absn = Math.abs(n);
            if(divisor==0){
                return Integer.MAX_VALUE;
            }
            if(dividend==0){
                return 0;
            }

            boolean flag1 = dividend<0?true:false;
            boolean flag2 = divisor<0?true:false;
            m = Math.abs(m);
            n = Math.abs(n);
            if(m<n)
                return 0;
            long ct = 1;//当前倍数
            long tempresult = 0;
            while((n<<1)<=m){
                n = n<<1;
                ct = ct<<1;
            }

            while(true){
                tempresult = tempresult + ct;

                m = m - n;
                n = n>>1;
                ct = ct>>1;

                while(m<n){
                    n = n>>1;
                    ct = ct>>1;
                }
                if(n<absn)
                    break;
            }

            if((flag1==true&&flag2==false) || (flag1==false&&flag2==true))
                return -(int)tempresult;
            if(tempresult>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            return (int)tempresult;
        }
    }
}
