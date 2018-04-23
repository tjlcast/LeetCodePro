package zz_to_to_offer.page;

/**
 * Created by tangjialiang on 2018/3/5.
 */
public class Page127 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16, 17}
        } ;

        printMatrix(matrix);
    }

    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}} ;

    public static void printMatrix(int[][] matrix) {
        int rows = matrix.length ;
        int cols = matrix[0].length ;
        boolean isVisited[][] = new boolean[rows][cols] ;

        int row = 0 ;
        int col = 0 ;
        int direct = 0 ;

        while (true) {
            isVisited[row][col] = true ;
            System.out.println(matrix[row][col]) ;

            boolean isBreak = true ;
//            for(; ; direct = ) {
//                int newR = row + directions[direct][0] ;
//                int newC = col + directions[direct][1] ;
//
//                try {
//                    if(!isVisited[newR][newC]) {
//                        isBreak = false ;
//                        row = newR ;
//                        col = newC ;
//                        break ;
//                    }
//                } catch (Exception e) {
//
//                }
//            }
//
//            if (isBreak) break ;
        }
    }

    private int getNextDirect(int direct) {
        return direct % directions.length ;
    }
}
