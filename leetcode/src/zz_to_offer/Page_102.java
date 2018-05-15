package zz_to_offer;

/**
 * Created by tangjialiang on 2017/8/24.
 */
public class Page_102 {
    /**
     * 输入一个整数数组，实现一个函数来调整来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7} ;
        new Page_102().work(nums);
    }

    public void work(int[] nums) {
        new MySolution().reorderOddEven(nums);
        new MySolution().showDatas(nums);
    }

    class MySolution {
        public void reorderOddEven(int[] nums) {
            int pLeft = 0 ;
            int pRight = nums.length-1;

            while(pLeft < pRight) {
                // find the even num position from left
                while(pLeft < nums.length && nums[pLeft]%2==0) { pLeft++; }

                // find the odd num position from right
                while(pRight >= 0 && nums[pRight]%2!=0) { pRight--; }

                if (!(pLeft < pRight)) continue;
                // change the wrong position nums' positions.
                int tmp = nums[pLeft] ;
                nums[pLeft] = nums[pRight] ;
                nums[pRight] = tmp ;
            }
        }

        public void showDatas(int[] nums) {
            for(int n : nums) {
                System.out.print(n + " ") ;
            }
        }
    }
}
