package TwoPointers;

/**
 * Created by tangjialiang on 17/5/9.
 */
public class _Remove_Duplicates_from_Sorted_Array
{
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 4, 4} ;
        int work = new _Remove_Duplicates_from_Sorted_Array().work(nums);
        System.out.println(work);
    }

    public int work(int[] nums) {
        return new Solution().removeDuplicates(nums) ;
    }

    public class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums==null) return 0 ;

            int orderPos = 0 ;
            int count = 0 ;

            int pos = 0 ;
            while(pos < nums.length) {
                count++ ;

                // next step
                int val = nums[pos] ;
                nums[orderPos++] = val ;
                pos++ ;
                while(pos < nums.length && val==nums[pos]) pos++ ;
            }

            return count ;
        }
    }
}
