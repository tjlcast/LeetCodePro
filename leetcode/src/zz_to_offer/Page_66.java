package zz_to_offer;

/**
 * Created by tangjialiang on 2017/8/22.
 */
public class Page_66 {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾 =》数组的旋转。
     * 输入一个旋转数组，找到这个数组的最小值。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {23, 24, 55, 11, 12, 15,19} ;
        int work = new Page_66().work(nums);
        System.out.println("work is: " + work) ;
    }

    public int work(int[] nums) {
        return new MySolution().findMinNum(nums);
    }

    class MySolution {
        /**
         * tips:    在进行中值判断的时候，注意当范围缩为2时因为向下取整带来的问题。
         *          通过加入排除范围来处理。
         */
        int findMinNum(int[] nums) {
            return find(nums, 0, nums.length-1) ;
        }

        private int find(int[] nums, int begin, int end) {
            if (begin == end) {
                return nums[begin] ;
            }
            System.out.println("begn: " + begin + " end: " + end) ;

            int mid = (begin + end) / 2;
            int midNum = nums[mid] ;
            int leftNum = nums[begin] ;
            int rightNum = nums[end] ;

            if (midNum >= leftNum)
                return find(nums, mid+1, end) ;
            else
                return find(nums, begin, mid) ;
        }
    }
}
