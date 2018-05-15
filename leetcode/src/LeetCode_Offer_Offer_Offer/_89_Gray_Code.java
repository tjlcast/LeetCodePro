package LeetCode_Offer_Offer_Offer;

import Utils.LinkedListUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/20.
 */
public class _89_Gray_Code {
    /**
     * The gray code is a binary numeral system where two successive values differ in only one bit.

     Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

     For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

     00 - 0
     01 - 1
     11 - 3
     10 - 2
     Note:
     For a given n, a gray code sequence is not uniquely defined.

     For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

     For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
     */

    public static void main(String[] args) {
        int n = 3 ;

        _89_Gray_Code gray_code = new _89_Gray_Code();
        List<Integer> work = gray_code.work(n);

        System.out.println("work is: ") ;
        for(Integer i : work) {
            System.out.print(i + " ") ;
        }
    }

    public List<Integer> work(int n) {
        Solution solution = new Solution();
        List<Integer> integers = solution.grayCode(n);

        return integers ;
    }

    class Solution {
        /**
         * 例如： 格雷码0111，为4位数，所以其所转为之二进制码也必为4位数，因此可取转成之二进制码第五位为0，即0 b3 b2 b1 b0。

         0+0=0，所以b3=0
         0+1=1，所以b2=1
         1+1取0，所以b1=0
         0+1取1，所以b0=1
         */
        public List<Integer> grayCode(int n) {
            LinkedList<Integer> res = new LinkedList<>() ;

            for(int i=0; i<(1<<n); i++) {
                res.add(i ^ i >> 1) ;
            }
            return res ;
        }
    }
}
