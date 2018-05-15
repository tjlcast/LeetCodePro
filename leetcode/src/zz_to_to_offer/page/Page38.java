package zz_to_to_offer.page;

/**
 * Created by tangjialiang on 2018/2/26.
 */
public class Page38 {

    int rows ;
    int cols ;

    public boolean solution(int[][] matrix, int num) {
        try {
            rows = matrix.length ;
            cols = matrix[0].length ;
        } catch (Exception e) {
            return false ;
        }

        int row = 0 ;
        int col = cols-1 ;

        while(row<rows && col>=0) {
            if (matrix[row][col] == num) return true ;
            else if(matrix[row][col] < num) {
                row++ ;
            } else {
                col-- ;
            }
        }

        return false ;
    }

    public static void main(String[] args) {
        Page38 page = new Page38() ;

        int num = 7 ;
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        } ;

        boolean solution = page.solution(matrix, num);
        System.out.println("The result is " + solution) ;
    }
}
