package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/11/18.
 */
public class _115_Distinct_Subsequences {

    class Solution {
        public int numDistinct(String s, String t) {
            return countSubStr(s, t) ;
        }

        private int countSubStr(String s, String t) {
            int count = 0 ;

            int lenS = s.length() ;
            int lenT = t.length() ;

            int[][] state = new int[lenS+1][lenT+1] ; // ? meaning

            // begin state ? how
            state[0][0] = 1 ;
            for(int i=1; i<=lenS; i++) state[i][0] =  1;
            for(int j=1; j<=lenT; j++) state[0][j] =  0;

            for (int j=1; j<=lenT; j++) { // how to do next ;
                for (int i=1; i<=lenS; i++) {
                    state[i][j] = state[i-1][j] ;
                    if (s.charAt(i-1) == t.charAt(j-1)) {
                        state[i][j] += state[i-1][j-1] ;
                    }
                }
            }

            return state[lenS][lenT] ;
        }
    }
}
