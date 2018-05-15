package LeetCode_Offer_Offer_Offer;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2017/9/3.
 */
public class _36_Valid_Sudoku {
    /**
     * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

     The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


     A partially filled sudoku which is valid.

     Note:
     A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
     */

    public static void main(String[] args) {

    }

    public boolean work(char[][] board) {
        Solution solution = new Solution();
        boolean validSudoku = solution.isValidSudoku(board);
        return validSudoku ;
    }

    class Solution {

        private HashMap<Character, Integer> times = new HashMap<>() ;
        private int rows = -1 ;
        private int cols = -1 ;
        private int matrixR = 3 ;
        private int matrixC = 3 ;

        public Solution() {
            times.put('1', 1) ;
            times.put('2', 1) ;
            times.put('3', 1) ;
            times.put('4', 1) ;
            times.put('5', 1) ;
            times.put('6', 1) ;
            times.put('7', 1) ;
            times.put('8', 1) ;
            times.put('9', 1) ;
        }

        public boolean isValidSudoku(char[][] board) {
            if (board==null || board.length==0) return false ;
            rows = board.length ;
            cols = board[0].length ;

            // eache row
            for(int i=0; i<rows; i++) {
                boolean b = judgeRow(board, i);
                if (b==false) return false ;
            }

            // each col
            for(int i=0; i<cols; i++) {
                boolean b = judgeCol(board, i);
                if (b==false) return false ;
            }

            // each matrix
            for (int r=0; r<rows; r+=matrixR) {
                for (int c=0; c<cols; c+=matrixC) {
                    boolean b = judgeMatrix(board, r, c);
                    if (b==false) return false ;
                }
            }

            return true ;
        }

        private boolean judgeRow(char[][] board, int row) {
            HashMap<Character, Integer> copyTimes = new HashMap<>() ;
            for(int col=0; col<cols; col++) {
                char c = board[row][col];
                if (c!='.' && (!times.containsKey(c) || copyTimes.getOrDefault(c, 0)==1)) {
                    return false ;
                }
                if (c!='.') copyTimes.put(c, 1) ;
            }
            return true ;
        }

        private boolean judgeCol(char[][] board, int col) {
            HashMap<Character, Integer> copyTimes = new HashMap<>() ;
            for(int row=0; row<rows; row++) {
                char c = board[row][col];
                if (c!='.' && (!times.containsKey(c) || copyTimes.getOrDefault(c, 0)==1)) {
                    return false ;
                }
                if (c!='.') copyTimes.put(c, 1) ;
            }
            return true ;
        }

        private boolean judgeMatrix(char[][] board, int row, int col) {
            // matrix
            HashMap<Character, Integer> copyTimes = new HashMap<>() ;

            for(int r=row; r<row+matrixR; r++) {
                for(int c=col; c<col+matrixC; c++) {
                    char ch = board[r][c];
                    if (ch!='.' && (!times.containsKey(ch) || copyTimes.getOrDefault(ch, 0)==1)) {
                        return false ;
                    }
                    if (ch!='.') copyTimes.put(ch, 1) ;
                }
            }
            return true ;
        }
    }
}
