package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/12/28.
 */
public class _174_Dungeon_Game {

    public static void main(String[] args) {
        int[][] dungeon = {
                {0}
        } ;

        Solution solution = new Solution();
        int i = solution.calculateMinimumHP(dungeon);

        System.out.println("the work is: " + i) ;
    }

    static class Solution {
        /**
         * 由于最终目标是骑士到达公主位置，因此在右下角必须满足HP剩余1.

         从右下角位置开始倒推，每个位置需要同时满足两个条件：（1）该位置HP为1(保证不死)，（2）该位置的HP足够到达公主(使用动态规划)
         */


        int rows = 0 ;
        int cols = 0 ;
        int[][] health ;

        public void init(int[][] dungeon) {
            try {
                rows = dungeon.length ;
                cols = dungeon[0].length ;
                health = new int[rows][cols] ;
            } catch (Exception e) {

            }
            return ;
        }

        public int calculateMinimumHP(int[][] dungeon) {
            init(dungeon) ;

            // var - cost = health
            health[rows - 1][cols - 1] = Math.max(1 - dungeon[rows - 1][cols - 1], 1);

            for (int i=rows-2; i>=0; i--) {
                health[i][cols-1] = Math.max(health[i + 1][cols - 1] - dungeon[i][cols - 1], 1) ;
            }
            for (int i=cols-2; i>=0; i--) {
                health[rows-1][i] = Math.max(health[rows - 1][i + 1] - dungeon[rows - 1][i], 1) ;
            }

            for(int i=rows-2; i>=0; i--) {
                for(int j=cols-2; j>=0; j--) {
                    int down = Math.max(health[i+1][j] - dungeon[i][j], 1) ;
                    int right = Math.max(health[i][j+1] - dungeon[i][j], 1) ;
                    health[i][j] = Math.min(down, right) ;
                }
            }

            return health[0][0] ;
        }
    }
}
