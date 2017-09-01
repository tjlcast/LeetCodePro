package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/1.
 */
public class _11_Container_With_Most_Water {
    /**
     * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
     * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     *
     Note: You may not slant the container and n is at least 2.
     */

    public static void main(String[] args) {
        int[] height = {1, 2} ;
        _11_Container_With_Most_Water container_with_most_water = new _11_Container_With_Most_Water();
        int work = container_with_most_water.work(height);
        System.out.println("work is: " + work) ;
    }

    public int work(int[] height) {
        Solution solution = new Solution();
        int i = solution.maxArea(height);
        return i ;
    }

    class Solution {
        private int[] height = null ;

        public int maxArea(int[] height) {
            this.height = height ;
            int l = 0 ;
            int r = height.length - 1 ;
            int area = getArea(l, r) ;

            while(l<r) {
                area = Math.max(area, getArea(l, r)) ;

                if (height[l] < height[r]) {
                    l++ ;
                } else {
                    r-- ;
                }
            }

            return area ;
        }

        private int getArea(int l, int r) {
            return Math.min(height[l], height[r]) * (r - l) ;
        }
    }
}
