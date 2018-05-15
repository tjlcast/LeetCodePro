package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;
import java.util.Collections;

import static java.lang.Math.abs ;

/**
 * Created by tangjialiang on 2018/1/24.
 */
public class _223_Rectangle_Area {

    public static void main(String[] args) {
        int A=-3, B=0, C=3, D=4;
        int E=0, F=-1, G=9, H=2 ;

        Solution sol = new Solution() ;
        int area = sol.computeArea(A, B, C, D, E, F, G, H) ;

        System.out.println("The work is: " + area) ;
    }

    static class Solution {
        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int[] xArr = new int[]{A, C, E, G} ;
            int[] yArr = new int[]{B, D, F, H} ;
            Arrays.sort(xArr);
            Arrays.sort(yArr);

            int areaA = area(A, B, C, D) ;
            int areaB = area(E, F, G, H) ;
            int areaC = area(xArr[1], yArr[1], xArr[2], yArr[2]) ;

            // 非矩形图形
            if (areaA == 0) return areaB ;
            if (areaB == 0) return areaA ;

            // 不相交
            if ((A>=E&&A>=G) || (B>=H&&B>=F) || (C<=E&&C<=G) || (D<=H&&D<=F)) return areaA + areaB ;

            return areaA + areaB - areaC ;
        }

        public int area(int a, int b, int c, int d) {
            int l, h ;
            l = abs(a - c) ;
            h = abs(d - b) ;

            return l * h ;
        }
    }
}
