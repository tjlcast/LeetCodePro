package LeetCode_Offer_Offer_Offer;

import java.util.Stack;

/**
 * Created by tangjialiang on 2017/9/4.
 */
public class _37_Sudoku_Solver {
    /**
     * Write a program to solve a Sudoku puzzle by filling the empty cells.

     Empty cells are indicated by the character '.'.

     You may assume that there will be only one unique solution.


     A sudoku puzzle...


     ...and its solution numbers marked in red.
     */

    public static void main(String[] args) {
        char[][] board = {
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}
        } ;

        _37_Sudoku_Solver sudoku_solver = new _37_Sudoku_Solver();
        sudoku_solver.work(board);

    }

    public void work(char[][] board) {
        Solution solution = new Solution();
        solution.solveSudoku(board);
    }

    class Solution {

        public void solveSudoku(char[][] board) {
            judgePro(board, 0) ;
        }


        private boolean judgePro(char[][] board, int index) {
            // index must be invalid

            int i = index / 9 ;
            int j = index % 9 ;

            char c = board[i][j];

            if (c=='.') {
                for(int k=1; k<=9; k++) {
                    board[i][j] = (char)('0' + k) ;
                    if (isVaild(board, i, j)) {
                        if (i==8 && j==8) { return true ;}
                        boolean b = judgePro(board, index + 1);
                        if (b) return b ;
                    }
                    board[i][j] = '.' ;
                }
                return false ;
            } else {
                if (i==8 && j==8) { return true ;}
                return judgePro(board, index+1) ;
            }
        }

        private boolean isVaild(char[][] board, int x, int y) {
            int i, j ;

            // for col
            for(i=0; i<9; i++)
                if (i!=x && board[i][y]==board[x][y])
                    return false ;

            // for row
            for(j=0; j<9; j++)
                if (j!=y && board[x][j]==board[x][y])
                    return false ;

            // for matrix
            for(i=3*(x/3); i<3*(x/3+1); i++)
                for(j=3*(y/3); j<3*(y/3+1); j++)
                    if (i!=x && j!=y && board[i][j]==board[x][y])
                        return false ;

            return true ;
        }

    }
}
