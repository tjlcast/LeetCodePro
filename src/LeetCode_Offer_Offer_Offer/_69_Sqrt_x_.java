package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/11.
 */
public class _69_Sqrt_x_ {
    /**
     * Implement int sqrt(int x).

     Compute and return the square root of x.
     */

    public static void main(String[] args) {
        int x = 2147395599 ;

        _69_Sqrt_x_ sqrt_x_ = new _69_Sqrt_x_();
        int work = sqrt_x_.work(x);

        System.out.println("work is: " + work) ;
    }

    public int work(int x) {
        Solution solution = new Solution();
        int i = solution.mySqrt(x);
        return i ;
    }

    class Solution {
        /**
         * 保证所有的计算均在Integer的范围类
         */
        public int mySqrt(int x) {
            if (x == 0) return 0 ;

            int l = 1 ;
            int r = Integer.MAX_VALUE ;

            while(true) {
                int mid = l + (r - l) / 2 ;
                if (mid > x / mid) {
                    r = mid - 1;
                } else {
                    // 在这个位置可以保证mid的值小于等于x. 故考虑下一个值即可。
                    if ((mid+1) > (x)/(mid+1))
                            return mid ;
                    l = mid + 1 ;
                }
            }
        }
    }
}
