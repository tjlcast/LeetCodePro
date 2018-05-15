package LeetCode_Offer_Offer_Offer;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2017/12/27.
 */
public class _167_Two_Sum_II__Input_array_is_sorted {
    /**
     * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

     The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

     You may assume that each input would have exactly one solution and you may not use the same element twice.

     Input: numbers={2, 7, 11, 15}, target=9
     Output: index1=1, index2=2
     */

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15} ;
        int target = 9 ;

        Solution solution = new Solution();
        int[] ints = solution.twoSum(numbers, target);

        System.out.println("the work is: " + ints[0] + " | " +ints[1]) ;
    }

    static class Solution {
        private HashMap<Integer, Integer> recorder = new HashMap<>() ;

        public int[] twoSum(int[] numbers, int target) {
            for(int i=0; i<numbers.length; i++) {
                int num = numbers[i] ;
                int rest = target - num ;

                if(recorder.containsKey(rest)) {
                    int[] ans = {recorder.get(rest), i+1} ;
                    return ans ;
                } else {
                    recorder.put(num, i+1) ;
                }
            }

            return null ;
        }
    }
}
