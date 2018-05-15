package z_Company.wangyi;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/3/28.
 */

/**
 * 2
 * 0 90
 * 0 90
 * 100 200
 * 100 200
 */

public class Main1 {

    /**
     * by tjlcast
     *
     * choose two x in all x's.
     * and choose all matrix who over the two lines(positioned by two x's)
     * at last use y' s in whom matirx choosed.
     * (to change the pro ==> section over pro on 1'D).
     *
     * use two sets (repeat) to record in-pointer and out-pointer.
     * then for all pointers (left to right) counter +1 if in i-p or -1 in o-p
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        int n = sc.nextInt() ;
        int[] x1 = new int[n] ;
        int[] y1 = new int[n] ;
        int[] x2 = new int[n] ;
        int[] y2 = new int[n] ;
        HashSet<Integer> allX = new HashSet<>() ;
        int ans = 0 ;

        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt() ;
            allX.add(x1[i]) ;
        }
        for (int i = 0; i < n; i++) {
            y1[i] = sc.nextInt() ;
        }
        for (int i = 0; i < n; i++) {
            x2[i] = sc.nextInt() ;
            allX.add(x2[i]) ;
        }
        for (int i = 0; i < n; i++) {
            y2[i] = sc.nextInt() ;
        }

        for(Integer x_a : allX) {
            for(Integer x_b : allX) {
                if (x_a == x_b) continue;
                HashMap<Integer, Integer> inPoints = new HashMap<>() ;
                HashMap<Integer, Integer> outPoints = new HashMap<>() ;
                TreeSet<Integer> points = new TreeSet<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2-o1;
                    }
                });
                for (int i = 0; i < n; i++) {
                    if (Math.min(x_a,x_b)<=x1[i] && x2[i]<=Math.max(x_a, x_b)) {
                        inPoints.put(Math.max(y1[i], y2[i]), inPoints.getOrDefault(Math.max(y1[i], y2[i]), 0)+1) ;
                        outPoints.put(Math.min(y1[i], y2[i]), outPoints.getOrDefault(Math.min(y1[i], y2[i]), 0)+1) ;
                        points.add(y1[i]) ;
                        points.add(y2[i]) ;
                    }
                }

                int curH = 0 ;
                for(Integer point : points) {
                    curH += inPoints.getOrDefault(point, 0) ;
                    curH -= outPoints.getOrDefault(point, 0) ;
                    ans = Math.max(ans, curH) ;
                }
            }
        }

        System.out.println(ans) ;
    }
}
