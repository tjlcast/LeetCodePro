package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/5.
 */
public class _46_Permutations {
    /**
     * Given a collection of distinct numbers, return all possible permutations.

     For example,
     [1,2,3] have the following permutations:
     [
     [1,2,3],
     [1,3,2],
     [2,1,3],
     [2,3,1],
     [3,1,2],
     [3,2,1]
     ]
     */

    public static void main(String[] args) {
        int[] nums = {1,1,2} ;
        _46_Permutations permutations = new _46_Permutations();
        List<List<Integer>> work = permutations.work(nums);

        System.out.println("work is: ") ;
        for(List<Integer> line : work) {
            for(Integer i : line)
                System.out.print(i + " ") ;
            System.out.println() ;
        }
    }

    public List<List<Integer>> work(int[] nums) {
        Solution solution = new Solution();
        List<List<Integer>> permute = solution.permute(nums);
        return permute ;
    }

    class Solution {
        private List<List<Integer>> ansList = new LinkedList<>() ;

        public List<List<Integer>> permute(int[] nums) {
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
