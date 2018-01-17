package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2018/1/17.
 */
public class _200_Number_of_Islands {
    /**
     * Given a 2d grid map of '1's (land) and '0's (water),
     * count the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.

     Example 1:

     11110
     11010
     11000
     00000
     Answer: 1

     Example 2:

     11000
     11000
     00100
     00011
     Answer: 3
     */

    public static void main(String[] args) {
        char[][] graph1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        } ;
        
        char[][] graph2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'},
        } ;

        Solution solution = new Solution();
        int i = solution.numIslands(graph2);

        System.out.println("the work is: " + i) ;
    }

    static class Solution {
        public int numIslands(char[][] grid) {
            int rows ;
            int cols ;

            try {
                rows = grid.length ;
                cols = grid[0].length ;
            } catch (Exception e) {
                return 0 ;
            }

            int[][] colors = new int[rows][cols] ;
            int color = 1 ;

            for(int r=0; r<rows; r++) {
                for(int c=0; c<cols; c++) {
                    boolean touch = isTouch(grid, colors, r, c, color);
                    if(touch) color++ ;
                }
            }

            return color-1 ;
        }

        private boolean isTouch(char[][] grid, int[][] colors, int r, int c, int color) {
            try {
                if (grid[r][c] == '0') return false;
                if (colors[r][c] != 0) return false;

                colors[r][c] = color ;

                isTouch(grid, colors, r+1, c, color);
                isTouch(grid, colors, r, c+1, color);
                isTouch(grid, colors, r-1, c, color);
                isTouch(grid, colors, r, c-1, color);

                return true ;
            } catch (Exception e) {

            }

            return false;
        }
    }
}
