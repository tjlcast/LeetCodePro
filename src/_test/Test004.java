package _test;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import static java.lang.Math.max ;

/**
 * Created by tangjialiang on 2018/4/3.
 */
public class Test004 {

    public static void main(String[] args) {
        int[] heights = {1, 5, 6, 7, 2, 3, 4} ;
        int cases = 10 ;

        for (int i = 0; i < cases; i++) {
            Random random = new Random();
            for (int j = 0; j < heights.length; j++) {
                heights[j] = Math.abs(random.nextInt())%10 ;
                System.out.print(heights[j] + " ");
            }
            System.out.println();
            int ans = work(heights) ;
            System.out.println(ans) ;

        }
    }

    private static int work(int[] heights) {
        int ans = 0 ;

        TreeMap<Integer, Integer> recorders = new TreeMap<>() ; // <height, first Idx>
        int max = Integer.MIN_VALUE ;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > max) {
                recorders.put(heights[i], i) ;
                max = heights[i] ;
            }
        }

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i] ;
            Map.Entry<Integer, Integer> integerIntegerEntry = recorders.ceilingEntry(height);

            ans = max(ans, (integerIntegerEntry==null)?(0):(i - integerIntegerEntry.getValue()+1)) ;
        }

        return ans ;
    }
}
