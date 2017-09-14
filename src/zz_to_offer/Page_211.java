package zz_to_offer;

import com.sun.deploy.util.ArrayUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/8/30.
 */
public class Page_211 {
    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
     * 请写程序找出这两个只出现一次的数字。要求时间复杂度为O(n)，
     * 空间复杂度是O(1).
     */

    public static void main(String[] args) {
        int[] datas = {2, 4, 3, 6, 3, 2, 5, 5} ;
        int[] work = new Page_211().work(datas);
        System.out.println("work: ") ;
        for(int i : work) {
            System.out.println(i) ;
        }
    }

    public int[] work(int[] data) {
        MySolution mySolution = new MySolution();
        int[] numsAppearOnce = mySolution.findNumsAppearOnce(data);
        return numsAppearOnce ;
    }

    class MySolution {
        /**
         * tips：通过异或的性质：可以求出。
         *       数组的异或结果是两个time为1的数字的差异值。通过这个值为1的位可以区分这两个树。
         */
        private List<Integer> ans = new LinkedList<>() ;

        public int[] findNumsAppearOnce(int[] data) {
            int[] ans = null ;

            Integer preTotal = null ;
            for(int i=0; i<data.length; i++) {
                preTotal = (preTotal==null) ? (data[i]) : (preTotal ^ data[i]) ;
            }

            int first1Position = findFirst1Position(preTotal);

            Integer a = null ;
            Integer b = null ;
            for(int num: data) {
                if (hasSamePosition1(num, first1Position)) {
                    a = (a==null) ? (num) : (num ^ a) ;
                } else {
                    b = (b==null) ? (num) : (num ^ b) ;
                }
            }

            ans = new int[2] ;
            ans[0] = a ;
            ans[1] = b ;
            return ans ;
        }

        private int findFirst1Position(int data) {
            int pos = 1 ;
            int f = 1 ;
            while(((f<<pos)&data) == 0) {
                pos += 1 ;
            }
            return pos ;
        }

        private boolean hasSamePosition1(int data, int pos) {
            int f = 1 << pos ;
            if ((f&data) != 0) return true ;
            return false ;
        }
    }
}
