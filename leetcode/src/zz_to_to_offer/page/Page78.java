package zz_to_to_offer.page;

/**
 * Created by tangjialiang on 2018/2/27.
 */
public class Page78 {
    /*
    * 实现一个函数，输入一个数，输出该数的二进制表示中1的个数。
    * */

    public static int numberOf1(int num) {
        int count = 0 ;

        while(num != 0) {
            num = num & (num - 1) ;
            count++ ;
        }
        return count ;
    }

    public static void main(String[] args) {
        int num = 9 ;

        int i = Page78.numberOf1(num);

        System.out.println(i) ;
    }
}
