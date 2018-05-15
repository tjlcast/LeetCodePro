package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/5.
 */
public class _47_Permutations_II {
    /**
     * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

     For example,
     [1,1,2] have the following unique permutations:
     [
     [1,1,2],
     [1,2,1],
     [2,1,1]
     ]
     */

    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            return permute(nums) ;
        }

        private List<List<Integer>> ansList = new LinkedList<>() ;

        private List<List<Integer>> permute(int[] nums) {
            boolean s = false ;
            Arrays.sort(nums);
            List<Integer> line = null ;

            while(!s) {
                line = new LinkedList<Integer>();
                for(Integer i : nums) line.add(i) ;
                ansList.add(line) ;
                s = nextPermutation(nums);
            }

            return ansList ;
        }

        private boolean nextPermutation(int[] nums) {
            // from right to left finding the ascending num
            int nodePos = -1 ;
            for(int index=nums.length-2; index>=0; index--) {
                if (nums[index]<nums[index+1]) {
                    nodePos=index ;
                    break ;
                }
            }

            // to do something
            if (nodePos<0) {
                int l=0; int r=nums.length-1 ;
                while(l<r) {
                    int swap = nums[l] ;
                    nums[l] = nums[r] ;
                    nums[r] = swap ;
                    l++; r--;
                }
                return true;
            }

            int minVal=Integer.MAX_VALUE; int minPos=-1 ;
            for(int i=nodePos; i<nums.length; i++) {
                if (nums[i] > nums[nodePos] && minVal > nums[i]) {
                    minPos = i ;
                    minVal = nums[i] ;
                }
            }

            nums[minPos] = nums[nodePos] ;
            nums[nodePos] = minVal ;

            Arrays.sort(nums, nodePos+1, nums.length);

            return false;
        }
    }
}
