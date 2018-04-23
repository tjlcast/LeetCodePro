package z_Company.PingCAP;

import java.util.PriorityQueue;
import java.util.Random;

import static java.lang.Math.abs ;

/**
 * Created by tangjialiang on 2018/4/22.
 *
 *
 * Desc
 * 内存中有100个数组，每一个数组有10万个uint32整数，
 * 组内有序，组和组之前会有重叠，要求最快的算法，
 * 归并成一个 1000万长度的有序数组，用 JAVA 实现。
 */

public class HomwWork {

    interface Base_Solution {
        public int[] solution(int[][] arr) ;
    }

    static class Solution1 implements Base_Solution {

        class Node implements Comparable<Node> {
            int[][] arrs ;
            int row ;
            int col ;

            public Node(int[][] arrs, int row) {
                this.arrs = arrs ;
                this.row = row ;
                this.col = 0 ;
            }

            public int getVal() {
                if (col >= arrs[row].length) return Integer.MAX_VALUE ;
                return arrs[row][col] ;
            }

            public void next() {
                this.col++ ;
            }

            @Override
            public int compareTo(Node o) {
                return this.getVal() - o.getVal() ;
            }
        }

        @Override
        public int[] solution(int[][] arr) {
            int rows = arr.length ;
            int cols = arr[0].length ;
            int[] ans = new int[rows * cols] ;
            int pos = 0 ;
            PriorityQueue<Node> sortedNode = new PriorityQueue<>() ;

            for (int i = 0; i < arr.length; i++) {
                Node node = new Node(arr, i) ;
                sortedNode.add(node) ;
            }

            while (sortedNode.peek().getVal() < Integer.MAX_VALUE) {
                Node poll = sortedNode.poll();
                ans[pos++] = poll.getVal() ;
                poll.next();
                sortedNode.add(poll) ;
            }

            return ans ;
        }
    }

    /**
     * 输入生成
     */
    interface Generator {
        int[][] generator(int rows, int cols) ;
    }

    public static class RandomInputGenerator implements Generator {
        @Override
        public int[][] generator(int rows, int cols) {
            int[][] matrix = new int[rows][cols] ;
            Random random = new Random();
            for (int i = 0; i < rows; i++) {
                int lastR = abs(random.nextInt()) % 10 ;
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = lastR + abs(random.nextInt()) % 10 ;
                    lastR = matrix[i][j] ;
                }
            }
            return matrix ;
        }
    }

    public static void main(String[] args) {

        Generator gen = new RandomInputGenerator() ;
        int[][] arr = gen.generator(10, 18);

        Base_Solution sol = new Solution1() ;
        int[] solution = sol.solution(arr);

        for (Integer i :
                solution) {
            System.out.println(i) ;
        }
    }
}

