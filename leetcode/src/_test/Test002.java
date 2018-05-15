package _test;

import java.util.LinkedList;
import static java.lang.Math.max ;

/**
 * Created by tangjialiang on 2018/4/3.
 */
public class Test002 {

    public static int getMaxArea(int[] heights) {
        int ans = 0 ;
        LinkedList<Integer> list = new LinkedList<>() ;

        for(int i=0; i<heights.length; i++) {
            while (!list.isEmpty() && heights[i]<=heights[list.getLast()]) {
                list.removeLast() ;
                int firstLowIdx = (list.isEmpty()) ? (-1) : (list.getLast()) ;
                ans = max(ans, i - firstLowIdx - 1) ;
            }
            list.addLast(i);
        }

        return ans ;
    }

    public static void main(String[] args) {
        int[] heights = {1, 2, 3, 4, 5, 3, 2} ;

        int maxArea = getMaxArea(heights);
        System.out.println(maxArea) ;
    }
}
