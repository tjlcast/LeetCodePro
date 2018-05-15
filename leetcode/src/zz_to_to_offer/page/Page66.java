package zz_to_to_offer.page;

import java.util.Arrays;

/**
 * Created by tangjialiang on 2018/2/27.
 */
public class Page66 {

    /*
    * 把一个数组最开始的若干个元素搬到数组的末尾，称之为数组的旋转。
    * 输入一个递增数组的旋转，输出旋转数组的最小值
    * */

    public static boolean find(int[] data, int start, int end, int target) {
        if (start > end) return false ;

        int mid = (start + end) / 2 ;

        if (data[mid] >= data[0]) {
            if (data[start]<=target && target<=data[mid]) {
                return Arrays.binarySearch(data, start, mid+1, target)==-1 ? false : true ;
            } else {
                return find(data, mid+1, end, target) ;
            }
        } else {
            if (data[mid]<=target && target<=data[end]) {
                return Arrays.binarySearch(data, mid, end+1, target)==-1 ? false : true ;
            } else {
                return find(data, start, mid-1, target) ;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {3, 4, 5, 1, 2} ;
        int target = -2 ;

        boolean b = Page66.find(data, 0, data.length - 1, target);

        System.out.println("ans is: " + b) ;
    }
}
