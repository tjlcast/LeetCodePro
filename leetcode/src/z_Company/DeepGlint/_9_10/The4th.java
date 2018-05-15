package z_Company.DeepGlint._9_10;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/16.
 */
public class The4th {
    /**
     * 平面直角坐标系中给定三个点的坐标，找出一个能够包含这三个点的矩形，
     * 并使得该矩形面积最小。这里包含的含义是点落在矩形边上或者内部。
     * 如果三个点在一条直线上，则认为所求矩形的面积为0。
     *
     * Input Format
     * 输入为三行，分别为三角形三个顶点的坐标。
     * 每行包含两个整数，以空格隔开，分别表示一个顶点的x坐标和y坐标。
     *
     * Constraints
     * 0 < x, y < 100000
     *
     * Output Format
     * 输出一个整数，表示求出的矩形面积
     */

    public static void main(String[] args) {
        List<List<Integer>> positions = new LinkedList<>() ;

        The4th the4th = new The4th();
        double work = the4th.work(positions);

        System.out.println("work is " + work) ;
    }

    public double work(List<List<Integer>> positions) {
        Solution solution = new Solution();
        double v = solution.doWork(positions);

        return v ;
    }

    class Solution {
        int x1,y1 ;
        int x2,y2 ;
        int x3,y3 ;

        double line1 ;
        double line2 ;
        double line3 ;

        public double doWork(List<List<Integer>> positions) {
            line1 = twoPointersLen(x1, y1, x2, y2) ;
            line2 = twoPointersLen(x2, y2, x3, y3) ;
            line3 = twoPointersLen(x1, y1, x3, y3) ;

            if (isLine()) {
                return 0 ;
            } else {
                double p = (line1 + line2 + line3) / 2 ;
                double s = Math.sqrt((p)*(p-line1)*(p-line2)*(p-line3)) ;
                double area = s * 2 + 0.1 ;
                return area ;
            }


        }

        private double twoPointersLen(int x1, int y1, int x2, int y2) {
            return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)) ;
        }

        private boolean isLine() {
            int k1 = 999999 ;
            try {
                k1 = (y1- y2) / (x1 - x2) ;
            } catch (Exception e) {

            }

            int k2 = 999999 ;
            try {
                k2 = (y1- y2) / (x1 - x2) ;
            } catch (Exception e) {

            }

            if (k1 == k2) {
                return true ;
            }
            return false ;
        }
    }
}
