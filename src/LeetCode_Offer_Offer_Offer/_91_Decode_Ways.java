package LeetCode_Offer_Offer_Offer;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2017/9/20.
 */
public class _91_Decode_Ways {
    /**
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:

     'A' -> 1
     'B' -> 2
     ...
     'Z' -> 26
     Given an encoded message containing digits, determine the total number of ways to decode it.

     For example,
     Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

     The number of ways decoding "12" is 2.
     */

    public static void main(String[] args) {
        String s = "12" ;

        _91_Decode_Ways decode_ways = new _91_Decode_Ways();
        int work = decode_ways.work(s);

        System.out.println("work is: " + work) ;
    }

    public int work(String s) {
        Solution solution = new Solution();
        int i = solution.numDecodings(s);

        return i ;
    }

    class Solution {
        private int len = -1 ;
        private String s = null ;
        private HashMap<Integer, Integer> dp = new HashMap<>() ;

        public int numDecodings(String s) {
            this.s = s ;
            len = s.length() ;

            if (len == 0) return 0 ;

            return countNumDecoding(0) ;
        }

        private int countNumDecoding(int pos) {
            if (dp.containsKey(pos)) {
                return dp.get(pos) ;
            }
            if (pos == len) {dp.put(pos, 1); return 1 ;}
            if (s.substring(pos).equals("10") || s.substring(pos).equals("20")) {dp.put(pos, 1); return 1 ;}
            if (pos == len-1) {
                if (s.charAt(pos)=='0') {dp.put(pos, 0); return 0 ;}
                dp.put(pos, 1) ;
                return 1 ;
            }

            int l = s.charAt(pos) - '0' ;
            int r = s.charAt(pos+1) - '0' ;
            int num = l * 10 + r ;

            if (num==10 || num==20) {
                int c = countNumDecoding(pos+2) ;
                dp.put(pos, c) ;
                return c ;
            } else if(num <= 26) {
                int c;
                if (l==0) c=0 ;
                else c = countNumDecoding(pos+1) + countNumDecoding(pos+2) ;
                dp.put(pos, c) ;
                return c ;
            } else {
                int c;
                if (r==0) c = 0 ;
                else c = countNumDecoding(pos+1) ;
                return c ;
            }
        }
    }
}
