package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2018/2/3.
 */
public class _263_Ugly_Number {

    public static void main(String[] args) {
        int num = 6 ;

        Solution sol = new Solution() ;
        boolean res = sol.isUgly(num) ;

        System.out.println("The result is: " + res) ;
    }

    static class Solution {
        public boolean isUgly(int num) {
            if (num < 1) return false ;

            while(num > 1) {
                if (num>=5 && num%5==0) num=num/5 ;
                else if (num>=3 && num%3==0) num=num/3 ;
                else if (num>=2 && num%2==0) num=num/2 ;
                else return false ;
            }
            return true ;
        }
    }
}
