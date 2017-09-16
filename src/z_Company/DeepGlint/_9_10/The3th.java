package z_Company.DeepGlint._9_10;

/**
 * Created by tangjialiang on 2017/9/16.
 */
public class The3th {
    /**
     * Tic-Tac-Toe是一种双人棋类游戏：棋盘为3*3的方格，两人分别执黑子和白子，白子先手；
     * 两人轮流在9个格子内落子，每次至能落一子。当某一方的棋子在棋盘上构成一行／或一列／或者一条对角线时，
     * 这一方获胜，游戏结束。若两房在下满棋盘后都未获胜，则为平局，游戏结束。为了方便表示，
     * 我们用两个数字表示棋盘上的9个不同的骡子位置，如下图所示：
     *      00  01  02
     *      10  11  12
     *      20  21  22
     *
     * 对于一个游戏结束后的棋剧，请判断该棋局的比赛结果。
     *
     *Input Format：
     * 输入包括三行： 第一行为两个大于等于2，小于等于5的整数，由空格隔开，分别表示白子的数量和黑子的数量，
     * 其黑子树不大于白子数；第二行和第三行分别为白子于黑子的位置，每个位置由两个数（0， 1或2）组成，以空格
     * 隔开。
     * 一行内的不同位置之间也由空格隔开。
     *
     * Output Format：
     * 输出一个字符表示该棋局的结果：X表示黑子胜，O表示白子胜，D表示平局，E表示非法局面。
     *
     * Sample Input 0
     * 4 3
     * 0 0 0 2 1 2 2 2
     * 0 1 1 0 2 1
     *
     * Sample Output 0
     * O
     */

    public static void main(String[] args) {

    }

    class Solution {
        int rows = -1 ;
        int cols = -1 ;

        int[] rowSame = null ;
        int[] colSame = null ;
        int[] diagSame = null ;

        public char doWork(int[][] grid) {
            // pre work
            rows = grid.length ;
            cols = grid[0].length ;

            rowSame = new int[rows] ;
            colSame = new int[cols] ;
            diagSame = new int[2] ;

            int judge = judge(grid);

            if (judge == 1) {
                return 'X';
            } else if (judge==2) {
                return 'O' ;
            } else if (judge==0) {
                return 'D' ;
            } else {
                return 'E' ;
            }
        }

        private int judge(int[][] grid) {

            // line
            for(int row=0; row<rows; row++) {
                int who = grid[row][0] ;
                for(int col=0; col<cols; col++) {
                    if (who!=0 && who!=grid[row][col]) {
                        who = 0 ;
                    }
                }
                rowSame[row] = who ;
            }

            // column
            for(int col=0; col<cols; col++) {
                int who = grid[0][col] ;
                for(int row=0; row<rows; row++) {
                    if (who!=0 && who!=grid[row][col]) {
                        who = 0 ;
                    }
                }
                colSame[col] = who ;
             }

            // diagonal
            int who1 = grid[0][0] ;
            int who2 = grid[0][cols-1] ;
            for(int i=0; i<rows; i++) {
                if (who1!=0 && who1!=grid[0+i][0+i]) {
                    who1 = 0 ;
                }
                if (who2!=0 && who2!=grid[0+1][2-i]) {
                    who2 = 0 ;
                }
            }
            diagSame[0] = who1 ;
            diagSame[1] = who2 ;

            int whoWin = 0 ;
            for(Integer who : rowSame) {
                if (who!=0 && whoWin == 0) whoWin = who ;
                if (who!=0 && whoWin != who) return -1 ;
            }
            for(Integer who : colSame) {
                if (who!=0 && whoWin == 0) whoWin = who ;
                if (who!=0 && whoWin != who) return -1 ;
            }
            for(Integer who : diagSame) {
                if (who!=0 && whoWin == 0) whoWin = who ;
                if (who!=0 && whoWin != who) return -1 ;
            }

            return whoWin ;
        }
    }
}
