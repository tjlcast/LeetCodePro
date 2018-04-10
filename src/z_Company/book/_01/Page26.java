package z_Company.book._01;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by tangjialiang on 2018/4/2.
 */
public class Page26 {

    static class Solution {
        public int work(int[][] matrix, int rows, int cols) {
            int ans = 0 ;

            int[] arr = new int[cols] ;
            Arrays.fill(arr, 0);
            for (int i=0; i<rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] == 0) {arr[j] = 0; }
                    else {arr[j]+=matrix[i][j]; }
                }
                int area = getMaxArea(arr) ;
                ans = Math.max(ans, area) ;
            }

            return ans ;
        }

        private int getMaxArea(int[] arr) {
            if (arr==null || arr.length==0) {
                return 0 ;
            }

            int maxArea = 0 ;
            Stack<Integer> stack = new Stack<Integer>() ;

            for (int i = 0; i < arr.length; i++) {
                while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    int k = stack.pop() ;
                    int j = (stack.isEmpty()) ? (-1) : (stack.peek()) ;
                    int outArea = (i - j - 1) * arr[k] ;
                    maxArea = Math.max(maxArea, outArea) ;
                }
                stack.push(i) ;
            }

            while(!stack.isEmpty()) {
                int k = stack.pop() ;
                int j = (stack.isEmpty()) ? (-1) : (stack.peek()) ;
                int outArea = (arr.length - j - 1) * arr[k] ;
                maxArea = Math.max(maxArea, outArea) ;
            }

            return maxArea ;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 0}
        } ;

        int rows = matrix.length ;
        int cols = matrix[0].length ;

        Solution sol = new Solution() ;
        int work = sol.work(matrix, rows, cols);

        System.out.print(work);
    }
}
