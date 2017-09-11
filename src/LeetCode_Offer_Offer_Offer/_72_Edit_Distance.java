package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/11.
 */
public class _72_Edit_Distance {
    /**
     * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
     * (each operation is counted as 1 step.)

     You have the following 3 operations permitted on a word:

     a) Insert a character
     b) Delete a character
     c) Replace a character
     */

    public static void main(String[] args) {
        String word1 = "a" ;
        String word2 = "d" ;
        _72_Edit_Distance edit_distance = new _72_Edit_Distance();
        int work = edit_distance.work(word1, word2);

        System.out.println("work is: " + work) ;
    }

    public int work(String word1, String word2) {
        Solution solution = new Solution();
        int i = solution.minDistance(word1, word2);

        return i ;
    }

    class Solution {
        /**
         * 如果要计算单词"INTENTION"和单词"EXECUTION"之间的编辑距离，那么该怎么计算呢？
         首先，把这个问题简单化。把上面两个单词简化为长度为1的两个单词I和E。
         如果要“I”变化为"E"，可以把"I"替换为"E"
         如果要“I”变化为空串" "，可以把"I"删除，从而形成""
         如果要空串“ ”变化为"E"，可以把"E"插入，从而形成E
         上面三种变化分别表示替换，删除，插入这三种基本操作。
         接下来，定义一个表达式D(i,j)。它表示从第1个字单词的第0位至第i位形成的子串和第2个单词的第0位至第j位形成的子串的编辑距离。
         显然，可以计算出动态规划的初始表达式，如下:
         D(i,0) = i
         D(0,j) = j
         然后，考虑动态规划的状态转移方程式，如下:
         D(i-1, j) + 1
         D(i,j)=min                  ( D(i, j-1) + 1 )
         D(i-1, j-1) +2( if  X(i) != Y(j) ) ; D(i-1,j-1) ( if  X(i) == Y(j) )
         */
        private int[][] dp = null ;
        private int rows = -1 ;
        private int cols = -1 ;

        public int minDistance(String word1, String word2) {
            int len1 = word1.length() ;
            int len2 = word2.length() ;

            dp = new int[len1+1][len2+1] ;
            rows = len1+1 ;
            cols = len2+1 ;

            // pre work
            for(int i=0; i<rows; i++) dp[i][0] = i ;
            for(int j=0; j<cols; j++) dp[0][j] = j ;

            go(word1, word2) ;

            return dp[len1][len2] ;
        }

        public void go(String word1, String word2) {
            for(int row=1; row<rows; row++) {
                for(int col=1; col<cols; col++) {
                    int num1 = dp[row-1][col] + 1 ; // add or delete a character
                    int num2 = Math.min(num1, dp[row][col-1] + 1) ; // add or delete a character
                    int num3 = (word1.charAt(row-1) == word2.charAt(col-1)) ? (dp[row-1][col-1]) : (dp[row-1][col-1]+1) ; // change a character

                    dp[row][col] = Math.min(num2, num3) ;
                }
            }
        }
    }
}
