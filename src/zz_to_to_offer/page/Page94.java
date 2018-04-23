package zz_to_to_offer.page;

/**
 * Created by tangjialiang on 2018/2/27.
 */
public class Page94 {
    /*
    * 输入数字n，按顺序打印从1到最大的n位十进制数，例如输入3，打印1， 2， 3， 。。。。， 999
    * */

    public static void printToMaxOfDigits_1(int n) {
        int[] num = new int[n] ;
        int len = num.length ;

        while(add1ToNum(num)) {
            String numStr = getNumStr(num);
            System.out.println(numStr) ;
        }
    }

    private static String getNumStr(int[] num) {
        boolean isBegin = true ;
        StringBuilder sb = new StringBuilder() ;
        for(int i=0; i<num.length; i++) {
            if (num[i]==0 && isBegin) continue;
            if (isBegin) isBegin = false ;
            sb.append(num[i]) ;
        }
        return sb.toString() ;
    }

    public static boolean add1ToNum(int[] num) {
        int carr = 1 ;
        for(int idx=num.length-1; idx>=0; idx--) {
            int newV = (num[idx] + carr) % 10 ;
            int newC = (num[idx] + carr) / 10 ;
            num[idx] = newV ;
            carr = newC ;
        }
        if (carr != 0) return false ;
        return true ;
    }

    public static void main(String[] args) {
        int n = 3 ;

        Page94.printToMaxOfDigits_1(n) ;
    }
}
