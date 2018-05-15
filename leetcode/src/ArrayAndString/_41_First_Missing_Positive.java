package ArrayAndString;

/**
 * Created by tangjialiang on 2017/5/25.
 *
 */
public class _41_First_Missing_Positive {

    public static void main(String[] args) {
        int[] nums = {1, 1} ;

        int work = new _41_First_Missing_Positive().work(nums);
        System.out.println(work) ;

    }

    public int work(int[] nums) {
        return new Solution().firstMissingPositive(nums) ;
    }

    public class Solution {
        int firstMissingPositive(int[] nums) {

            for(int i=0; i<nums.length; i++) {
                while (nums[i] != i+1 && nums[i]>0 && nums[i]-1 < nums.length) {
                    int val = nums[i] ;
                    if (val - 1 < 0 ) continue ;
                    if (nums[i]==nums[val-1]) break ;
                    int temp = nums[val-1] ;
                    nums[val-1] = nums[i] ;
                    nums[i] = temp ;
                }
            }


            for(int i=0; i<nums.length; i++) {
                if (nums[i] != i+1) return i+1 ;
            }

            return nums.length+1 ;
        }
    }
}
