package HashMap;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by tangjialiang on 2017/5/20.
 */
public class _36_Valid_Sudoku
{
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.'},
                {'6', '.', '.', '1', '9', '5'},
                {'.', '9', '8', '.', '.', '.'},
                {'8', '.', '.', '.', '6', '.'},
                {'4', '.', '.', '8', '.', '3'},
                {'7', '.', '.', '.', '2', '.'},
        } ;

        boolean work = new _36_Valid_Sudoku().work(board);
        System.out.println(work) ;
    }

    public boolean work(char[][] board) {
        return new Solution().isValidSudoku(board) ;
    }

    public class Solution {
        public boolean isValidSudoku(char[][] board) {
            if (board[0].length == 0) return false ;

            HashMap<Integer, HashSet<Character>> col_set = new HashMap<>() ;
            HashSet<Character> row_set = new HashSet<>() ;
            HashMap<Integer, HashSet<Character>> _9_set = new HashMap<>() ;

            for (int i=0; i<board[0].length; i++) col_set.put(i, new HashSet<>()) ;
            for (int i=0; i<board[0].length; i++) if (!_9_set.containsKey(i/3)) _9_set.put(i/3, new HashSet<>()) ;

            for(int i=0; i<board.length; i++) {
                for(int j=0; j<board[i].length; j++) {
                    char word = board[i][j] ;
                    if (word=='.') continue;

                    // 加入一行
                    if (row_set.contains(word)) return false ;
                    row_set.add(word) ;

                    // 加入一列
                    if (col_set.get(j).contains(word)) return false ;
                    col_set.get(j).add(word) ;

                    // 加入9宫格
                    if (_9_set.get(new Integer(j/3)).contains(word)) return false ;
                    _9_set.get(new Integer(j/3)).add(word) ;


                }

                // 清除9宫格
                if (i%3==2) {
                    for(HashSet set : _9_set.values()) {
                        set.clear();
                    }
                }

                // 清除一行
                row_set.clear();
            }
            // 清除一列
            // ？输入矩阵一定是合法的子九宫格？

            return true ;
        }
    }
}
