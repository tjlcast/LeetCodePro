package zz_to_offer;

/**
 * Created by tangjialiang on 2017/8/12.
 */
public class Page_38 {
    /**
     * * 在一个二维数组中，每行／每列都递增。查找给定的一个数
     * */

    public static void main(String[] args) {
        int[][] matix = {
                {1, 2, 3},
                {1, 5, 9}
        } ;
        int num = 5 ;

        boolean work = new Page_38().work(matix, num);
        System.out.println("ans is " + work) ;
    }

    public boolean work(int[][] matrix, int num) {
        return new ProblemPage38().inMultArray(matrix, num) ;
    }

    class ProblemPage38 {
        /**
        * 性质：矩阵里的数字的左上角的数小于等于目标值，右下角的数大于等于目标值。
        *
        * 思路：选取矩阵的最右上的数进行比较，如果目标值比选取值大则可以排除选取值所在的那一行，小则可以排除选取值所在的那一列。
        * */
        boolean inMultArray(int[][] matrix, int num) {
            if (matrix==null || matrix.length==0 || matrix[0].length==0) return false ;
            int rows = matrix.length ;
            int cols = matrix[0].length ;

            boolean ans = preCursion(matrix, rows, cols, num) ;
            return ans ;
        }

        public boolean mySolution(int[][] matrix, int rows, int cols, int num) {
            return preCursion(matrix, rows, cols, num) ;
        }

        boolean preCursion(int[][] matrix, int rows, int cols, int num) {
            return myRecursion(matrix, 0, cols-1, num) ;
        }

        boolean myRecursion(int[][] martix, int row, int col, int num) {
            boolean ans = false ;
            int rows = martix.length ;
            int cols = martix[0].length ;

            int rightTop = martix[row][col] ;
            if (rightTop == num) return true ;
            if (row==rows-1 && col==0) return ans ;

            if (rightTop < num) {
                if(row < rows) return myRecursion(martix, row+1, col, num) ;
            } else {
                if(col > 0) return myRecursion(martix, row, col-1, num) ;
            }

            return false ;
        }

        boolean mySolution1(int[][] martix, int rows, int cols, int num) {
            boolean ans = false ;
            int row = 0 ;
            int col = cols-1 ;

            while(true) {
                int rightTop = martix[row][col] ;

                if (rightTop == num) {
                    ans = true ;
                    break ;
                }
                if (row==rows-1 && col==0) {
                    break ;
                }

                if (rightTop < num) {
                    if (row<rows-1) row+=1 ;
                } else {
                    if (col>0) col-=1 ;
                }
            }

            return ans ;
        }
    }
}
