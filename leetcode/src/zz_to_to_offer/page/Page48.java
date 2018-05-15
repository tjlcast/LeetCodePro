package zz_to_to_offer.page;

/**
 * Created by tangjialiang on 2018/2/26.
 */
public class Page48 {
    /*
    * 有两个排序的数组A1和A2，内存在A1的末尾有足够的的空余空间容纳A2。
    * */

    public int[] solution(int[] a1, int num1, int[] a2, int num2) {
        if (a1.length < a2.length) {
            int[] tmp = a1 ;
            a1 = a2 ;
            a2 = tmp ;

            int len1 = num1 ;
            int len2 = num2 ;
            num1 = Math.max(num1, num2) ;
            num2 = Math.min(num1, num2) ;
        }
        // the length of a1 > a2

        int tmpPos = num1-1 ;
        while(tmpPos >= 0) {
            a1[a1.length-1 - (num1-1-tmpPos)] = a1[tmpPos--] ;
        }

        int pos = 0 ;
        int pos1 = a1.length-1 - (num1-1) ;
        int pos2 = 0 ;

        while(pos < num1+num2) {
            int val1 = (pos1 < a1.length) ? (a1[pos1]) : (Integer.MAX_VALUE) ;
            int val2 = (pos2 < a2.length) ? (a2[pos2]) : (Integer.MAX_VALUE) ;

            if (val1 < val2) {
                a1[pos++] = val1 ;
                pos1++ ;
            } else {
                a1[pos++] = val2;
                pos2++;
            }
        }

        while(pos < a1.length) a1[pos++] = 0 ;

        return a1 ;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 0, 0, 0, 0} ;
        int num1 = 4 ;
        int[] a2 = {2, 3, 6, 0, 0} ;
        int num2 = 3 ;

        Page48 page = new Page48() ;
        int[] solution = page.solution(a1, num1, a2, num2);

        for(Integer num : solution) {
            System.out.print(num + " ") ;
        }
    }
}
