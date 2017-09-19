package LeetCode_Offer_Offer_Offer;

import sun.nio.cs.ext.MacHebrew;

import java.util.Stack;

/**
 * Created by tangjialiang on 2017/9/14.
 */
public class _84_Largest_Rectangle_in_Histogram {
    /**
     * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
     * find the area of largest rectangle in the histogram.


     Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


     The largest rectangle is shown in the shaded area, which has area = 10 unit.

     For example,
     Given heights = [2,1,5,6,2,3],
     return 10.
     */

    public static void main(String[] args) {
        // Input Samples:
        // {2, 2, 2} => 6
        // {0, 0, 2, 1, 2} => 3
        // {2,1,5,6,2,3} => 10
        // {4,2,0,3,2,5} => 6
        // {3,6,5,7,4,8,1,0} => 20
        int[] heights = {2,1,5,6,2,3} ;
        _84_Largest_Rectangle_in_Histogram largest_rectangle_in_histogram = new _84_Largest_Rectangle_in_Histogram();
        int work = largest_rectangle_in_histogram.work(heights);

        System.out.println("work is: " + work) ;
    }

    public int work(int[] heights) {
        Solution solution = new Solution();
        int i = solution.largestRectangleArea(heights);

        return i ;
    }

    class Solution {
        private int maxArea = 0 ;
        private Stack<Integer> stack = new Stack<>() ;
        private int[] heights = null ;

        public int largestRectangleArea(int[] heights) {
            int l = -1 ;
            this.heights = heights ;

            for(int i=0; i<=heights.length; i++) {

                    int curHeight = (i==heights.length) ? (0) : (heights[i]) ; // 在所有的数据遍历后，使用一个较小的数。

                    while(stack.size()!=0 && curHeight <  heights[stack.peek()]) {
                        // 比当前元素大的数值都会从stack中弹出。留下来的数值是小于等于当前值，故取stack的顶部元素作为区间的最左值。
                        int height = heights[stack.pop()] ;
                        int len = (i - ((stack.isEmpty()) ? (l+1) : (stack.peek()+1))) ;
                        maxArea = Math.max(maxArea, height*len) ;
                    }
                    if (i==heights.length || heights[i]!=0) stack.add(i) ;
                    if (i<heights.length && heights[i]==0) l = i ;
            }
            return maxArea ;
        }
    }

    class Solution1 {
        // time out
        private int[] heights = null ;
        private int[][] minHeight = null ;
        private int len = -1 ;

        class Dp {
            private int[] height = null ;
            private int len = -1 ;
            private int[][] minHeight = null ;
            private int maxArea = 0 ;

            public Dp(int[] heights) {
                this.len = heights.length ;
                height = heights ;
                minHeight = new int[len][len] ;

                // one
                for(int i=0; i<len; i++) {
                    minHeight[i][i] = heights[i] ;
                    maxArea = Math.max(maxArea, getArea(i, i)) ;
                }
                // two heights
                for(int i=0; i<len-1; i++) {
                    minHeight[i][i+1] = Math.min(heights[i], heights[i+1]) ;
                    maxArea = Math.max(maxArea, getArea(i, i+1)) ;
                }

                initial() ;
            }

            private void initial() {
                for(int a = 3; a<=len; a++) {
                    for(int i=0; i + a - 1<len; i++) {
                        int j = i + a - 1 ;

                        int min1 = Math.min(minHeight[i][j-1], height[j]) ;
                        int min2 = Math.min(minHeight[i+1][j], height[i]) ;
                        int min3 = Math.min(minHeight[i+1][j-1], Math.min(height[i], height[j])) ;

                        minHeight[i][j] = Math.min(Math.min(min1, min2), min3) ;
                        maxArea = Math.max(maxArea, getArea(i, j)) ;
                    }
                }
                return ;
            }

            public int getMinHeight(int i, int j) {
                if (j<i) return -1 ;
                if (i<0 || j<0 || i>len || j>len) return -1 ;

                return minHeight[i][j] ;
            }

            private int getArea(int l, int r) {
                int area = (r - l + 1) * getMinHeight(l, r) ;
                return area ;
            }

            private int getMaxArea() {
                return maxArea ;
            }
        }
        Dp dp = null ;

        public int largestRectangleArea(int[] heights) {
            this.heights = heights ;
            len = heights.length ;
            minHeight = new int[len][len] ;
            dp = new Dp(heights) ;

            return dp.getMaxArea() ;
        }
    }
}
