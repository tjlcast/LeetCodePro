package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2018/1/18.
 */
public class _204_Count_Primes {
    /**
     * Description:

     Count the number of prime numbers less than a non-negative number, n.
     */

    public static void main(String[] args) {
        int n = 12 ;

        Solution solution = new Solution();
        int i = solution.countPrimes(n);

        System.out.println("The work is: " + i) ;
    }

    static public class Solution {
        public int countPrimes(int n) {
            boolean[] notPrime = new boolean[n];
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (notPrime[i] == false) {
                    count++;
                    for (int j = 2; i*j < n; j++) {
                        notPrime[i*j] = true;
                    }
                }
            }

            return count;
        }
    }
}
