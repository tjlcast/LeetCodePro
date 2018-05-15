package zz_to_to_offer.solution;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tangjialiang on 2018/3/28.
 */
public class Solution19 {

    /**
     * 4 4
     1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     */

    static public class Solution {
        ArrayList<Integer> ans = new ArrayList<>() ;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}} ;
        boolean[][] isVisited ;
        int d = 0 ;

        public ArrayList<Integer> printMatrix(int [][] matrix) {
            isVisited = new boolean[matrix.length][matrix[0].length] ;

            int row=0, col=0, d=0;

            travel(matrix, row, col, d) ;
            return ans ;
        }

        private void travel(int[][] matrix, int row, int col, int d) {
            if (!isRight(matrix, row, col)) return ;

            ans.add(matrix[row][col]) ;
            isVisited[row][col] = true ;

            for (int i = 0; i < 4; i++) {
                travel(matrix, row+directions[(d+i)%4][0], col+directions[(d+i)%4][1], d+i);
            }
        }

        private boolean isRight(int[][] matrix, int r, int c) {
            if (r<0 || c<0) return false ;
            if (r>=matrix.length || c>=matrix[0].length) return false ;
            if (isVisited[r][c]) return false ;
            return true ;
        }
    }

    static public class Solution1 {
        ArrayList<Integer> ans = new ArrayList<>() ;

        public ArrayList<Integer> printMatrix(int [][] matrix) {
            int lRow=0, lCol=0 ;
            int rRow=matrix.length-1, rCol=matrix[0].length-1 ;

            while(lRow<=rRow) {
                printEdge(matrix, lRow++, lCol++, rRow--, rCol--) ;
            }

            return ans ;
        }

        private void printEdge(int[][] matrix, int lRow, int lCol, int rRow, int rCol) {
            if (lRow == rRow) {
                ans.add(matrix[rRow][rCol]) ;
                return ;
            }

            for (int i = lCol; i < rCol; i++) {
                ans.add(matrix[lRow][i]) ;
            }
            for (int i = lRow; i < rRow; i++) {
                ans.add(matrix[i][rCol]) ;
            }
            for (int i = rCol; i > lCol; i--) {
                ans.add(matrix[rRow][i]) ;
            }
            for (int i = rRow; i > lRow; i--) {
                ans.add(matrix[i][lCol]) ;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        int n = sc.nextInt() ;
        int m = sc.nextInt() ;
        int[][] matrix = new int[n][m] ;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt() ;
            }
        }

        Solution sol = new Solution() ;
        ArrayList<Integer> integers = sol.printMatrix(matrix);

        for (Integer i :
                integers) {
            System.out.print(i + " ");
        }
        System.out.println() ;
    }
}
