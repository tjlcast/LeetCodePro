package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/7.
 */
public class _52_N_Queens_II {

    public static void main(String[] args) {
        int n = 2 ;

        _52_N_Queens_II n_queens_ii = new _52_N_Queens_II();
        int work = n_queens_ii.work(n);

        System.out.println("work is: " + work) ;
    }

    public int work(int n) {
        Solution solution = new Solution();
        int i = solution.totalNQueens(n);
        return i ;
    }

    class Solution {

        private int len = -1 ;
        private int total = 0 ;

        public int totalNQueens(int n) {
            len = n ;

            StringBuilder sb = new StringBuilder() ;
            for(int i=0; i<len; i++) sb.append(i) ;

            generate(0, sb);

            return total ;
        }

        private void generate(int pos, StringBuilder str) {
            if (pos == len) {
                total++ ;
                return ;
            }

            for(int i=pos; i<len; i++) {
                char c = str.charAt(pos) ;
                str.setCharAt(pos, str.charAt(i));
                str.setCharAt(i, c);

                if (!canAttack(pos, str)) generate(pos+1, new StringBuilder(str));
            }
        }

        private boolean canAttack(int pos, StringBuilder str) {

            for(int i=0; i<pos; i++) {
                if (Math.abs(pos - i) == Math.abs((str.charAt(pos)-'0') - (str.charAt(i)-'0'))) {
                    return true ;
                }
            }

            return false ;
        }
    }
}
