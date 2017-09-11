package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/10.
 */
public class _66_Plus_One {
    /**
     * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

     You may assume the integer do not contain any leading zero, except the number 0 itself.

     The digits are stored such that the most significant digit is at the head of the list.
     */

    public static void main(String[] args) {
        int[] digits = {9} ;

        _66_Plus_One plus_one = new _66_Plus_One();
        int[] work = plus_one.work(digits);

        System.out.println("work is; ") ;
        for(Integer i : work) System.out.println(i + " ") ;
    }

    public int[] work(int[] digits) {
        Solution solution = new Solution();
        int[] ints = solution.plusOne(digits);

        return ints ;
    }

    class Solution {
        List<Integer> sum = new LinkedList<>() ;

        public int[] plusOne(int[] digits) {
            int l = 0 ;
            int r = digits.length-1 ;
            while(l < r) {
                int swap = digits[l] ;
                digits[l] = digits[r] ;
                digits[r] = swap ;
                l++; r-- ;
            }

            for(Integer i : digits) sum.add(i) ;
            add(1, 0, 0) ;

            int[] ans = new int[sum.size()] ;
            for(int i=0; i<sum.size(); i++) {ans[sum.size()-1-i] = sum.get(i); }

            return  ans;
        }

        private void add(int addNum, int carr, int pos) {
            if (addNum + carr==0) return ;

            int otherNum = (pos>=sum.size()) ? (0) : (sum.get(pos)) ;
            int total = addNum + carr + otherNum ;

            if (pos < sum.size()) sum.set(pos, total % 10) ;
            else sum.add(total%10) ;

            int nextC = total / 10 ;
            add(0, nextC, pos+1) ;
        }
    }
}
