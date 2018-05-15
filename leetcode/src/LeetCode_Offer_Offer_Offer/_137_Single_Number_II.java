package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/12/5.
 */
public class _137_Single_Number_II {
    /**
     * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

     Note:
     Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

     tips: http://www.jianshu.com/p/758e799614b2
     */

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 2, 4, 4, 4} ;

        Solution solution = new Solution();
        int i = solution.singleNumber(nums);

        System.out.println("work is : " + i) ;
    }

    static class Solution {
        public int singleNumber(int[] nums) {
            int one = 0 ;
            int two = 0 ;
            int three = 0 ;

            for(int i=0; i<nums.length; i++) {
                two = two | (one & nums[i]) ; // 当新来的为0时，two = two | 0，two不变，当新来的为1时，（当one此时为0，则two = two|0，two不变；当one此时为1时，则two = two | 1，two变为1)
                one = one ^ nums[i] ; // #新来的为0，one不变，新来为1时，one是0、1交替改变

                // 当进位到第三位时，其他几位应该设为0
                three = one & two ; // #当one和two为1是，three为1（此时代表要把one和two清零了）
                one = (~three) & one ; // 把one清0
                two = (~three) & two ; // 把two清0
            }

            return one ;
        }
    }

    static class Solution2 {
        public int singleNumber(int[] nums) {
            int length = nums.length ;
            int result = 0 ;

            for(int i=0; i<31; i++) {
                int count = 0 ;
                int mask = 1 << i ;

                for(int j=0; j<length; j++) {
                    if ((nums[j] & mask) != 0) {
                        count++ ;
                    }
                }

                if (count % 3 != 0) {
                    result |= mask ;
                }
            }
            return result ;
        }
    }
}
