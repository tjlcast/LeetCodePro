package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;

/**
 * Created by tangjialiang on 2017/11/28.
 */
public class _130_Surrounded_Regions {

    static class Solution {
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}} ;
        int rows = 0 ;
        int cols = 0 ;
        public void solve(char[][] board) {
            try {
                rows = board.length ;
                cols = board[0].length ;
            } catch (Exception e) {

            }

            for(int r=0; r<rows; r++) {
                for(int c=0; c<cols; c++) {
                    // is border
                    if(isBorder(r, c) && board[r][c] == 'O') {
                        System.out.println("asdf") ;
                        LinkedList<Integer> queue = new LinkedList<Integer>() ;
                        queue.addLast(r*cols+c) ;

                        while(!queue.isEmpty()) {
                            int pos = queue.removeFirst() ;
                            int r1 = pos / cols ;
                            int c1 = pos % cols ;

                            board[r1][c1] = 'W' ;

                            for(int i=0; i<4; i++) {
                                int newR = directions[i][0]+r1;
                                int newC = directions[i][1]+c1;
                                if (0<=newR && newR<rows && 0<=newC && newC<cols && board[newR][newC]=='O') {
                                    //board[newR][newC] = 'W' ;
                                    if(!queue.contains(newR*cols+newC))queue.add(newR*cols+newC) ;
                                }
                            }
                        }
                    }
                }
            }

            for(int r=0; r<rows; r++) {
                for(int c=0; c<cols; c++) {
                    if (board[r][c]!='W') board[r][c] = 'X' ;
                    else board[r][c] = 'O' ;
                }

            }

        }

        private boolean isBorder(int r, int c) {
            if (r * c * (r-rows+1) * (c-cols+1) == 0){
                return true ;
            }
            return false ;
        }
    }
}
