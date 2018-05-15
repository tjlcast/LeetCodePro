package TwoPointers;

/**
 * Created by tangjialiang on 17/5/9.
 */
public class _27_Remove_Element {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3}; int val = 3 ;
        int work = new _27_Remove_Element().work(nums, val);
        System.out.println(work);
        System.out.println(nums);
    }

    public int work(int[] nums, int val) {
        return new Solution().removeElement(nums, val) ;
    }

    public class Solution {
        public int removeElement(int[] nums, int val) {
            int count= 0 ;
            int pos = 0 ;
            int orderPos = 0 ;
            while(pos < nums.length) {
                int num = nums[pos] ;
                if (num != val) {
                    count++ ;
                    nums[orderPos] = num ;
                    orderPos++ ;
                }

                // next step
                pos++ ;
            }

            return count ;
        }
    }
}
