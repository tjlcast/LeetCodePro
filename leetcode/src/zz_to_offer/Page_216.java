package zz_to_offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/8/30.
 */
public class Page_216 {
    /**
     * 输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
     * 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15。
     * 故输出3个连续的序列。
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8} ;
        int k = 15 ;

        Page_216 page_216 = new Page_216();
        List<List> work = page_216.work(nums, k);
        for(List<Integer> range : work) {
            for(Integer i: range) {
                System.out.println(i + " ") ;
            }
            System.out.println() ;
        }
    }

    public List<List> work(int[] nums, int sum) {
        MySolution mySolution = new MySolution();
        List<List> continuousSequence = mySolution.findContinuousSequence(nums, sum);
        return continuousSequence ;
    }

    class MySolution {
        /**
         * tips: 在数组上设置一个窗口，通过移动这个窗口和改变这个窗口的大小来选择数据段。
         */
        private List<List> ans = new LinkedList<>() ;

        private List<List> findContinuousSequence(int[] nums, int k) {
            int s = 0 ;
            int e = 1 ;
            int sum = nums[s] + nums[e] ;

            while(s<e && e<nums.length) {
                if (k == sum) {
                    int[] ints = Arrays.copyOfRange(nums, s, e + 1);
                    LinkedList<Integer> aRange = new LinkedList<>() ;
                    for(Integer i: ints) aRange.add(i) ;
                    ans.add(aRange) ;
                    sum -= nums[s] ;
                    s = s + 1 ;
                } else if (k > sum) {
                    e = e + 1 ;
                    sum = sum + nums[e] ;
                } else {
                    sum = sum - nums[s] ;
                    s = s + 1 ;
                }
            }
            return ans ;
        }
    }
}
