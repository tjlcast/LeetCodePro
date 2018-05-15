package LeetCode_Offer_Offer_Offer;

import Type.Point;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2017/12/13.
 */
public class _149_Max_Points_on_a_Line {
    /**
     * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
     */

    public static void main(String[] args) {
        /**
         * tips:
         * 1、 重复点问题
         * 2、 如何表示斜率 (最大公约数) 重点： 为gcd的写法。
         */

        int[][] data = {{0,0},{94911151,94911150},{94911152,94911151}} ;

        Point[] points = new Point[data.length] ;
        for(int i=0; i<points.length; i++) {
            points[i] = new Point(data[i][0], data[i][1]) ;
        }

        Solution solution = new Solution();
        int i = solution.maxPoints(points);

        System.out.println("work is: " + i) ;
    }

    static class Solution {
        public int maxPoints(Point[] points) {
            int ans = 0 ;

            for(int i=0; i<points.length; i++) {
                Point startNode = points[i] ;

                HashMap<String, Integer> kNum = new HashMap<>() ;
                int samePointNum = 1 ;
                int max = 0 ;
                for(int j=i+1; j<points.length; j++) {
                    Point fromNode = points[j] ;
                    if (startNode.x==fromNode.x && startNode.y==fromNode.y) {
                        samePointNum++ ;
                        continue;
                    }

                    String k = getSlopeInString(startNode, fromNode) ;

                    Integer orDefault = kNum.getOrDefault(k, 0);
                    kNum.put(k, orDefault+1) ;
                    if (max < orDefault+1) max = orDefault+1 ;
                }
                if (ans < max + samePointNum) ans = max + samePointNum ;
            }

            return ans ;
        }

        public String getSlopeInString(Point cur, Point iter) {
            int numerator = iter.y - cur.y;
            int denominator = iter.x - cur.x;
            String sign = getSign(numerator, denominator);
            int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            return sign + Math.abs(numerator)/gcd + "/" + Math.abs(denominator)/gcd;
        }

        public int gcd(int a, int b) {
            if (b == 0)
                return a;
            else
                return gcd(b, a % b);
        }

        public String getSign(int a, int b) {
            if (a <= 0 && b <= 0 || a >= 0 && b >= 0)
                return "+";
            else
                return "-";
        }
    }
}
