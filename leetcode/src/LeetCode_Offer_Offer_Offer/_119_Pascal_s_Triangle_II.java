package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/11/18.
 */
public class _119_Pascal_s_Triangle_II {

    class Solution {
        private LinkedList<Integer> nums = new LinkedList<Integer>() ;

        public List<Integer> getRow(int rowIndex) {
            // inital
            nums.add(1) ;
            if (rowIndex==0) return nums ;

            // next
            for(int i=1; i<=rowIndex; i++) {
                generate(i) ;
            }

            return nums ;
        }

        private void generate(int rowIndex) {
            int lastNum = 0 ;
            LinkedList<Integer> tNums = new LinkedList<Integer>() ;

            for(Integer i : nums) {
                tNums.add(lastNum + i) ;
                lastNum = i ;
            }
            tNums.add(1) ;

            nums = tNums ;
        }
    }
}
