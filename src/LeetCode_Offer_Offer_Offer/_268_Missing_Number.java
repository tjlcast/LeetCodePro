package LeetCode_Offer_Offer_Offer;

import java.util.TreeSet;
import java.util.stream.Stream;

/**
 * Created by tangjialiang on 2018/2/4.
 */
public class _268_Missing_Number {

    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1} ;

        Solution sol = new Solution() ;
        int res = sol.missingNumber(nums) ;

        System.out.println("The work is: " + res) ;
    }

    static class Solution {
        public int missingNumber(int[] nums) {
            TreeSet<Integer> set = new TreeSet<>() ;
            for(int i=0; i<=nums.length; i++) {
                set.add(i) ;
            }

            for(int num : nums) {
                set.remove(num) ;
            }

            if (set.size()==1) {
                return set.first() ;
            }
            return -1 ;
        }
    }
}
