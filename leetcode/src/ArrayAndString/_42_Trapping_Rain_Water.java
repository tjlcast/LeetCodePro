package ArrayAndString;

/**
 * Created by tangjialiang on 2017/5/27.
 *
 */
public class _42_Trapping_Rain_Water {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1} ;
        int work = new _42_Trapping_Rain_Water().work(height);
        System.out.println(work) ;

    }

    public int work(int[] height) {
        return new Solution().trap(height) ;
    }

    public class Solution {
        public int trap(int[] height) {

            // border condition
            if (height==null || height.length==0) {
                return 0 ;
            }

            int curMax = -1 ;
            int total = 0 ;
            int maxPos = -1 ;

            // find max
            int tempMax = Integer.MIN_VALUE ;
            for(int i=0; i<height.length; i++) {
                if (tempMax < height[i]) {
                    tempMax = height[i] ;
                    maxPos = i ;
                }
            }

            // from left
            curMax = height[0] ;
            for(int i=0; i<height.length; i++) {
                if (i == maxPos) break ;
                if (curMax > height[i]) {
                    total += curMax - height[i] ;
                } else {
                    curMax = height[i] ;
                }

            }

            // from right
            curMax = height[height.length-1] ;
            for(int i=height.length-1; i>=0; i--) {
                if (i == maxPos) break ;
                if (curMax > height[i]) {
                    total += curMax - height[i] ;
                } else {
                    curMax = height[i] ;
                }
            }

            return total ;
        }
    }
}
