package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/14.
 */
public class _79_Word_Search {
    /**
     * Given a 2D board and a word, find if the word exists in the grid.

     The word can be constructed from letters of sequentially adjacent cell,
     where "adjacent" cells are those horizontally or vertically neighboring.
     The same letter cell may not be used more than once.

     For example,
     Given board =

     [
     ['A','B','C','E'],
     ['S','F','C','S'],
     ['A','D','E','E']
     ]
     word = "ABCCED", -> returns true,
     word = "SEE", -> returns true,
     word = "ABCB", -> returns false.
     */

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        } ;

        String word = "ABCB" ;

        _79_Word_Search word_search = new _79_Word_Search();
        boolean work = word_search.work(board, word);

        System.out.println("work is: " + work) ;
    }

    public boolean work(char[][] board, String word) {
        Solution solution = new Solution();
        boolean exist = solution.exist(board, word);
        return exist ;
    }

    class Solution {
        private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}} ;
        private int[][] isVisited = null ;
        private int rows = -1 ;
        private int cols = -1 ;

        public boolean exist(char[][] board, String word) {
            this.rows = board.length ;
            this.cols = board[0].length ;
            isVisited = new int[rows][cols] ;

            boolean ans = false ;
            for(int r = 0; r<rows; r++) {
                for(int c=0; c<cols; c++) {
                    ans = ans || findByPosition(board, r, c, word) ;
                }
            }

            return ans ;
        }

        private boolean findByPosition(char[][] board, int row, int col, String str) {
            if (str.length() ==0 ) return true ;
            if (!isValid(board, row, col)) return false ;

            char word = str.charAt(0);
            if (board[row][col] != word) return false ;
            isVisited[row][col] = 1 ;

            boolean ans = false ;
            for(int k=0; k<directions.length; k++) {
                int newRow = row + directions[k][0] ;
                int newCol = col + directions[k][1] ;
                ans = ans || findByPosition(board, newRow, newCol, str.substring(1, str.length())) ;
            }

            isVisited[row][col] = 0 ;

            return ans ;
        }

        private boolean isValid(char[][] board, int newRow, int newCol) {
            if (newRow < 0 || newRow>=rows) return false ;
            if (newCol < 0 || newCol>=cols) return false ;
            if (isVisited[newRow][newCol] == 1) return false ;
            return true ;
        }
    }
}
