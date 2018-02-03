package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2018/2/3.
 */
public class _258_Add_Digits {

    public static void main(String[] args) {
        int num = 38 ;
        Solution sol = new Solution() ;
        int res = sol.addDigits(num) ;
        System.out.println("The result is: " + res) ;
    }

    static class Solution {
        public int addDigits(int num) {
            if (num == 0) return 0;
            return (num-1)%9+1;
        }
    }
}
