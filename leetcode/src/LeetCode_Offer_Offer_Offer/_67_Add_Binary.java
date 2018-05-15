package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/10.
 */
public class _67_Add_Binary {
    /**
     * Given two binary strings, return their sum (also a binary string).

     For example,
     a = "11"
     b = "1"
     Return "100".
     */

    public static void main(String[] args) {
        String a = "11" ;
        String b = "1" ;

        _67_Add_Binary add_binary = new _67_Add_Binary();
        String work = add_binary.work(a, b);

        System.out.println("work is: " + work) ;
    }

    public String work(String a, String b) {
        Solution solution = new Solution();
        String s = solution.addBinary(a, b);
        return s ;
    }

    class Solution {
        private List<Integer> sum = new LinkedList<>() ;

        public String addBinary(String a, String b) {
            StringBuilder aNum = new StringBuilder(a) ;
            StringBuilder bNum = new StringBuilder(b) ;
            aNum.reverse() ;
            bNum.reverse() ;

            for(int i=0; i<Math.max(aNum.length(), bNum.length()); i++) {
                sum.add(((i<aNum.length())?(aNum.charAt(i)-'0'):(0)) + ((i<bNum.length())?(bNum.charAt(i)-'0'):(0))) ;
            }

            doCarr(0, 0);

            StringBuilder ans = new StringBuilder() ;
            for(Integer i: sum) ans.append(i) ;
            ans.reverse() ;
            return  ans.toString();
        }

        private void doCarr(int pos, int carr) {
            if (pos >= sum.size() && carr!=0) {
                sum.add(carr%2) ;
                doCarr(pos+1, carr/2);
                return ;
            }

            if (pos>=sum.size() && carr==0) return ;

            Integer integer = sum.get(pos) + carr;
            sum.set(pos, integer%2) ;
            doCarr(pos+1, integer/2);

            return ;
        }
    }
}
