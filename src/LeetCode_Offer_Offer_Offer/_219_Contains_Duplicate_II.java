package LeetCode_Offer_Offer_Offer;

import org.omg.CORBA.INTERNAL;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/1/23.
 */
public class _219_Contains_Duplicate_II {
    /**
     * Given an array of integers and an integer k,
     * find out whether there are two distinct indices i and j in the array
     * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
     */

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1} ;
        int k = 1 ;

        Solution sol = new Solution() ;
        boolean ans = sol.containsNearbyDuplicate(nums, k) ;

        System.out.println("The work is: " + ans) ;
    }

    static class Solution {

        public boolean containsNearbyDuplicate(int[] nums, int k) {
            HashMap<Integer, Integer> dp = new HashMap<>() ;
            for(int i=0; i<nums.length; i++) {
                int n = nums[i] ;
                int oldPos = dp.getOrDefault(n, -1) ;

                if (oldPos != -1) if (Math.abs(oldPos - i)<=k) return true ;
                dp.put(n, i) ;
            }
            return false ;
        }
    }
}
