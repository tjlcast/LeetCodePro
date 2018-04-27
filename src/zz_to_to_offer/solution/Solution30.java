package zz_to_to_offer.solution;

/**
 * Created by tangjialiang on 2018/4/26.
 */
public class Solution30 {
    static public class Solution {
        public int FindGreatestSumOfSubArray(int[] array) {
            int maxAns = Integer.MIN_VALUE ;

            int total = 0 ;
            for (Integer num : array) {
                total += num ;
                if (maxAns < total) maxAns = total ;

                if (total < 0) {
                    total = 0 ;
                }
            }

            return maxAns ;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6} ;

        Solution sol = new Solution() ;
        int i = sol.FindGreatestSumOfSubArray(array);

        System.out.println(i) ;
    }
}
