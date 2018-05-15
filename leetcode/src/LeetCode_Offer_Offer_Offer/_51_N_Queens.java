package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/7.
 */
public class _51_N_Queens {
    /**
     * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



     Given an integer n, return all distinct solutions to the n-queens puzzle.

     Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

     For example,
     There exist two distinct solutions to the 4-queens puzzle:

     [
     [".Q..",  // Solution 1
     "...Q",
     "Q...",
     "..Q."],

     ["..Q.",  // Solution 2
     "Q...",
     "...Q",
     ".Q.."]
     ]
     */

    public static void main(String[] args) {
        int n = 4 ;

        _51_N_Queens n_queens = new _51_N_Queens();
        List<List<String>> work = n_queens.work(n);

        System.out.println("work is: ") ;
        for(List<String> matix : work) {
            System.out.println("a matix is: ") ;
            for(String line : matix) {
                System.out.println(line) ;
            }
        }

    }

    public List<List<String>> work(int n) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.solveNQueens(n);
        return lists ;
    }

    class Solution {

        private int len = -1 ;
        private List<List<String>> ansList = new LinkedList<>() ;

        public List<List<String>> solveNQueens(int n) {
            len = n ;

            StringBuilder sb = new StringBuilder() ;
            for(int i=0; i<len; i++) sb.append(i) ;

            generate(0, sb);

            return ansList ;
        }

        private void generate(int pos, StringBuilder str) {
            if (pos == len) {
                // generate matrix
                List<String> matrix = new LinkedList<>() ;

                for(int row=0; row<str.length(); row++) {
                    int i = row ;
                    int j = str.charAt(row) - '0' ;
                    StringBuilder line = new StringBuilder() ;
                    for(int col=0; col<str.length(); col++) {
                        if (i==row && j==col) {
                            line.append("Q") ;
                        } else {
                            line.append(".");
                        }
                    }
                    matrix.add(line.toString()) ;
                }
                ansList.add(matrix) ;
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
