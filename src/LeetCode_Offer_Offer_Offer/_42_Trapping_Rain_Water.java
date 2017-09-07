package LeetCode_Offer_Offer_Offer;

import java.util.Map;

/**
 * Created by tangjialiang on 2017/9/4.
 */
public class _42_Trapping_Rain_Water {
    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it is able to trap after raining.

     For example,
     Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


     The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
     In this case, 6 units of rain water (blue section) are being trapped.
     Thanks Marcos for contributing this image!
     */

    public static void main(String[] args) {
        int[] height = {0} ;

        _42_Trapping_Rain_Water trapping_rain_water = new _42_Trapping_Rain_Water();
        int work = trapping_rain_water.work(height);

        System.out.println("work is: " + work) ;
    }

    public int work(int[] height) {
        Solution solution = new Solution();
        int trap = solution.trap(height);
        return trap ;
    }

    class Solution {
        private int[] maxTopsFromLeft = null ;
        private int[] maxTopsFromRight = null ;

        public int trap(int[] height) {
            if (height==null || height.length==0) return 0 ;

            maxTopsFromLeft = new int[height.length] ;
            maxTopsFromRight = new int[height.length] ;

            goFromRight(height);
            goFromLeft(height);

            int total = 0 ;
            for(int i=0; i<height.length; i++) {
                int top = Math.min(maxTopsFromLeft[i], maxTopsFromRight[i]) ;
                total += (top - height[i]) ;
            }

            return total ;
        }

        private void goFromRight(int[] height) {
            int lastMaxHeight = height[height.length-1] ;
            for(int i=height.length-1; i>=0; i--) {
                if (lastMaxHeight > height[i]) {
                    maxTopsFromRight[i] = lastMaxHeight ;
                }
                if (lastMaxHeight <= height[i]) {
                    lastMaxHeight = height[i] ;
                    maxTopsFromRight[i] = height[i] ;
                }
            }
        }

        private void goFromLeft(int[] height) {
            int lastMaxHeight = height[0] ;
            for(int i=0; i<height.length; i++) {
                if (lastMaxHeight > height[i]) {
                    maxTopsFromLeft[i] = lastMaxHeight ;
                }
                if (lastMaxHeight <= height[i]) {
                    lastMaxHeight = height[i] ;
                    maxTopsFromLeft[i] = height[i] ;
                }
            }
        }
    }
}
