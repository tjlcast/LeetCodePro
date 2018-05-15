package LeetCode_Offer_Offer_Offer;

import java.util.* ;
import java.util.stream.IntStream;

/**
 * Created by tangjialiang on 2018/1/22.
 */
public class _215_Kth_Largest_Element_in_an_Array {

    /**
     * Find the kth largest element in an unsorted array.
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     For example,
     Given [3,2,1,5,6,4] and k = 2, return 5.

     Note:
     You may assume k is always valid, 1 ≤ k ≤ array's length.
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6} ;
        int k = 4 ;

        Solution sol = new Solution() ;
        int ans = sol.findKthLargest(nums, k) ;

        System.out.println("The work is: " + ans) ;
    }

    static class Solution {
        public int findKthLargest(int[] nums, int k) {

            PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>() ;

            for(Integer i : nums) {
                pQueue.add(i) ;
                if(pQueue.size() > k) {
                    pQueue.remove() ;
                }
            }

            int ans = pQueue.peek() ;

            return ans ;
        }
    }
}
