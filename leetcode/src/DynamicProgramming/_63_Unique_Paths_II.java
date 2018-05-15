package DynamicProgramming;

import java.util.LinkedList;

/**
 * Created by tangjialiang on 2018/4/15.
 */
public class _63_Unique_Paths_II {

    static class Solution1 {
        int[][] matrix ;
        int rows ;
        int cols ;

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            this.matrix = obstacleGrid ;
            this.rows = matrix.length ;
            this.cols = matrix[0].length ;

            // init
            int[][] dp = new int[rows][cols] ; // dp => the number of path.
            if (matrix[0][0] == 1) dp[0][0] = 0 ;
            else dp[0][0] = 1 ;
            for (int i = 1; i < rows; i++) {
                if (matrix[i][0] == 1) dp[i][0] = 0 ;
                else dp[i][0] = dp[i-1][0] ;
            }
            for (int i = 1; i < cols; i++) {
                if (matrix[0][i] == 1) dp[0][i] = 0 ;
                else dp[0][i] = dp[0][i-1] ;
            }

            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < cols; j++) {
                    if (matrix[i][j] == 1) {
                        dp[i][j] = 0 ;
                        continue;
                    }
                    int topN = i-1>=0 ? dp[i-1][j] : 0 ;
                    int leftN = j-1>=0 ? dp[i][j-1] : 0 ;
                    dp[i][j] = topN + leftN ;
                }
            }

            return dp[rows-1][cols-1] ;
        }
    }

    static class Solution {
        class Node {
            int i ;
            int j ;
            public Node(int i, int j) {
                this.i = i ;
                this.j = j ;
            }
        }

        int[][] matrix ;
        int rows ;
        int cols ;

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            this.matrix = obstacleGrid ;
            this.rows = matrix.length ;
            this.cols = matrix[0].length ;
            int ans = 0 ;

            LinkedList<Node> queue = new LinkedList<>() ;
            Node node = new Node(0, 0) ;
            if (matrix[node.i][node.j] == 0) queue.addLast(node) ;

            while(!queue.isEmpty()) {
                Node node1 = queue.removeFirst();
                int i = node1.i ;
                int j = node1.j ;
                if (i==rows-1 && j==cols-1) ans++ ;

                if (i+1 < rows && matrix[i+1][j]!=1) queue.addLast(new Node(i+1, j)) ;
                if (j+1 < cols && matrix[i][j+1]!=1) queue.addLast(new Node(i, j+1)) ;
            }

            return ans ;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        } ;

        Solution sol = new Solution() ;
        int i = sol.uniquePathsWithObstacles(matrix);

        System.out.println(i) ;
    }
}
