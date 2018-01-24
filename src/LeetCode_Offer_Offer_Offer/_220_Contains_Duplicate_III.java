package LeetCode_Offer_Offer_Offer;


import static java.lang.Math.* ;
import java.util.* ;

/**
 * Created by tangjialiang on 2018/1/24.
 */
public class _220_Contains_Duplicate_III {

    public static void main(String[] args) {
        int k = 1;
        int t = 1;
        int[] nums = {1, 2, 3, 4} ;

        Solution solution = new Solution();
        boolean ans = solution.containsNearbyAlmostDuplicate(nums, k, t) ;

        System.out.println("The work is: " + ans) ;
    }

    static class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k , int t) {
            if (nums==null || nums.length==0 || k<=0) return false ;

            TreeSet<Long> treeSet = new TreeSet<>() ;
            for(int i=0; i<nums.length; i++) {
                final Long floor = treeSet.floor((long)nums[i]+t) ;
                final Long ceil = treeSet.ceiling((long)nums[i]-t) ;

                if ( (floor!=null && floor>=(long)nums[i]) ||
                        (ceil != null && ceil<=(long)nums[i])) {
                    return true ;
                }

                treeSet.add((long)nums[i]) ;
                if (i >= k) {
                    treeSet.remove((long)nums[i-k]) ;
                }
            }
            return false ;
        }
    }

    static class Solution_1_TimeOut {

        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

            for(int i=0; i<nums.length; i++) {
                for(int j=i+1; j<nums.length; j++) {
                    if (Integer.MAX_VALUE-abs(nums[j])<abs(nums[i])) continue ;
                    if (abs(nums[i]-nums[j])<=t && abs(i-j)<=k) {
                        return true ;
                    }
                }
            }
            return false ;
        }
    }
}
