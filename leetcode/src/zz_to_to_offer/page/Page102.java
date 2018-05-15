package zz_to_to_offer.page;

/**
 * Created by tangjialiang on 2018/2/27.
 */
public class Page102 {
    /*
    * 输入一个整数数组，实现一个函数来把所有奇数放在偶数前。
    * */

    public static void adjustLeftAndRight(int[] data) {
        int lo = 0 ;
        int hi = data.length - 1 ;
        int tmp = data[lo] ;

        while(lo < hi) {
            while(lo < hi && data[hi]%2!=0) hi-- ;
            data[lo] = data[hi] ;
            while(lo < hi && data[lo]%2==0) lo++ ;
            data[hi] = data[lo] ;
        }
        data[lo] = tmp ;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7} ;

        Page102.adjustLeftAndRight(data);

        for(Integer num : data) {
            System.out.print(num + " ") ;
        }
        System.out.println() ;
    }
}
