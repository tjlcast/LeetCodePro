package LeetCode_Offer_Offer_Offer;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2018/1/17.
 */
public class _202_Happy_Number {
    /**
     * Write an algorithm to determine if a number is "happy".

     A happy number is a number defined by the following process:
     Starting with any positive integer,
     replace the number by the sum of the squares of its digits,
     and repeat the process until the number equals 1 (where it will stay),
     or it loops endlessly in a cycle which does not include 1.
     Those numbers for which this process ends in 1 are happy numbers.

     Example: 19 is a happy number

     1^2 + 9^2 = 82
     8^2 + 2^2 = 68
     6^2 + 8^2 = 100
     1^2 + 0^2 + 0^2 = 1
     */

    public static void main(String[] args) {
        int n = 19 ;

        Solution solution = new Solution();
        boolean happy = solution.isHappy(n);

        System.out.println("The work is; " + happy) ;
    }

    static class Solution {
        private HashMap<String, Integer> recorder = new HashMap<>() ;

        public boolean isHappy(int n) {

            int num = doCompute(n+"") ;
            int last = n ;

            while(num != 1) {
                if (recorder.containsKey(num+"")) return false ;
                num = doCompute(num+"") ;
            }

            return true ;
        }

        private int doCompute(String num) {
            if(recorder.containsKey(num)) return recorder.get(num) ;
            int total = 0 ;
            for(int i=0; i<num.length(); i++) {
                int v = Integer.valueOf(num.substring(i, i + 1)) ;
                total += (v * v) ;
            }
            recorder.put(num, total) ;
            return total ;
        }
    }
}
