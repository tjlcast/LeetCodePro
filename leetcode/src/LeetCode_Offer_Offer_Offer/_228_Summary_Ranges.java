package LeetCode_Offer_Offer_Offer;

import java.util.*;

/**
 * Created by tangjialiang on 2018/1/25.
 */
public class _228_Summary_Ranges {

    public static void main(String[] args) {
        int[] nums = {0,1,2, 3} ;

        Solution solution = new Solution();
        List<String> strings = solution.summaryRanges(nums);

        System.out.println("Thw work is: ") ;
        for(String str : strings) System.out.print(str + " ") ;
    }

    static class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> ans = new LinkedList<>() ;

            if (nums==null || nums.length==0) return ans ;

            int downNum = 0 ;
            int upNum = 0 ;
            int lastNum = nums[0]-1 ;
            for(int i=0; i<nums.length; i++) {
                int num = nums[i] ;
                if (lastNum+1==num) {
                    upNum=i ;
                } else {
                    if (downNum!=upNum) ans.add(nums[downNum]+"->"+nums[upNum]) ;
                    else ans.add(nums[downNum]+"") ;
                    downNum = i ;
                    upNum = i ;
                }
                lastNum = num ;
            }

            if (downNum!=upNum) ans.add(nums[downNum]+"->"+nums[upNum]) ;
            else ans.add(nums[downNum]+"") ;

            return ans ;
        }
    }
}
