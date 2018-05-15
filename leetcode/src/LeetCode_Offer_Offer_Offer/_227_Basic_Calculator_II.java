package LeetCode_Offer_Offer_Offer;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/1/25.
 */
public class _227_Basic_Calculator_II {

    public static void main(String[] args) {
        String s = " 3+5 / 2 " ;
//        String s = " 3/2 " ;
//        String s = "3+2*2" ;
//        String s = "1*2-3/4+5*6-7*8+9/10" ;

        Solution sol = new Solution() ;
        int ans = sol.calculate(s) ;

        System.out.println("The work is: " + ans) ;
    }

    static class Solution {
        public int calculate(String s) {
            LinkedList<Integer> nums = new LinkedList<>() ;

            int num = 0 ;
            for(int i=0; i<s.length(); i++) {
                if ('0'<=s.charAt(i) && s.charAt(i)<='9') {

                    while(i<s.length() && '0'<=s.charAt(i) && s.charAt(i)<='9') {
                        num = num * 10 + s.charAt(i) - '0' ;
                        i++ ;
                    }
                    i-- ;

                    if (i==0 || lastOp(s, i) == '+' || lastOp(s, i) == ' ') {
                        nums.addLast(num) ;
                    } else if (lastOp(s, i) == '-') {
                        nums.addLast((-1)*num) ;
                    } else if (lastOp(s, i) == '*') {
                        Integer pop = nums.removeLast();
                        nums.addLast(num * pop) ;
                    } else if (lastOp(s, i) == '/') {
                        Integer pop = nums.removeLast();
                        nums.addLast(pop / num) ;
                    }
                } else {
                    num = 0 ;
                }
            }

            int total = 0 ;
            for(Integer i : nums) total += i ;

            return total ;
        }

        private char lastOp(String s, int i) {
            int idx = i-1;
            while(idx >= 0) {
                char c = s.charAt(idx) ;
                if (c=='+' || c=='-' || c=='*' || c=='/') return c ;
                idx-- ;
            }
            return  ' ';
        }
    }
}
