package LeetCode_Offer_Offer_Offer;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/1/22.
 */
public class _218_The_Skyline_Problem {

    public static void main(String[] args) {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}} ;

        Solution sol = new Solution() ;
        List<int[]> ans = sol.getSkyline(buildings) ;

        System.out.println("The work is: ") ;
        for(int[] line : ans) {
            System.out.format("%d %d\n", line[0], line[1]) ;
        }
    }

    static class Solution {

//         -----
//        |     |
//        |     |
//        起点   终点

        List<int[]> ans = new LinkedList<>() ;
        public List<int[]> getSkyline(int[][] buildings) {
            LinkedList<int[]> heights = new LinkedList<>() ;

            for(int[] buildingInfo : buildings) {
                int l = buildingInfo[0] ;
                int r = buildingInfo[1] ;
                int h = buildingInfo[2] ;

                heights.addLast(new int[]{l, -h}) ;
                heights.addLast(new int[]{r, h}) ;
            }

            Collections.sort(heights, (a, b)->{
                // 先比较x坐标，再比较y坐标 达成 x小在前面，x相同y小在前面
                if (a[0] != b[0])
                    return a[0] - b[0] ;
                return a[1] - b[1] ;
            });
            PriorityQueue<Integer> sortedHeights = new PriorityQueue<>((a, b)->(b-a)) ;
            sortedHeights.offer(0) ;

            for(int[] pair : heights) {
                int curX = pair[0] ;
                int curY = (pair[1]<0) ? (-pair[1]) : (pair[1]) ;
                boolean isStart = (pair[1]<0) ? (true) : (false) ;
                // 如果是起点 -> 把对应的高度加入 sortedHeights
                // 若果是终点 -> 把对应的高度删除
                if (isStart) {
                    if (sortedHeights.peek() < curY) ans.add(new int[]{curX, curY}) ;
                    sortedHeights.offer(curY) ;
                } else {
                    sortedHeights.remove(curY) ;
                    if (sortedHeights.peek() < curY) {
                        ans.add(new int[]{curX, sortedHeights.peek()}) ;
                    }
                }
            }

            return ans ;
        }
    }
}
