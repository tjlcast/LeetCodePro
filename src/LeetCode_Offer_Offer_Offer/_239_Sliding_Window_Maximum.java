package LeetCode_Offer_Offer_Offer;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/1/29.
 */
public class _239_Sliding_Window_Maximum {
    /**
     * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

     For example,
     Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

     Window position                Max
     ---------------               -----
     [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7
     Therefore, return the max sliding window as [3,3,5,5,6,7].
     */

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7} ;
        int k = 0 ;

        Solution sol = new Solution() ;
        int[] ans = sol.maxSlidingWindow(nums, k) ;

        System.out.println("The work is: ") ;
        Arrays.stream(ans).forEach(System.out::println);
    }

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length==0) return new int[0] ;
            int[] ans = new int[nums.length-k+1] ;
            int andIdx = 0 ;
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            }) ;

            for(int i=0; i<k; i++) {
                pq.add(nums[i]) ;
            }

            int wIdx = 0 ;
            int wLen = k ;

            if (k == 0) {
                ans[andIdx++] = nums[0] ;
                for(Integer n : nums) ans[andIdx++]=n ;
            }

            for(wIdx=0; wIdx+wLen-1<nums.length; wIdx++) {
                ans[andIdx++] = pq.peek() ;

                int leftNum = nums[wIdx] ;
                pq.remove(leftNum) ;
                if (wIdx+wLen<nums.length) pq.add(nums[wIdx+wLen]) ;
            }

            return ans ;
        }
    }
}
