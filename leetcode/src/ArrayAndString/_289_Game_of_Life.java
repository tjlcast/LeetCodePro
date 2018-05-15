package ArrayAndString;

public class _289_Game_of_Life {

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}} ;
		new _289_Game_of_Life().work(board);
	}
	
	public void work(int[][] board) {
		new Solution().gameOfLife(board);
	}
	
	public class Solution {
	    int[][] directions = {{1, 1}, {1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1,-1}, {1, -1}, {-1, 1}} ;
	    
	    public void gameOfLife(int[][] board) {
	        
	        // initial 
	        int rows = board.length; 
	        int cols = board[0].length ;
	        for(int i=0; i<rows; i++) {
	            for(int j=0; j<cols; j++) {
	                if (board[i][j] == 0) board[i][j] = 2 ;
	            }
	        }
	        
	        // go through board, to determine the next state.
	        for(int i=0; i<rows; i++) {
	            for(int j=0; j<cols; j++) {
	                int numAlive = 0 ;
	                for(int k=0; k<directions.length; k++) {
	                    int newRow = i + directions[k][0] ;
	                    int newCol = j + directions[k][1] ;
	                    
	                    if ((0<=newRow&&newRow<rows) && (0<=newCol&&newCol<cols)) {
	                        if (board[newRow][newCol]*board[newRow][newCol]==1) {
	                            numAlive++ ;
	                        } 
	                    }
	                }
	                if (numAlive<2) {
	                    board[i][j] = board[i][j]*(-1) ;
	                }else if (board[i][j]!=1 && numAlive == 3) {
	                    board[i][j] = board[i][j]*(1) ;
	                } else if (numAlive==2 || numAlive==3) {
	                    board[i][j] = (board[i][j]==1)?(board[i][j]):(board[i][j]*(-1)) ;
	                } else if (numAlive > 3) {
	                    board[i][j] = board[i][j]*(-1) ;
	                } 
	            }
	        }
	        
	        // change to 1(live) and 0(die)
	        for(int i=0; i<rows; i++) {
	            for(int j=0; j<cols; j++) {
	                if (board[i][j] > 0) board[i][j] = 1 ;
	                else board[i][j] = 0 ;
	            }
	        }
	        
	        System.out.println("");
	    }
	}
}


