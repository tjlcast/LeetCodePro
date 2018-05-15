package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/1.
 */
public class _7_Reverse_Integer {
    /**
     *
     Reverse digits of an integer.

     Example1: x = 123, return 321
     Example2: x = -123, return -321
     */

    public static void main(String[] args) {
        int x = -123 ;

        _7_Reverse_Integer reverse_integer = new _7_Reverse_Integer();
        int work = reverse_integer.work(x);

        System.out.println("work is: " + work) ;
    }

    public int work(int x) {
        Solution solution = new Solution();
        int reverse = solution.reverse(x);
        return reverse ;
    }

    class Solution {
        boolean flag = true ;

        public int reverse(int x) {
            int i1 = -1 ;

            if (x < 0) {
                flag = false ;
            }

            String num = new Integer(x).toString() ;
            int i = num.indexOf("-");
            if (i>=0) {
                num = num.substring(i+1) ;
            }
            StringBuilder sb = new StringBuilder(num) ;
            sb.reverse() ;

            try {
                i1 = Integer.parseInt(sb.toString());
                if (!flag) i1 = i1 * (-1);
            } catch (Exception e) {
                return 0 ;
            }

            return i1 ;
        }
    }
}
