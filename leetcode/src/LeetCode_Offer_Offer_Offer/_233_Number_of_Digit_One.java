package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2018/1/28.
 */
public class _233_Number_of_Digit_One {

    public static void main(String[] args) {
        int n = 12 ;

        Solution sol = new Solution() ;
        int ans = sol.countDigitOne(n) ;

        System.out.println("The work is: " + ans) ;
    }

    static class Solution {
        public int countDigitOne(int n) {
            long count = 0 ;
            for(long i=1; i<=n; i=i*10) {
                long a = n / i ;
                long b = n % i ;

                count += (a + 8) / 10 * i ;
                if (a % 10 == 1) count += b +1 ;
            }
            return (int)count ;
        }
    }
}
