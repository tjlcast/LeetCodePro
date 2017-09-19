package LeetCode_Offer_Offer_Offer;

import java.util.Stack;

/**
 * Created by tangjialiang on 2017/9/19.
 */
public class _85_Maximal_Rectangle {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0',},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        } ;

        int work = new _85_Maximal_Rectangle().work(matrix);

        System.out.println("work is: " + work) ;
    }

    public int work(char[][] matrix) {
        Solution solution = new Solution();
        int i = solution.maximalRectangle(matrix);
        return i ;
    }

    class Solution {
        int rows = -1 ;
        int cols = -1 ;
        int[] curHeights = null ;

        public int maximalRectangle(char[][] matrix) {
            int area = 0 ;

            if (matrix==null || matrix.length==0) return area ;

            rows = matrix.length ;
            cols = matrix[0].length ;
            curHeights = new int[cols] ;

            for(int r=0; r<rows; r++) {
                for(int c=0; c<cols; c++) {
                    if (matrix[r][c] == '1') {
                        curHeights[c] += 1;
                    } else {
                        curHeights[c] = 0 ;
                    }
                }

                int tempA = largestRectangleArea(curHeights);
                area = Math.max(tempA, area) ;
            }

            return area ;
        }

        public int largestRectangleArea(int[] heights) {
            int l = -1 ;
            int maxArea = 0 ;
            Stack<Integer> stack = new Stack<>() ;

            for(int i=0; i<=cols; i++) {
                int curH = (i == cols) ? (0) : (heights[i]) ;

                while(!stack.isEmpty() && curH <  heights[stack.peek()]) {
                    int h = heights[stack.pop()] ;
                    int len = (i - ((stack.isEmpty()) ? (l+1) : (stack.peek()+1))) ;
                    maxArea = Math.max(maxArea, h*len) ;
                }
                if (i==heights.length || heights[i]!=0) stack.add(i) ;
                if (i<heights.length && heights[i]==0) l = i ;
            }

            return maxArea ;
        }
    }
}
