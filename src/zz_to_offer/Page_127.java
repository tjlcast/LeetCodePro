package zz_to_offer;

import java.util.HashSet;

/**
 * Created by tangjialiang on 2017/8/24.
 */
public class Page_127 {
    /**
     * 输入一个矩阵，按照从外向里以顺时针依次打印。
     * @param args
     */
    public static void main(String[] args) {
        int[][] numbers = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}} ;
        new Page_127().work(numbers);

    }

    public void work(int[][] numbers) {
        int rows = numbers.length ;
        int cols = numbers[0].length ;
        new MySolution().PrintMatrixClockwisely(numbers, rows, cols);
    }

    class MySolution {
        /**
         * 方向顺序为： 右（0, 1）, 下（0， 1）， 左（0， -1）， 上（1， 0）。 当下一个尝试位置非法时，改变方向尝试下一个新的位置。
         */
        private HashSet<Integer> visited = new HashSet<>() ;
        private int[][] directions = {{0, 1}, {0, 1}, {0, -1}, {1, 0}} ;
        private int rows ;
        private int cols ;

        public void PrintMatrixClockwisely(int[][] numbers, int rows, int cols){
            this.rows = rows ;
            this.cols = cols ;

            go(numbers, 0, 0, 0) ;
        }

        private void go(int[][] numbers, int row, int col, int direct) {
            // do
            System.out.println(numbers[row][col]) ;
            visit(row, col);

            // new position, just try 4 time and do once.
            for(int i=0; i<4; i++) {
                int newRow = row + directions[(direct+i)%4][0] ;
                int newCol = col + directions[(direct+i)%4][1] ;

                boolean isRight = nextPosittionRight(numbers, newRow, newCol);
                if (isRight) {
                    go(numbers, newRow, newCol, (direct+i)%4) ;
                    break ;
                }
            }
            return ;
        }


        private boolean nextPosittionRight(int[][] number, int row, int col) {
            if (row<0 || row>=rows) return false ;
            if (col<0 || col>=cols) return false ;
            if (isVisited(row, col)) return false ;
            return true ;
        }

        private boolean isVisited(int row, int col) {
            return visited.contains(row*rows + col);
        }

        private void visit(int row, int col) {
            this.visited.add((row*rows + col)) ;
        }
    }
}
