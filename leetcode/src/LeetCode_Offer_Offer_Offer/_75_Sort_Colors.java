package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/9/11.
 */
public class _75_Sort_Colors {
    /**
     * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
     * with the colors in the order red, white and blue.

     Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

     Note:
     You are not suppose to use the library's sort function for this problem.

     click to show follow up.

     Follow up:
     A rather straight forward solution is a two-pass algorithm using counting sort.
     First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, t
     hen 1's and followed by 2's.

     Could you come up with an one-pass algorithm using only constant space?
     */

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 0, 2} ;

        _75_Sort_Colors sort_colors = new _75_Sort_Colors();
        sort_colors.work(nums);

        System.out.println("work is: ") ;
        for(Integer i : nums) System.out.print(i + " ") ;
    }

    public void work(int[] nums) {
        Solution solution = new Solution();
        solution.sortColors(nums);

        return ;
    }

    class Solution {
        public void sortColors(int[] nums) {
            int len0 = 0 ;
            int len1 = 0 ;
            int len2 = 0 ;

            for(int i=0; i<nums.length; i++) {
                if (nums[i] == 0) {
                    len0 += 1 ;
                }
                if (nums[i] == 1) {
                    len1 += 1 ;
                }
                if (nums[i] == 2) {
                    len2 += 1 ;
                }
            }

            int pos = 0 ;
            while(len0!=0) {
                nums[pos++] = 0 ;
                len0-- ;
            }

            while(len1!=0) {
                nums[pos++] = 1;
                len1-- ;
            }

            while(len2!=0) {
                nums[pos++] = 2 ;
                len2-- ;
            }
        }
    }
}
