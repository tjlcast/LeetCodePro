package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by tangjialiang on 2018/2/3.
 */
public class _264_Ugly_Number_II {
    /**
     * 找出第n个ugly数。所谓ugly数，即质因子只有2，3，5。即这个数仅通过2，3，5的相乘便可以得到。设1是ugly数。
     根据给的线索，如果逐条判断该数是不是ugly，直到找到第n个ugly数。
     虽然方法行的通，但是由于大部分数都是非ugly的，这样做明显非常耗时。
     采用动态规划的思想。每个ugly数都是由2或3或5乘以另外一个ugly数组成。
     设置三个指针，分别表示乘以2，3或5之前的ugly数。每次选择当前指针所指向位置的最小值，并将适当的某个指针前移一位。
     指针设为index_2=0, index_3=0, index_5=0。值设为val_2=2, val_3=3, val_5=5。设存储ugly的数组为arr。

     1*2 2*2 3*2 4*2 5*2 6*2 8*2 9*2 10*2 12*2 15*2...
     1*3 2*3 3*3 4*3 5*3 6*3 8*3 9*3 10*3 12*3 15*3...
     1*5 2*5 3*5 4*5 5*5 6*5 8*5 9*5 10*5 12*5 15*5...
     * @param args
     */

    public static void main(String[] args) {
        int n = 10 ;

        Solution sol = new Solution() ;
        int res = sol.nthUglyNumber(n) ;

        System.out.println("The result is: " + res) ;
    }

    static class Solution {

        public int nthUglyNumber(int n) {
            SortedSet<Long> s1 = new TreeSet<>();
            s1.add((long)1);
            long result = s1.first();
            for(int i=0;i<n;i++){
                result = s1.first();
                s1.add(result * 2);
                s1.add(result * 3);
                s1.add(result * 5);
                s1.remove(result);
            }
            return (int)result;
        }
    }
}
