package zz_to_to_offer.solution;

import java.util.Arrays;

/**
 * Created by tangjialiang on 2018/4/25.
 */
public class Solution28 {

    static public class Solution {
        public int MoreThanHalfNum_Solution(int [] array) {
            Arrays.sort(array) ;
            int l = 0 ;
            int r = array.length - 1 ;
            int mid =(r + l) >> 1 ;

            int len = array.length ;
            for (Integer i : array) {
                if (i != array[mid]) {
                    len-- ;
                }
            }

            return len > array.length/2 ? array[mid] : 0 ;
        }
    }

    public static void main(String[] args) {

    }
}
