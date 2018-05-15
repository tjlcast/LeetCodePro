package ArrayAndString;

import java.util.Arrays;

/**
 * Created by tangjialiang on 17/5/10.
 */
public class _31_Next_Permutation {
    public static void main(String[] args){

    }

    public void work(int[] nums) {

    }

    public class Solution {
        public void nextPermutation(int[] nums) {
            int i = nums.length-1 ;
            for(; i>0; i--) {
                if (nums[i-1] < nums[i]) {
                    break ;
                }
            }

            // System.out.println("i:" + i) ;

            if (i==0) {
                Arrays.sort(nums);
                return ;
            }

            int pos = i ;
            for(int j=i; j<nums.length; j++) {
                if (nums[j] > nums[i-1] && nums[j] < nums[pos]) {pos=j;}
            }

            int swap = nums[i-1] ;
            nums[i-1] = nums[pos] ;
            nums[pos] = swap ;

            Arrays.sort(nums, i, nums.length);
        }
    }
}
