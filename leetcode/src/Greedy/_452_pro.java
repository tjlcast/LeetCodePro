package Greedy;

import java.util.Arrays;

//int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}} ;
//Arrays.sort(points, ( x , y) -> x[0] == y[0] ? x[1] - y[1] : x[0] -y[0]); // good 

public class _452_pro {
	public static void main(String[] args) {
		
		int[][] points = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}} ;
		int res = new _452_pro().findMinArrowShots(points) ;
		System.out.println(res);
	}
	
	public int findMinArrowShots(int[][] points) {
		if (points.length==0) return 0 ;
		
		int lines = 1 ;
		Arrays.sort(points, (x, y)->((x[0]==y[0])?(x[1]-y[1]):(x[0]-y[0]))) ;
				
		int terminate = points[0][1] ;
		for (int i=1; i<points.length; i++) {
			if (terminate < points[i][0]) {
				lines++ ;
				terminate = points[i][1] ;
			} else {
				terminate = Math.min(terminate, points[i][1]) ;
			}
		}
		
		return lines ;
	}
}
